package top.wby.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.wby.entity.User;
import top.wby.entity.Warehouse;

/**
 * <p>
 * 仓库主表 Mapper 接口
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
@Mapper
public interface WarehouseMapper extends BaseMapper<Warehouse> {
    IPage<Warehouse> pageCC(IPage<Warehouse> page, @Param("ew") Wrapper wapper);
}
