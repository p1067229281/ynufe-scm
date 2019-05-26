package com.ynufe.scm.model.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *     操作日志记录
 * </pre>
 *
 * @author : william
 * @date : 2019/05/17
 */
@Data
@Entity
@Table(name = "scm_logs")
@EntityListeners(AuditingEntityListener.class)
public class Logs implements Serializable {

    /**
     * id
     */
    @Id
    @GenericGenerator(name = "generator-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "generator-uuid")
    private String logId;

    /**
     * 标题
     */
    private String logTitle;

    /**
     * 内容
     */
    private String logContent;

    /**
     * 产生日志的ip
     */
    private String logIp;

    /**
     * 产生的时间
     */
    @CreatedDate
    private Date logCreated;

    public Logs() {
    }

    public Logs(String logTitle, String logContent, String logIp, Date logCreated) {
        this.logTitle = logTitle;
        this.logContent = logContent;
        this.logIp = logIp;
        this.logCreated = logCreated;
    }
}
