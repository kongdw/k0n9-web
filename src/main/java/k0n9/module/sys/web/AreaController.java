package k0n9.module.sys.web;

import com.github.pagehelper.PageInfo;
import k0n9.common.annotation.MenuData;
import k0n9.common.service.BaseService;
import k0n9.common.web.BaseController;
import k0n9.common.web.view.OperationResult;
import k0n9.module.sys.entity.Area;
import k0n9.module.sys.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author David Kong
 * @version 1.0
 */
@Controller
@RequestMapping("${adminPath}/sys/area")
public class AreaController extends BaseController<Area,Long> {

    @Autowired
    private AreaService areaService;

    @Override
    protected BaseService<Area, Long> getEntityService() {
        return areaService;
    }

    @Override
    protected Area buildBindingEntity() {
        return new Area();
    }

    @MenuData(value = "系统配置:区域管理")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        return "admin/sys/area-index";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Area> findByList(HttpServletRequest request){
        return super.findList(new Area());
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult editSave(@ModelAttribute("entity") Area area,Model model) {
        return super.editSave(area);
    }

    @ModelAttribute("entity")
    public void prepareModel(Model model, @RequestParam(value = "id", required = false) Long id) {
        super.initPrepareModel(model, id);
    }

}
