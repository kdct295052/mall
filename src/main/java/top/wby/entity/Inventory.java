package top.wby.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 库存总表 - 实时库存数量追踪
 * </p>
 *
 * @author wby
 * @since 2025-12-09
 */
@Data
@ApiModel(value = "Inventory对象", description = "库存总表 - 实时库存数量追踪")
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "InventoryID", type = IdType.AUTO)
    private Long inventoryID;

    /**
     * 商品ID，关联 item 表
     */
    @ApiModelProperty("商品ID，关联 item 表")
    private Integer itemID;

    /**
     * 仓库ID，关联 warehouse 表
     */
    @ApiModelProperty("仓库ID，关联 warehouse 表")
    private Integer warehouseID;

    /**
     * 批次号（如果需要追踪）
     */
    @ApiModelProperty("批次号（如果需要追踪）")
    private String batchNumber;

    /**
     * 当前库存数量
     */
    @ApiModelProperty("当前库存数量")
    private BigDecimal quantity;

    /**
     * 最后更新时间
     */
    @ApiModelProperty("最后更新时间")
    private LocalDateTime lastUpdated;
}
