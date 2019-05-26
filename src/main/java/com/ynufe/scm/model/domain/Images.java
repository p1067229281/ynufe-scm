package com.ynufe.scm.model.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     社团图片,活动图片
 * </pre>
 * @author william
 * @date 2019/05/17
 *
 */

@Data
@Entity
@Table(name = "scm_images")
@ToString
public class Images {

    /**
     * 图片id
     */
    @Id
    @GenericGenerator(name = "generator-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "generator-uuid")
    private String imageId;

    /**
     * 图片地址
     */
    private String path;

    /**
     * 图片描述
     */
    private String imageDesc;

    /**
     * 拍摄地点
     */
    private String imageLocation;

    /**
     * 图片拍摄日期
     */
    private String imageDate;

    /**
     * 图片缩略图地址
     */
    private String imageThumbnailUrl;

    /**
     * 该图片属于哪一活动
     */
    @ManyToOne(targetEntity = Activitis.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "activiti_id")
    private Activitis activiti;

    @Override
    public String toString() {
        return "Images{" +
                "imageId='" + imageId + '\'' +
                ", path='" + path + '\'' +
                ", imageDesc='" + imageDesc + '\'' +
                ", imageLocation='" + imageLocation + '\'' +
                ", imageDate='" + imageDate + '\'' +
                ", imageThumbnailUrl='" + imageThumbnailUrl + '\'' +
                '}';
    }
}
