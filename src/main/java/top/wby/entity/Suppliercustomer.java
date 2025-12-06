package top.wby.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 供应商/客户表
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
@Data
@ApiModel(value = "Suppliercustomer对象", description = "供应商/客户表")
public class Suppliercustomer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PartyID", type = IdType.AUTO)
    private Integer partyID;

    /**
     * 公司/个人名称
     */
    @ApiModelProperty("公司/个人名称")
    @TableField("Name")
    private String name;
    @TableField("Type")
    private String type;
    @TableField("ContactName")
    private String contactName;
    @TableField("Phone")
    private String phone;
    @TableField("Address")
    private String address;
    @TableField("CreateTime")
    private LocalDateTime createTime;
}
