package top.wby.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wby.common.QueryPageParam;
import top.wby.common.Result;
import top.wby.entity.Item;
import top.wby.service.IItemService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private IItemService itemService;

    @GetMapping("/list")
    public Result list() {
        List<Item> list = itemService.list();
        return Result.success(list);
    }
    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        Page<Item> page = new Page<>(query.getPageNum(), query.getPageSize());

        LambdaQueryWrapper<Item> queryWrapper = new LambdaQueryWrapper<>();

        // 根据名称模糊查询
        if (query.getParams().containsKey("name") &&
                query.getParams().get("name") != null &&
                !query.getParams().get("name").toString().isEmpty()) {
            queryWrapper.like(Item::getName, query.getParams().get("name").toString());
        }

        // 根据SKU编码精确查询
        if (query.getParams().containsKey("itemCode") &&
                query.getParams().get("itemCode") != null &&
                !query.getParams().get("itemCode").toString().isEmpty()) {
            queryWrapper.eq(Item::getItemCode, query.getParams().get("itemCode").toString());
        }

        // 根据是否启用状态查询
        if (query.getParams().containsKey("isActive") &&
                query.getParams().get("isActive") != null) {
            queryWrapper.eq(Item::getIsActive, query.getParams().get("isActive"));
        }

        IPage<Item> result = itemService.page(page, queryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
    @GetMapping("/get/{id}")
    public Result getById(@PathVariable Integer id) {
        Item item = itemService.getById(id);
        if (item != null) {
            return Result.success(item);
        } else {
            return Result.fail("货品不存在");
        }
    }
    @PostMapping("/save")
    public Result save(@RequestBody Item item) {
        // 检查SKU编码是否已存在
        LambdaQueryWrapper<Item> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Item::getItemCode, item.getItemCode());
        if (itemService.count(queryWrapper) > 0) {
            return Result.fail("SKU编码已存在");
        }

        boolean result = itemService.save(item);
        if (result) {
            return Result.success(item, "新增成功");
        } else {
            return Result.fail("新增失败");
        }
    }
    @PostMapping("/update")
    public Result update(@RequestBody Item item) {
        boolean result = itemService.updateById(item);
        if (result) {
            return Result.success(item, "更新成功");
        } else {
            return Result.fail("更新失败");
        }
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = itemService.removeById(id);
        if (result) {
            return Result.success(null, "删除成功");
        } else {
            return Result.fail("删除失败");
        }
    }

}
