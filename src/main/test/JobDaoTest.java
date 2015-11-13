import k0n9.BaseTest;
import k0n9.module.sys.dao.JobDao;
import k0n9.module.sys.entity.Job;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class JobDaoTest extends BaseTest{

    private Logger log = LoggerFactory.getLogger(JobDaoTest.class);
    @Autowired
    private JobDao jobDao;

    @Before
    public void setup() {

    }

    @Test
    public void testInsert() {
        Job job = new Job();
        job.setName("中国");
        job.setParentId(0l);
        job.setParentIds("0/");
        job.setWeight(100);
        int i = jobDao.insert(job);
        log.info(String.valueOf(i));
        log.info(String.valueOf(job));
    }

    @Test
    public void testUpdate() {
        Job job = jobDao.get(1l);
        jobDao.update(job);
        jobDao.get(1l);
    }
    @Test
    public void testFindByParentIdsLike(){
        Job job = new Job();
        job.addSqlMapAttribute("dsf", "and id = 1");
        List<Job> jobList = jobDao.findByPage(job);
        log.info("查询到{}条结果", jobList.size());
    }

    @Test
    public void testFindByIds(){
        Long[] ids = new Long[3];
        ids[0] = 1l;
        ids[1] = 2l;
        ids[2] = 3l;
        List<Job> jobList = jobDao.findByIds(ids);
        log.info("查询到{}条结果", jobList.size());
    }
}
