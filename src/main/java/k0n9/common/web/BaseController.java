package k0n9.common.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import k0n9.common.entity.BaseEntity;
import k0n9.common.pagination.PropertyFilter;
import k0n9.common.service.BaseService;
import k0n9.common.web.utils.ServletUtils;
import k0n9.common.web.view.OperationResult;
import k0n9.common.pagination.mybatis.model.Page;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author David Kong
 * @version 1.0
 */
public abstract class BaseController<T extends BaseEntity<ID>, ID extends Serializable> {

    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 子类指定泛型对应的实体Service接口对象
     */
    abstract protected BaseService<T, ID> getEntityService();

    abstract protected T buildBindingEntity();

    protected Page<T> findPage(HttpServletRequest request) {
        Map<String, Object> parameters = ServletUtils.buildParameters(request);
        Pageable pageable = PropertyFilter.buildPageableFromHttpRequest(request);
        org.springframework.data.domain.Page<T> list = getEntityService().findPage(parameters, pageable);
        return new Page<T>(list.getContent(), list.getTotalElements());
    }

    protected List<T> findList(T entity) {
        return getEntityService().findList(entity);
    }

    protected List<T> findList(Map<String, Object> parameters) {
        return getEntityService().findList(parameters);
    }

    protected OperationResult editSave(T entity) {
        getEntityService().save(entity);
        Map<String, Object> result = Maps.newHashMap();
        result.put("id", entity.getId());
        return OperationResult.buildSuccessResult("数据保存处理完成", result);
    }

    protected OperationResult delete(ID id) {
        getEntityService().delete(id);
        return OperationResult.buildSuccessResult("数据已删除");
    }

    protected T initPrepareModel(Model model, ID id) {
        T entity = null;
        if (id == null) {
            entity = buildBindingEntity();
        } else {
            entity = getEntityService().findOne(id);
            model.addAttribute("id", id);
        }
        //model.addAttribute("clazz", ServletUtils.buildValidateId(entity.getClass()));
        model.addAttribute("entity", entity);
        return entity;
    }

    /**
     * 子类额外追加过滤限制条件的入口方法，一般基于当前登录用户强制追加过滤条件
     * 注意：凡是基于当前登录用户进行的控制参数，一定不要通过页面请求参数方式传递，存在用户篡改请求数据访问非法数据的风险
     * 因此一定要在Controller层面通过覆写此回调函数或自己的业务方法中强制追加过滤条件
     * @param groupPropertyFilter 已基于Request组装好查询条件的集合对象
     */
//    protected void appendFilterProperty(GroupPropertyFilter groupPropertyFilter,HttpServletRequest request) {
//
//    }

    /**
     * 一般用于把没有分页的集合数据转换组装为对应的Page对象，传递到前端Grid组件以统一的JSON结构数据显示
     *
     * @param list 泛型集合数据
     * @return 转换封装的Page分页结构对象
     */
    protected <S> Page<S> buildPageResultFromList(List<S> list) {
        return new Page<S>(list, 20);
    }

    protected String writeValueAsJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
            return "{\"ERROR\":\"ERROR\"}";
        }
    }

    /**
     * 对于一些复杂处理逻辑需要基于提交数据服务器校验后有提示警告信息需要用户二次确认
     * 判断当前表单是否已被用户confirm确认OK
     */
    protected boolean postNotConfirmedByUser(HttpServletRequest request) {
        return !BooleanUtils.toBoolean(request.getParameter("_serverValidationConfirmed_"));
    }
}
