package top.wby.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
    private String name;

    private String type;

    private String contactName;

    private String phone;

    private String address;

    private LocalDateTime createTime;
}
