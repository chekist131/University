package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.Storages;
import spring.jpa.StudentsEntity;
import spring.jpa.TeachersEntity;

/**
 * Created by Антон on 12.05.2016.
 */
@Controller
@RequestMapping("/teachs")
public class TeacherController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMy(ModelMap model){
        model.addAttribute("teachs", storages.teachersRepository.findAll());
        model.addAttribute("deps", storages.departmentsRepository.findAll());
        return "teachs/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute TeachersEntity teachersEntity, ModelMap model){
        if (!teachersEntity.getName().isEmpty() && teachersEntity.getDepartment() != null)
            storages.teachersRepository.save(teachersEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute TeachersEntity teachersEntity, ModelMap modelMap){
        storages.teachersRepository.delete(teachersEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@ModelAttribute TeachersEntity teachersEntity, ModelMap modelMap){
        modelMap.addAttribute("teach", storages.teachersRepository.findOne(teachersEntity.getId()));
        modelMap.addAttribute("deps", storages.departmentsRepository.findAll());
        return "teachs/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute TeachersEntity teachersEntity, ModelMap modelMap){
        if (!teachersEntity.getName().isEmpty() && teachersEntity.getDepartment() != null)
            storages.teachersRepository.save(teachersEntity);
        return "redirect:show";
    }
}
