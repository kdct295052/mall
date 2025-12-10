package top.wby.dto;// StockInDTO.java


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel(value = "StockInDTO", description = "入库单传输对象")
public class StockInDTO {

    @ApiModelProperty("入库类型 1-采购入库 2-退货入库 3-调拨入库")
    private Integer type;

    @ApiModelProperty("供应商ID")
    private Integer supplierId;

    @ApiModelProperty("仓库ID")
    private Integer warehouseId;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("入库明细列表")
    private List<StockInDetailDTO> details;
}
