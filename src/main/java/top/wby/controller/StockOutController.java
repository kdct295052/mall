package top.wby.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wby.common.QueryPageParam;
import top.wby.common.Result;
import top.wby.dto.StockOutDTO;
import top.wby.entity.StockOut;
import top.wby.entity.StockOutDetail;
import top.wby.service.IStockOutService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stock/out")
public class StockOutController {

    @Autowired
    private IStockOutService stockOutService;

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        Page<StockOut> page = new Page<>(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<StockOut> queryWrapper = new LambdaQueryWrapper<>();

        // 根据订单号模糊查询
        if (query.getParams().containsKey("orderNo") &&
            query.getParams().get("orderNo") != null) {
            queryWrapper.like(StockOut::getOrderNo, query.getParams().get("orderNo"));
        }

        // 根据状态查询
        if (query.getParams().containsKey("status") &&
            query.getParams().get("status") != null) {
            queryWrapper.eq(StockOut::getStatus, query.getParams().get("status"));
        }

        IPage<StockOut> result = stockOutService.pageCC(page, queryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result add(@RequestBody StockOutDTO stockOutDTO) {
        try {
            StockOut stockOut = new StockOut();
            stockOut.setType(stockOutDTO.getType());
            stockOut.setCustomerId(stockOutDTO.getCustomerId());
            stockOut.setWarehouseId(stockOutDTO.getWarehouseId());
            stockOut.setRemark(stockOutDTO.getRemark());

            List<StockOutDetail> details = stockOutDTO.getDetails().stream().map(dto -> {
                StockOutDetail detail = new StockOutDetail();
                detail.setItemId(dto.getItemId());
                detail.setQuantity(dto.getQuantity());
                detail.setPrice(dto.getPrice());
                detail.setRemark(dto.getRemark());
                return detail;
            }).collect(Collectors.toList());

            boolean result = stockOutService.addStockOut(stockOut, details);
            return result ? Result.success("添加成功") : Result.fail("添加失败");
        } catch (Exception e) {
            return Result.fail("添加失败: " + e.getMessage());
        }
    }

    @PostMapping("/approve/{id}")
    public Result approve(@PathVariable Integer id) {
        boolean result = stockOutService.approveStockOut(id);
        return result ? Result.success("审核成功") : Result.fail("审核失败");
    }
}
