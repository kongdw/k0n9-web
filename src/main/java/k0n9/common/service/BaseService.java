package k0n9.common.service;

import k0n9.common.dao.BaseDao;
import k0n9.common.entity.plugin.Persistable;
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
public abstract class BaseService<T extends Persistable, ID extends Serializable> {

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
     * @param id 待操作数据
     */
    public int delete(ID id) {
        return getEntityDao().delete(id);
    }

    /**
     *
     * @param ids 批量删除ids数组
     * @return
     */
    public int delete(ID... ids) {
        return getEntityDao().deleteByIds(ids);
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
        return getEntityDao().findByList(entity);
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
        return this.getEntityDao().findByIds(ids);
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
