package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.Storages;
import spring.jpa.DepartmentsEntity;
import spring.jpa.SpecializationsEntity;

/**
 * Created by Антон on 12.05.2016.
 */
@Controller
@RequestMapping("/deps")
public class DepartmentController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMy(ModelMap model){
        model.addAttribute("deps", storages.departmentsRepository.findAll());
        return "deps/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute DepartmentsEntity departmentsEntity, ModelMap model){
        if (!departmentsEntity.getName().isEmpty())
            storages.departmentsRepository.save(departmentsEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute DepartmentsEntity departmentsEntity, ModelMap modelMap){
        storages.departmentsRepository.delete(departmentsEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@ModelAttribute DepartmentsEntity departmentsEntity, ModelMap modelMap){
        modelMap.addAttribute("dep", storages.departmentsRepository.findOne(departmentsEntity.getId()));
        return "deps/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute DepartmentsEntity departmentsEntity, ModelMap modelMap){
        if (!departmentsEntity.getName().isEmpty())
            storages.departmentsRepository.save(departmentsEntity);
        return "redirect:show";
    }
}
