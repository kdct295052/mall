package top.wby.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 仓库主表
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
@Data
@ApiModel(value = "Warehouse对象", description = "仓库主表")
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "WarehouseID", type = IdType.AUTO)
    private Integer warehouseID;

    private String name;

    /**
     * 物理位置描述
     */
    @ApiModelProperty("物理位置描述")
    private String location;

    /**
     * 负责人UserID
     */
    @ApiModelProperty("负责人UserID")
    @TableField("managerID")
    private Integer managerID;

    private String status;
}
