package top.wby.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author wby
 * @since 2025-12-09
 */
@Data
@TableName("stock_out_detail")
@ApiModel(value = "StockOutDetail对象", description = "")
public class StockOutDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 出库单ID
     */
    @ApiModelProperty("出库单ID")
    private Integer orderId;

    /**
     * 货品ID
     */
    @ApiModelProperty("货品ID")
    private Integer itemId;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Integer quantity;

    /**
     * 单价
     */
    @ApiModelProperty("单价")
    private BigDecimal price;

    /**
     * 金额
     */
    @ApiModelProperty("金额")
    private BigDecimal amount;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
