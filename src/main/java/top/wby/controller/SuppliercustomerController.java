package top.wby.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wby.common.QueryPageParam;
import top.wby.common.Result;
import top.wby.entity.Suppliercustomer;
import top.wby.service.ISuppliercustomerService;


@RestController
@RequestMapping("/suppliercustomer")
public class SuppliercustomerController {
    @Autowired
    private ISuppliercustomerService suppliercustomerService;
    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        Page<Suppliercustomer> suppliercustomerPage = new Page<>();
        suppliercustomerPage.setCurrent(query.getPageNum());
        suppliercustomerPage.setSize(query.getPageSize());
        LambdaQueryWrapper<Suppliercustomer> suppliercustomerLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (query.getParams().containsKey("name")&&query.getParams().get("name")!=null){
            suppliercustomerLambdaQueryWrapper.like(Suppliercustomer::getName, query.getParams().get("name"));
        }
        IPage<Suppliercustomer> suppliercustomerIPage = suppliercustomerService.pageCC(suppliercustomerPage, suppliercustomerLambdaQueryWrapper);

        return Result.success(suppliercustomerIPage.getRecords(),suppliercustomerIPage.getTotal());
    }
    @PostMapping("/save")
    public Result save(@RequestBody Suppliercustomer suppliercustomer) {
        return suppliercustomerService.save(suppliercustomer) ? Result.success(true) : Result.fail(false);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody Suppliercustomer suppliercustomer) {
        return suppliercustomerService.removeById(suppliercustomer) ? Result.success(true) : Result.fail(false);
    }
    @PostMapping("/update")
    public Result update(@RequestBody Suppliercustomer suppliercustomer) {
        return suppliercustomerService.updateById(suppliercustomer) ? Result.success(true) : Result.fail(false);
    }

}
