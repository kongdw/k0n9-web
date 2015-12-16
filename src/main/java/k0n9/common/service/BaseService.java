package k0n9.common.service;

import k0n9.common.dao.mybatis.MyBatisDao;
import k0n9.common.entity.plugin.Persistable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Service基类
 *
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseService<T extends Persistable, ID extends Serializable> {

    private final Logger logger = LoggerFactory.getLogger(BaseService.class);

    public static final String STATEMENT_INSERT = "insert";
    public static final String STATEMENT_UPDATE = "update";
    public static final String STATEMENT_DELETE = "delete";
    public static final String STATEMENT_FIND_ONE = "findOne";
    public static final String STATEMENT_FIND_LIST = "findList";
    public static final String STATEMENT_FIND_PAGE = "findPage";

    protected Class<T> entityClass;

    /**
     * 子类设置具体的Dao对象实例
     */
    @Autowired
    private MyBatisDao myBatisDao;

    @SuppressWarnings("unchecked")
    public BaseService() {
        super();
        // 通过反射取得Entity的Class.
        try {
            Object genericClz = getClass().getGenericSuperclass();
            if (genericClz instanceof ParameterizedType) {
                entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            }
        } catch (Exception e) {
            logger.error("error detail:", e);
        }
    }

    /**
     * 数据保存操作
     *
     * @param entity
     * @return
     */
    //TODO 新增或者修改后对影响行数做判断
    public int save(T entity) {
        if (entity.isNew()) {
            preInsert(entity);
            return myBatisDao.execute(entityClass.getName(), BaseService.STATEMENT_INSERT, entity);
        } else {
            preUpdate(entity);
            return myBatisDao.execute(entityClass.getName(), BaseService.STATEMENT_UPDATE, entity);
        }
    }

    /**
     * @param ids 批量删除ids数组
     * @return
     */
    public int delete(ID... ids) {
        return myBatisDao.execute(entityClass.getName(), BaseService.STATEMENT_DELETE, ids);
    }

    /**
     * 基于主键查询单一数据对象
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public T findOne(ID id) {
        Assert.notNull(id);
        return myBatisDao.findOne(entityClass.getName(), BaseService.STATEMENT_FIND_ONE, id);
    }

    /**
     * 基于实体属性查询
     *
     * @param
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> findList(T entity) {
        return myBatisDao.findList(entityClass.getName(), BaseService.STATEMENT_FIND_LIST, entity);
    }

    /**
     * 基于实体属性查询
     *
     * @param
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> findList(Map<String, Object> parameters) {
        return myBatisDao.findList(entityClass.getName(), BaseService.STATEMENT_FIND_LIST, parameters);
    }

    /**
     * 基于实体属性查询
     *
     * @param
     * @return
     */
    @Transactional(readOnly = true)
    public Page<T> findPage(Map<String, Object> parameters, Pageable pageable) {
        return myBatisDao.findPage(entityClass.getName(), BaseService.STATEMENT_FIND_PAGE, parameters, pageable);
    }

    /**
     * 基于实体属性查询
     *
     * @param
     * @return
     */
    @Transactional(readOnly = true)
    public Page<T> findPage(T entity, Pageable pageable) {
        return myBatisDao.findPage(entityClass.getName(), BaseService.STATEMENT_FIND_PAGE, entity, pageable);
    }

    /**
     * 新增数据保存之前额外操作回调方法 默认为空逻辑，子类根据需要覆写添加逻辑即可
     *
     * @param entity 待创建数据对象
     */
    protected void preInsert(T entity) {
    }

    /**
     * 更新数据保存之前额外操作回调方法 默认为空逻辑，子类根据需要覆写添加逻辑即可
     *
     * @param entity 待更新数据对象
     */
    protected void preUpdate(T entity) {
    }
}
