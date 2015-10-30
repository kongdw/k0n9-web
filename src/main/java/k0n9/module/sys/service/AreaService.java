package k0n9.module.sys.service;

import k0n9.common.dao.BaseDao;
import k0n9.common.service.BaseService;
import k0n9.module.sys.dao.AreaDao;
import k0n9.module.sys.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author David Kong
 * @version 1.0
 */
@Service
@Transactional
public class AreaService  extends BaseService<Area,Long> {

    @Autowired
    private AreaDao areaDao;

    @Override
    protected BaseDao<Area,Long> getEntityDao() {
        return areaDao;
    }



}
