package top.wby.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.wby.entity.StockInDetail;

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
public interface StockInDetailMapper extends BaseMapper<StockInDetail> {
    List<StockInDetail> selectByOrderId(@Param("orderId") Integer orderId);
}
