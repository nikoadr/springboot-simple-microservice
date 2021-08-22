package com.dailylesson.user.service;

import com.dailylesson.user.VO.Department;
import com.dailylesson.user.VO.ResponseTemplateVO;
import com.dailylesson.user.entity.User;
import com.dailylesson.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userid) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userid);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDepartmentId(),Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
