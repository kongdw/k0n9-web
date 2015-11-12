package k0n9.module.sys.web;

import k0n9.common.annotation.ResourceData;
import k0n9.common.service.BaseService;
import k0n9.common.web.BaseController;
import k0n9.common.web.view.OperationResult;
import k0n9.module.sys.entity.Job;
import k0n9.module.sys.service.JobService;
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
@RequestMapping("${adminPath}/sys/job")
public class JobController extends BaseController<Job,Long> {

    @Autowired
    private JobService jobService;

    @Override
    protected BaseService<Job, Long> getEntityService() {
        return jobService;
    }

    @Override
    protected Job buildBindingEntity() {
        return new Job();
    }

    @ResourceData(value = "系统配置:区域管理")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("list",super.findList(new Job()));
        return "admin/sys/job-index";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Job> findByList(HttpServletRequest request){
        return super.findList(new Job());
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public OperationResult editSave(@ModelAttribute("entity") Job job,Model model) {
        return super.editSave(job);
    }

    @ModelAttribute("entity")
    public void prepareModel(Model model, @RequestParam(value = "id", required = false) Long id) {
        super.initPrepareModel(model, id);
    }

}
