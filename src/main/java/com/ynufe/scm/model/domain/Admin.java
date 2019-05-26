package com.ynufe.scm.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *     管理员
 * </pre>
 * @author william
 * @date 2019/05/17
 *
 */
@Data
@Entity
@Table(name = "scm_admin")
public class Admin implements Serializable {

    /**
     * 编号
     */
    @Id
    @GenericGenerator(name = "generator-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "generator-uuid")
    private String userId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @JsonIgnore
    private String userName;

    /**
     * 显示名称
     */
    private String userDisplayName;

    /**
     * 密码
     */
    @JsonIgnore
    private String userPass;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String userEmail;

    /**
     * 头像
     */
    private String userAvatar;

    /**
     * 说明
     */
    private String userDesc;

    /**
     * 是否禁用登录
     */
    @JsonIgnore
    private String loginEnable = "true";

    /**
     * 最后一次登录时间
     */
    @JsonIgnore
    private Date loginLast;

    /**
     * 登录错误次数记录
     */
    @JsonIgnore
    private Integer loginError = 0;
}
