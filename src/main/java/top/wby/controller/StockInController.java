package top.wby.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wby.common.QueryPageParam;
import top.wby.common.Result;
import top.wby.dto.StockInDTO;
import top.wby.entity.StockIn;
import top.wby.entity.StockInDetail;
import top.wby.service.IStockInService;

import java.util.List;
import java.util.stream.Collectors;


// StockInController.java
@RestController
@RequestMapping("/stock/in")
public class StockInController {

    @Autowired
    private IStockInService stockInService;

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        Page<StockIn> page = new Page<>(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<StockIn> queryWrapper = new LambdaQueryWrapper<>();

        // 根据订单号模糊查询
        if (query.getParams().containsKey("orderNo") &&
            query.getParams().get("orderNo") != null) {
            queryWrapper.like(StockIn::getOrderNo, query.getParams().get("orderNo"));
        }

        // 根据状态查询
        if (query.getParams().containsKey("status") &&
            query.getParams().get("status") != null) {
            queryWrapper.eq(StockIn::getStatus, query.getParams().get("status"));
        }

        IPage<StockIn> result = stockInService.pageCC(page, queryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result add(@RequestBody StockInDTO stockInDTO) {
        try {
            StockIn stockIn = new StockIn();
            stockIn.setType(stockInDTO.getType());
            stockIn.setSupplierId(stockInDTO.getSupplierId());
            stockIn.setWarehouseId(stockInDTO.getWarehouseId()); // 确保设置warehouseId
            stockIn.setRemark(stockInDTO.getRemark());

            // 转换明细
            List<StockInDetail> details = stockInDTO.getDetails().stream().map(dto -> {
                StockInDetail detail = new StockInDetail();
                detail.setItemId(dto.getItemId());
                detail.setQuantity(dto.getQuantity());
                detail.setPrice(dto.getPrice());
                detail.setRemark(dto.getRemark());
                return detail;
            }).collect(Collectors.toList());

            boolean result = stockInService.addStockIn(stockIn, details);
            return result ? Result.success("添加成功") : Result.fail("添加失败");
        } catch (Exception e) {
            return Result.fail("添加失败: " + e.getMessage());
        }
    }

    @PostMapping("/approve/{id}")
    public Result approve(@PathVariable Integer id) {
        boolean result = stockInService.approveStockIn(id);
        return result ? Result.success("审核成功") : Result.fail("审核失败");
    }
}
