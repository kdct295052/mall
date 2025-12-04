package top.wby.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("item")
@ApiModel(value = "Item对象", description = "货品/SKU表")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("货品ID")
    @TableId(value = "ItemID", type = IdType.AUTO)
    private Integer itemId;

    @ApiModelProperty("货品唯一的SKU编码")
    @TableField("ItemCode")
    private String itemCode;

    @ApiModelProperty("货品名称")
    @TableField("Name")
    private String name;

    @ApiModelProperty("规格")
    @TableField("Specification")
    private String specification;

    @ApiModelProperty("分类ID")
    @TableField("CategoryID")
    private Integer categoryId;

    @ApiModelProperty("单位")
    @TableField("Unit")
    private String unit;

    @ApiModelProperty("安全库存量")
    @TableField("SafetyStock")
    private BigDecimal safetyStock;

    @ApiModelProperty("采购成本")
    @TableField("PurchasePrice")
    private BigDecimal purchasePrice;

    @ApiModelProperty("建议销售价格")
    @TableField("SalePrice")
    private BigDecimal salePrice;

    @ApiModelProperty("是否启用")
    @TableField("IsActive")
    private Boolean isActive;

    @ApiModelProperty("创建时间")
    @TableField("CreateTime")
    private LocalDateTime createTime;
}
