package top.wby.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.wby.entity.StockOut;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wby
 * @since 2025-12-09
 */
@Mapper
public interface StockOutMapper extends BaseMapper<StockOut> {

    IPage<StockOut> pageCC(IPage<StockOut> page,@Param("ew")  Wrapper<StockOut> wrapper);
}
