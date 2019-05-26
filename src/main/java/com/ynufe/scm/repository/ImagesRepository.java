package com.ynufe.scm.repository;

import com.ynufe.scm.model.domain.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 图片持久层
 * @author william
 * @date 2019/05/19
 *
 */
public interface ImagesRepository extends JpaRepository<Images, String> {


}
