package com.ynufe.scm.repository;

import com.ynufe.scm.model.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 社团持久层
 * @author william
 * @date 2019/05/19
 *
 */
public interface ClubRepository extends JpaRepository<Club, String> {

    Club findByClubName(String clubName);

}
