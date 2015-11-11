package k0n9.module.sys.service;

import k0n9.common.dao.BaseDao;
import k0n9.common.service.BaseService;
import k0n9.module.sys.dao.JobDao;
import k0n9.module.sys.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author David Kong
 * @version 1.0
 */
@Service
@Transactional
public class JobService extends BaseService<Job,Long> {

    @Autowired
    private JobDao jobDao;

    @Override
    protected BaseDao<Job,Long> getEntityDao() {
        return jobDao;
    }



}
