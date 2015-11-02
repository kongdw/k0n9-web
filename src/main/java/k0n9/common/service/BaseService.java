package k0n9.common.service;

import k0n9.common.dao.BaseDao;
import k0n9.common.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

/**
 * Service基类
 *
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseService<T extends BaseEntity, ID extends Serializable> {

    private final Logger logger = LoggerFactory.getLogger(BaseService.class);

    /**
     * 子类设置具体的Dao对象实例
     */
    protected abstract BaseDao<T, ID> getEntityDao();

    /**
     * 数据保存操作
     * @param entity
     * @return
     */
    //TODO 新增或者修改后对影响行数做判断
    public T save(T entity) {
        if (entity.isNew()) {
            preInsert(entity);
            getEntityDao().insert(entity);
        } else {
            preUpdate(entity);
            getEntityDao().update(entity);
        }
        return entity;
    }

    /**
     * 数据删除操作
     * @param entity 待操作数据
     */
    public int delete(T entity) {
        return getEntityDao().delete(entity);
    }

    /**
     * 批量数据删除操作 其实现只是简单循环集合每个元素调用
     * 因此并无实际的Batch批量处理，如果需要数据库底层批量支持请自行实现
     *
     * @param entities 待批量操作数据集合
     * @return
     */
    public int delete(Iterable<T> entities) {
        int count = 0;
        for (T entity : entities) {
            count = count + delete(entity);
        }
        return count;
    }

    /**
     * 跟新实体
     * @param entity
     * @return
     */
    public int update(T entity){
        return getEntityDao().update(entity);
    }

    /**
     * 基于主键查询单一数据对象
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public T findOne(ID id) {
        Assert.notNull(id);
        return getEntityDao().get(id);
    }

    /**
     * 基于实体属性查询
     *
     * @param
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> findList(T entity) {
        return getEntityDao().findList(entity);
    }

    /**
     * 基于主键集合查询集合数据对象
     *
     * @param ids 主键集合
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> findAll(final ID... ids) {
        Assert.isTrue(ids != null && ids.length > 0, "必须提供有效查询主键集合");
        return this.getEntityDao().findAll(ids);
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
