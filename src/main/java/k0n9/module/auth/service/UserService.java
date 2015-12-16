package k0n9.module.auth.service;

import k0n9.common.service.BaseService;
import k0n9.module.auth.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author David Kong
 * @version 1.0
 */
@Service
@Transactional
public class UserService extends BaseService<User,Long> {

    @Override
    protected void preInsert(User entity) {
        entity.setCreateDate(new Date());
        super.preInsert(entity);
    }
}
