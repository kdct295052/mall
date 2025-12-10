package top.wby.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockInDetailDTO {

    @ApiModelProperty("货品ID")
    private Integer itemId;

    @ApiModelProperty("数量")
    private Integer quantity;

    @ApiModelProperty("单价")
    private BigDecimal price;

    @ApiModelProperty("备注")
    private String remark;
}
