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
    public Result add(@RequestBody Warehouse warehouse) {
       try {
           if (warehouse.getName() == null || warehouse.getName().trim().isEmpty()) {
               return Result.fail("仓库名称不能为空");
           }

           // 验证 Status 字段值
           if (warehouse.getStatus() != null &&
                   !warehouse.getStatus().matches("^(Operational|Maintenance|Closed)$")) {
               return Result.fail("状态值必须为 Operational, Maintenance 或 Closed");
           }

           // 设置默认状态
           if (warehouse.getStatus() == null) {
               warehouse.setStatus("Operational");
           }
           LambdaQueryWrapper<Warehouse> queryWrapper = new LambdaQueryWrapper<>();
           queryWrapper.eq(Warehouse::getName, warehouse.getName());
           if (warehouseService.count(queryWrapper) > 0) {
               return Result.fail("仓库名称已存在");
           }

           boolean saved = warehouseService.save(warehouse);
           if (saved) {
               return Result.success("添加成功");
           } else {
               return Result.fail("添加失败");
           }
       } catch (Exception e) {
           return Result.fail("添加失败: " + e.getMessage());
       }
    }
    @PostMapping("/update")
    public Result update(@RequestBody Warehouse warehouse) {
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
