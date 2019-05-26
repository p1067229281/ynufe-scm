package com.ynufe.scm.model.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <pre>社团活动类</pre>
 * @author william
 * @date 2018=9/05/17
 *
 */
@Data
@Entity
@Table(name = "scm_activitis")
public class Activitis implements Serializable {

    @Id
    @GenericGenerator(name = "generator-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "generator-uuid")
    private String activitiId;

    /**
     * 活动名
     */
    private String activitiName;

    /**
     * 活动简介
     */
    @Lob
    private String activitiDesc;

    /**
     * 活动开始时间
     */
    private Date startDate;

    /**
     * 活动结束时间
     */
    private Date endDate;

    /**
     * 活动由哪个社团举办
     */
    @ManyToOne(targetEntity = Club.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "club_id")
    private Club club;

    /**
     * 活动类别
     */
    private String category;

    /**
     * 活动有多张图片
     */
    @OneToMany(mappedBy = "activiti", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Images> activitiImages;

    @Override
    public String toString() {
        return "Activitis{" +
                "activitiId='" + activitiId + '\'' +
                ", activitiName='" + activitiName + '\'' +
                ", activitiDesc='" + activitiDesc + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", category='" + category + '\'' +
                ", activitiImages=" + activitiImages +
                '}';
    }
}
