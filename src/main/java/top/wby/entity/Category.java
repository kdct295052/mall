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
 * 货品分类表
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
@Data
@ApiModel(value = "Category对象", description = "货品分类表")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CategoryID", type = IdType.AUTO)
    private Integer categoryID;

    @TableField("CategoryName")
    private String categoryName;

    @TableField("Description")
    private String description;

    @TableField("CreateTime")
    private LocalDateTime createTime;
}
