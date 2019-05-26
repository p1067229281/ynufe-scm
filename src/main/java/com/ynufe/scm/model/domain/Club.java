package com.ynufe.scm.model.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     社团信息
 * </pre>
 * @author william
 * @date 2019/05/17
 *
 */
@Data
@Entity
@Table(name = "scm_club")
@ToString
public class Club implements Serializable {

    @Id
    @GenericGenerator(name = "generator-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "generator-uuid")
    private String clubId;

    /**
     * 社团名
     */
    private String clubName;

    /**
     * 指导单位
     */
    private String guide;

    /**
     * 一个社团只有一个负责人
     */
    @OneToOne(mappedBy = "club",cascade = {CascadeType.ALL})
    private Leader leader;

    /**
     * 指导教师
     */
    @OneToOne(mappedBy = "club",cascade = {CascadeType.ALL})
    private Teacher teacher;

    /**
     * 社团部门 可能有多个
     */
    private String department;

    /**
     * 社团简介
     */
    @Lob
    private String clubDetail;

    /**
     * 社团文化
     */
    @Lob
    private String clubCulture;

    /**
     * 社团发展历程
     */
    @Lob
    private String devHis;

    /**
     * 社团荣耀
     */
    @Lob
    private String clubGlory;

    /**
     * 社团徽标 存地址
     */
    private String clubLogo;

    /**
     * 社团备注
     */
    private String remarks;

    /**
     * 社团历史活动
     */
    @OneToMany(mappedBy = "club", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Activitis> activitis = new ArrayList<>();

}
