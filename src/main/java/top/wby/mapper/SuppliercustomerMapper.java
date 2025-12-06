package top.wby.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.wby.entity.Suppliercustomer;

/**
 * <p>
 * 供应商/客户表 Mapper 接口
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
@Mapper
public interface SuppliercustomerMapper extends BaseMapper<Suppliercustomer> {
    IPage<Suppliercustomer> pageCC(IPage<Suppliercustomer> ipage, @Param("ew") Wrapper<Suppliercustomer> wrapper);
}
