package top.wby.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value = "StockInDetail对象", description = "")
public class StockInDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("入库单ID")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty("货品ID")
    @TableField("item_id")
    private Integer itemId;

    @ApiModelProperty("数量")
    private Integer quantity;

    @ApiModelProperty("单价")
    private BigDecimal price;

    @ApiModelProperty("金额")
    private BigDecimal amount;

    @ApiModelProperty("备注")
    private String remark;
}
