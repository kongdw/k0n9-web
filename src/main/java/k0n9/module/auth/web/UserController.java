package k0n9.module.auth.web;

import k0n9.common.annotation.ResourceData;
import k0n9.common.pagination.datatable.DataTableParameter;
import k0n9.common.pagination.mybatis.model.Page;
import k0n9.common.service.BaseService;
import k0n9.common.web.BaseController;
import k0n9.common.web.mapper.JsonMapper;
import k0n9.common.web.view.OperationResult;
import k0n9.module.auth.entity.User;
import k0n9.module.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author David Kong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/user")
public class UserController extends BaseController<User, Long> {

    @Autowired
    private UserService userService;

    @Override
    protected BaseService<User, Long> getEntityService() {
        return userService;
    }

    @Override
    protected User buildBindingEntity() {
        return new User();
    }

    @ResourceData(value = "系统配置:用户管理")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        //model.addAttribute("list",super.findList(buildBindingEntity()));
        return "admin/sys/user-index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Page<User> list(@RequestParam(value = "dataTableAjaxParam", required = false) String dataTableAjaxParam,
                           @RequestParam(value = "customAjaxParam", required = false) String customAjaxParam,
                           HttpServletRequest request,
                           Model model) {
        Object obj = JsonMapper.fromJsonString(dataTableAjaxParam, DataTableParameter.class);
        Object mapParam = JsonMapper.fromJsonString(customAjaxParam, HashMap.class);
        return super.findPage(request);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult editSave(@ModelAttribute("entity") User entity, Model model) {
        super.editSave(entity);
        return OperationResult.buildSuccessResult();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editTabs(HttpServletRequest request) {
        return "admin/sys/user-inputBasic";
    }

    @ModelAttribute("entity")
    public void prepareModel(Model model, @RequestParam(value = "id", required = false) Long id) {
        super.initPrepareModel(model, id);
    }


}
