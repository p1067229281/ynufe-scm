package com.ynufe.scm.model.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <pre>
 *     社团负责人
 * </pre>
 * @author william
 * @date 2019/05/17
 *
 */
@Data
@Entity
@Table(name="scm_leader")
public class Leader implements Serializable {

    /**
     * 社团负责人(学生主席)id
     */
    @Id
    @GenericGenerator(name = "generator-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "generator-uuid")
    private String leaderId;

    /**
     * 社团负责人姓名
     */
    @NotBlank(message = "社团负责人姓名不能为空")
    private String leaderName;

    /**
     * 所属专业
     */
    private String major;

    /**
     * 所属班级(不能使用class,改用studentClass)
     */
    private String studentClass;

    /**
     * 电话号码
     */
    @NotBlank(message = "社团负责人电话号码不能为空")
    private String phoneNum;

    /**
     * QQ号码
     */
    private String qqNum;

    /**
     * 一个负责人对应一个个社团
     */
    @OneToOne
    @JoinColumn(name = "club_id")
    private Club club;

    /**
     * 负责人头像
     */
    private String leaderAvatar;

    @Override
    public String toString() {
        return "Leader{" +
                "leaderId='" + leaderId + '\'' +
                ", leaderName='" + leaderName + '\'' +
                ", major='" + major + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", qqNum='" + qqNum + '\'' +
                ", leaderAvatar='" + leaderAvatar + '\'' +
                '}';
    }
}
