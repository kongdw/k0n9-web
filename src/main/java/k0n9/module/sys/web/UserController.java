package k0n9.module.sys.web;

import com.github.pagehelper.PageInfo;
import k0n9.common.annotation.ResourceData;
import k0n9.common.service.BaseService;
import k0n9.common.web.BaseController;
import k0n9.module.sys.entity.User;
import k0n9.module.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author David Kong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/user")
public class UserController extends BaseController<User,Long> {

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
    public PageInfo<User> list(HttpServletRequest request,Model model) {
        return super.findByPage(new User(),request);
    }


    @ModelAttribute("entity")
    public void prepareModel(Model model, @RequestParam(value = "id", required = false) Long id) {
        super.initPrepareModel(model, id);
    }

}
