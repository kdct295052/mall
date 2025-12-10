package top.wby.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.wby.entity.StockIn;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wby
 * @since 2025-12-09
 */
@Mapper
public interface StockInMapper extends BaseMapper<StockIn> {
    IPage<StockIn> pageCC(IPage<StockIn> page, @Param("ew") Wrapper<StockIn> wrapper);
}
