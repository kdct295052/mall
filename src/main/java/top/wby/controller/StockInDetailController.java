package top.wby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wby.common.Result;
import top.wby.entity.Item;
import top.wby.entity.StockInDetail;
import top.wby.service.IItemService;
import top.wby.service.IStockInDetailService;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/stockInDetail")
public class StockInDetailController {
    @Autowired
    private IStockInDetailService stockInDetailService;
    @Autowired
    private IItemService itemService;
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        StockInDetail detail = stockInDetailService.getById(id);
        if (detail == null) {
            return Result.fail("未找到对应的入库明细");
        }

        // 获取关联的货品信息
        Item item = itemService.getById(detail.getItemId());
        if (item == null) {
            return Result.fail("未找到关联的货品信息");
        }

        // 构建返回数据
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("id", detail.getId());
        resultData.put("itemName", item.getName());        // 货品名称
        resultData.put("itemCode", item.getItemCode());    // 货品编码
        resultData.put("quantity", detail.getQuantity());   // 数量
        resultData.put("price", detail.getPrice());         // 单价
        resultData.put("amount", detail.getAmount());       // 金额
        resultData.put("remark", detail.getRemark());       // 备注

        return Result.success(resultData);
    }

}
