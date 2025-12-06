package top.wby.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.wby.entity.Suppliercustomer;
import com.baomidou.mybatisplus.extension.service.IService;
import top.wby.entity.User;

/**
 * <p>
 * 供应商/客户表 服务类
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
public interface ISuppliercustomerService extends IService<Suppliercustomer> {

    public IPage<Suppliercustomer> pageCC(IPage<Suppliercustomer> ipage, Wrapper<Suppliercustomer> wrapper);
}
