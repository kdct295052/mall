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
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author wby
 * @since 2025-12-09
 */
@Data
@ApiModel(value = "StockIn对象", description = "入库单")
public class StockIn implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("入库单号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty("入库类型 1-采购入库 2-退货入库 3-调拨入库")
    private Integer type;

    @ApiModelProperty("供应商ID")
    @TableField("supplier_id")
    private Integer supplierId;

    @ApiModelProperty("仓库ID")
    @TableField("warehouse_id")
    private Integer warehouseId;

    @ApiModelProperty("状态 1-待审核 2-已完成 3-已取消")
    private Integer status = 1;

    @ApiModelProperty("总金额")
    @TableField("total_amount")
    private BigDecimal totalAmount;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建人")
    @TableField("create_by")
    private Integer createBy;

    @ApiModelProperty("更新人")
    @TableField("update_by")
    private Integer updateBy;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
