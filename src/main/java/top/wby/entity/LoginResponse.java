package top.wby.entity;

import top.wby.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LoginResponse", description = "登录响应数据")
public class LoginResponse {

    @ApiModelProperty("用户ID")
    private Integer id;

    @ApiModelProperty("账号")
    private String no;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("角色ID")
    private Integer roleId;

    @ApiModelProperty("是否有效")
    private String isValid;

    @ApiModelProperty("访问令牌")
    private String token;

    public LoginResponse(User user) {
        this.id = user.getId();
        this.no = user.getNo();
        this.name = user.getName();
        this.age = user.getAge();
        this.sex = user.getSex();
        this.phone = user.getPhone();
        this.roleId = user.getRoleId();
        this.isValid = user.getIsValid();
        // 生成简单token，实际项目中应使用JWT等机制
        this.token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." + System.currentTimeMillis();
    }
}
