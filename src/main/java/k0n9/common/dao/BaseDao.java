package k0n9.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 数据访问接口
 * @author David Kong
 * @version 1.0
 */
public interface BaseDao<T,ID extends Serializable> {

    /**
     * 插入数据
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 修改数据
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 删除数据
     * @param entity
     * @return
     */
    int delete(T entity);

    /**
     * 获取一条数据
     * @param id
     * @return
     */
    T get(ID id);

    T get(T entity);

    /**
     * 分页查询
     * @param entity
     * @return
     */
    List<T> findList(T entity);

    /**
     * 查询所有数据列表
     * @param entity
     * @return
     */
    List<T> findAllList(T entity);


    List<T> findAll(ID[] ids);
}
