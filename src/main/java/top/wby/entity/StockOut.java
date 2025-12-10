package top.wby.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("stock_out")
@ApiModel(value = "StockOut对象", description = "")
public class StockOut implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 出库单号
     */
    @ApiModelProperty("出库单号")
    private String orderNo;

    /**
     * 出库类型 1-销售出库 2-领料出库 3-调拨出库
     */
    @ApiModelProperty("出库类型 1-销售出库 2-领料出库 3-调拨出库")
    private Byte type;

    /**
     * 客户ID
     */
    @ApiModelProperty("客户ID")
    private Integer customerId;

    /**
     * 仓库ID
     */
    @ApiModelProperty("仓库ID")
    private Integer warehouseId;

    /**
     * 状态 1-待审核 2-已完成 3-已取消
     */
    @ApiModelProperty("状态 1-待审核 2-已完成 3-已取消")
    private Byte status;

    /**
     * 总金额
     */
    @ApiModelProperty("总金额")
    private BigDecimal totalAmount;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private Integer createBy;

    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private Integer updateBy;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
