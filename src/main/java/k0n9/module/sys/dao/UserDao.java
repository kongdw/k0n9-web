package k0n9.module.sys.dao;

import k0n9.common.dao.BaseDao;
import k0n9.common.dao.annotation.MyBatisDao;
import k0n9.module.sys.entity.User;

/**
 *
 * @author David Kong
 * @version 1.0
 */
@MyBatisDao
public interface UserDao extends BaseDao<User,Long>{


}
