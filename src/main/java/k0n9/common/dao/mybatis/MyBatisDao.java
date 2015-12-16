package k0n9.common.dao.mybatis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * MyBatis 基础接口，支持CRUD基本操作，分页
 */
public interface MyBatisDao {

    <T> T findOne(String namespace, String statementId, Object parameters);

    <E> List<E> findList(String namespace, String statementId, Object parameters);

    <E> Page<E> findPage(String namespace, String statementId, Object parameters, Pageable pageable);

    <K, V> Map<K, V> findMap(String namespace, String statementId, Object parameter, String mapKey);

    /**
     * 执行更新操作，包括insert、update、delete
     * @param namespace 一般用实体类的全路径,如 User.class.getName()
     * @param statementId insert、update、delete等语句标识
     * @param parameters 操作所需参数对象，可能是实体对象或Map或其他类型等
     * @return 注意: 返回的是操作影响的记录数,不是主键
     */
    int execute(String namespace, String statementId, Object parameters);
}
