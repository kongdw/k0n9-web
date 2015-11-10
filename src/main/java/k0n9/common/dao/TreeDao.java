package k0n9.common.dao;

import k0n9.common.entity.TreeEntity;
import k0n9.common.entity.plugin.Tree;

import java.io.Serializable;

/**
 * @author David Kong
 * @version 1.0
 */
public interface TreeDao<T extends TreeEntity<ID> & Tree<ID>,ID extends Serializable> extends BaseDao<T,ID>{
}
