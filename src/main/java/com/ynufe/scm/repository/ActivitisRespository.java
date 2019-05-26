package com.ynufe.scm.repository;

import com.ynufe.scm.model.domain.Activitis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 社团活动持久层
 * @author william
 * @date 2019/05/19
 *
 */
public interface ActivitisRespository extends JpaRepository<Activitis, String> {

}
