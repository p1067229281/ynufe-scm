package com.ynufe.scm.model.domain;

import com.ynufe.scm.repository.ActivitisRespository;
import com.ynufe.scm.repository.ClubRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * 测试activitis的数据库操作
 * @author william
 * @date 2019/05/19
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitisTest {

    @Autowired
    private ActivitisRespository activitisRespository;

    @Autowired
    private ClubRepository clubRepository;

    /**
     * 测试保存一个活动
     */
    @Test
    public void test(){
        Activitis activiti = new Activitis();

        Club club = clubRepository.findByClubName("文化交流社");
        activiti.setClub(club);
        activiti.setActivitiDesc("测试活动");

        activiti.setClub(club);
        activitisRespository.save(activiti);
    }

}
