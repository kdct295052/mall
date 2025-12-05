package top.wby.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wby.common.QueryPageParam;
import top.wby.common.Result;
import top.wby.entity.User;
import top.wby.entity.Warehouse;
import top.wby.mapper.WarehouseMapper;
import top.wby.service.IWarehouseService;

import java.util.List;

/**
 * <p>
 * 仓库主表 前端控制器
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private IWarehouseService warehouseService;
    @GetMapping("/list")
    public Result list() {
        return Result.success(warehouseService.list());
    }
    @PostMapping("/add")
    public Result add(Warehouse warehouse) {
        return Result.success(warehouseService.save(warehouse));
    }
    @PostMapping("/update")
    public Result update(Warehouse warehouse) {
        return Result.success(warehouseService.updateById(warehouse));
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(warehouseService.removeById(id));
    }
    @PostMapping("/listPageC")
    public Result listPageC(@RequestBody QueryPageParam query) {
        Page<Warehouse> userPage = new Page<>();
        userPage.setCurrent(query.getPageNum());
        userPage.setSize(query.getPageSize());
        LambdaQueryWrapper<Warehouse> WarehouseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (query.getParams().containsKey("name") && query.getParams().get("name") != null){
            WarehouseLambdaQueryWrapper.like(Warehouse::getName,query.getParams().get("name"));
        }
        if (query.getParams().containsKey("status") && query.getParams().get("status") != null){
            WarehouseLambdaQueryWrapper.eq(Warehouse::getStatus,query.getParams().get("status"));
        }
        IPage<Warehouse> page = warehouseService.pageCC(userPage,WarehouseLambdaQueryWrapper);
        System.out.println("total"+page.getTotal());
        return Result.success(page.getRecords(),page.getTotal());
    }
}
