package k0n9.module.sys.service;

import k0n9.common.dao.BaseDao;
import k0n9.common.service.BaseService;
import k0n9.module.sys.dao.UserDao;
import k0n9.module.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author David Kong
 * @version 1.0
 */
@Service
@Transactional
public class UserService extends BaseService<User,Long> {

    @Autowired
    private UserDao userDao;

    @Override
    protected BaseDao<User, Long> getEntityDao() {
        return userDao;
    }
}
