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
 * 
 * </p>
 *
 * @author wby
 * @since 2025-11-26
 */
@Data
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String no;

    /**
     * 名字
     */
    @ApiModelProperty("名字")
    private String name;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    private Integer age;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Integer sex;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String phone;

    /**
     * 角色 0超级管理员, 1管理员, 2普通账号
     */
    @ApiModelProperty("角色 0超级管理员, 1管理员, 2普通账号")
    private Integer roleId;

    /**
     * 是否有效, Y有效, 其他无效
     */
    @ApiModelProperty("是否有效, Y有效, 其他无效")
    @TableField("isValid")
    private String isValid;
}
