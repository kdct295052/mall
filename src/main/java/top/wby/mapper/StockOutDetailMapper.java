package top.wby.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.wby.entity.StockInDetail;
import top.wby.entity.StockOutDetail;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wby
 * @since 2025-12-09
 */
@Mapper
public interface StockOutDetailMapper extends BaseMapper<StockOutDetail> {
    List<StockOutDetail> selectByOrderId(@Param("orderId") Integer orderId);

}
