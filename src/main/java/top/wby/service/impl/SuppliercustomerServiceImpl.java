package top.wby.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import top.wby.entity.Suppliercustomer;
import top.wby.mapper.SuppliercustomerMapper;
import top.wby.service.ISuppliercustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 供应商/客户表 服务实现类
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
@Service
public class SuppliercustomerServiceImpl extends ServiceImpl<SuppliercustomerMapper, Suppliercustomer> implements ISuppliercustomerService {
    @Resource
    private SuppliercustomerMapper suppliercustomerMapper;
    @Override
    public IPage<Suppliercustomer> pageCC(IPage<Suppliercustomer> ipage, Wrapper<Suppliercustomer> wrapper) {
        return suppliercustomerMapper.pageCC(ipage,wrapper);

    }
}
