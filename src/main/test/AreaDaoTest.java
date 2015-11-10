import k0n9.common.entity.BaseEntity;
import k0n9.module.sys.dao.AreaDao;
import k0n9.module.sys.entity.Area;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/spring-context.xml")
public class AreaDaoTest {

    private Logger log = LoggerFactory.getLogger(AreaDaoTest.class);
    @Autowired
    private AreaDao areaDao;

    @Before
    public void setup() {

    }

    @Test
    public void testInsert() {
        Area area = new Area();
        area.setName("中国");
        area.setParentId(0l);
        area.setParentIds("0/");
        area.setCode("zh_CN");
        area.setType("zh_CN");
        area.setWeight(100);
        area.setRemarks("remarks......");
        int i = areaDao.insert(area);
        log.info(String.valueOf(i));
        log.info(String.valueOf(area));
    }

    @Test
    public void testUpdate() {
        Area area = areaDao.get(1l);
        area.setRemarks("abckdwls");
        areaDao.update(area);
        areaDao.get(1l);
    }
    @Test
    public void testFindByParentIdsLike(){
        Area area = new Area();
        area.setRemarks("and id = 1");
        area.addSqlMapAttribute(BaseEntity.SQLMAPKEY_CURRENTUSER,area);
        List<Area> areaList = areaDao.findByPage(area);
        log.info("查询到{}条结果",areaList.size());
    }

    @Test
    public void testFindByIds(){
        Long[] ids = new Long[3];
        ids[0] = 1l;
        ids[1] = 2l;
        ids[2] = 3l;
        List<Area> areaList = areaDao.findByIds(ids);
        log.info("查询到{}条结果",areaList.size());
    }
}
