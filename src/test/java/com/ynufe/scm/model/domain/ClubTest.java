package com.ynufe.scm.model.domain;

import com.ynufe.scm.repository.ClubRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试club的数据库操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClubTest {

    @Autowired
    private ClubRepository clubRepository;

    @Test
    public void save(){
        /**
         * 测试保存操作
         */
        Club club = new Club();
        club.setClubGlory("获得奖励");
        club.setClubName("文化交流社");

        Leader leader = new Leader();
        leader.setMajor("计算机科学与技术");
        leader.setLeaderName("测试姓名");
        leader.setPhoneNum("15391337246");
        leader.setClub(club);

        Teacher teacher = new Teacher();
        teacher.setAcademic("信息学院");
        teacher.setClub(club);

        club.setLeader(leader);
        club.setTeacher(teacher);

        clubRepository.save(club);

    }

    /**
     * 测试从社团中查询活动
     */
    @Test
    public void queryActiviti(){
        Club club2 = clubRepository.findByClubName("文化交流社");
        System.out.println(club2.getActivitis());
    }

}