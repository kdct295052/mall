package top.wby.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "账号不能为空")
    @Size(min = 3, max = 20, message = "账号长度必须在3-20个字符之间")
    private String no;

    /**
     * 名字
     */
    @ApiModelProperty("名字")
    @NotBlank(message = "姓名不能为空")
    @Size(max = 50, message = "姓名长度不能超过50个字符")
    private String name;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度必须在6-20个字符之间")
    private String password;

    @ApiModelProperty("年龄")
    @Min(value = 0, message = "年龄不能小于0")
    @Max(value = 150, message = "年龄不能大于150")
    private Integer age;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    @NotNull(message = "性别不能为空")
    @Min(value = 0, message = "性别值不合法")
    @Max(value = 1, message = "性别值不合法")
    private Integer sex;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;

    /**
     * 角色 0超级管理员, 1管理员, 2普通账号
     */
    @ApiModelProperty("角色 0超级管理员, 1管理员, 2普通账号")
    @NotNull(message = "角色不能为空")
    @Min(value = 0, message = "角色值不合法")
    @Max(value = 2, message = "角色值不合法")
    private Integer roleId;

    /**
     * 是否有效, Y有效, 其他无效
     */
    @ApiModelProperty("是否有效, Y有效, 其他无效")
    @TableField("isValid")
    private String isValid="Y";
}
