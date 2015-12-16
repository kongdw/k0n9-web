package k0n9.module.service;

import k0n9.BaseTest;
import k0n9.module.auth.entity.User;
import k0n9.module.auth.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David Kong
 * @version 1.0
 */
public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Test
    public void testInsert() {
        for(int i =100 ;i<150; i++){
            User user = new User();
            user.setEmail("kong.dw"+i+"@hotmail.com");
            user.setPhoneNumber("136936018"+i);
            user.setUsername("David Kong"+i);
            user.setDeleted(false);
            user.setCreateDate(new Date());
            user.setIsAdmin(true);
            user.setPassword("123456");
            user.setSalt("111111");
            user.setStatus("normal");
            userService.save(user);
        }
    }
    @Test
    public void testUpdate(){
        //testInsert();
        User user =  userService.findOne(1l);
        user.setUsername("David Kong");
        userService.save(user);
    }

    @Test
    public void testDelete(){
        userService.delete(11l);
    }

    @Test
    public void testFindList(){
        User user = new User();
        user.setUsername("kong");
        Map<String,Object> parameters = new HashMap<String, Object>();
        parameters.put("username","David");
        List<User> list = userService.findList(user);
        List<User> list1 = userService.findList(parameters);
        log.info("查询到{}条数据",list.size());
    }
    @Test
    public void testFindPage(){
        User user = new User();
        user.setUsername("kong");
        Map<String,Object> parameters = new HashMap<String, Object>();
        parameters.put("username","David");
        Page<User> page = userService.findPage(user, new PageRequest(1,10));
        log.info("page:{}",page);
    }
}
