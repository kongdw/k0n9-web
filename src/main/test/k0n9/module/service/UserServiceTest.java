package k0n9.module.service;

import k0n9.BaseTest;
import k0n9.module.sys.entity.User;
import k0n9.module.sys.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author David Kong
 * @version 1.0
 */
public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void testInsert() {
        User user = new User();
        user.setEmail("kong.dw@hotmail.com");
        user.setPhoneNumber("13693601808");
        user.setUsername("David Kong");
        user.setDeleted(false);
        user.setCreateDate(new Date());
        user.setIsAdmin(true);
        user.setPassword("123456");
        user.setSalt("111111");
        user.setStatus("normal");
        userService.save(user);
    }
    @Test
    public void testUpdate(){
        testInsert();
        User user =  userService.findOne(1l);
        user.setUsername("David Kong");
        userService.update(user);
    }

    @Test
    public void testDelete(){
        testInsert();
        userService.delete(1l);
    }
}
