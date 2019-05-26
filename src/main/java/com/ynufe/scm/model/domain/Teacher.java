package com.ynufe.scm.model.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 *     指导教师
 * </pre>
 * @author william
 * @date 2019/05/18
 *
 */
@Data
@Entity
@Table(name = "scm_teacher")
public class Teacher implements Serializable {

    /*
     * 教师id
     */
    @Id
    @GenericGenerator(name = "generator-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "generator-uuid")
    private String techId;

    /**
     * 教师姓名
     */
    private String techName;

    /**
     * 教师所属学院
     */
    private String academic;

    /**
     * 教师指导的社团
     */
    @OneToOne()
    @JoinColumn(name = "club_id")
    private Club club;


    @Override
    public String toString() {
        return "Teacher{" +
                "techId='" + techId + '\'' +
                ", techName='" + techName + '\'' +
                ", academic='" + academic + '\'' +
                '}';
    }
}
