package top.wby.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel(value = "StockOutDTO", description = "出库单传输对象")
public class StockOutDTO {

    @ApiModelProperty("出库类型 1-销售出库 2-领料出库 3-调拨出库")
    private Byte type;

    @ApiModelProperty("客户ID")
    private Integer customerId;

    @ApiModelProperty("仓库ID")
    private Integer warehouseId;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("出库明细列表")
    private List<StockOutDetailDTO> details;
}
