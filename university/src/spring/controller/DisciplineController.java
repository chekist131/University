package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.Storages;
import spring.jpa.DisciplinesEntity;
import spring.jpa.StudentsEntity;

/**
 * Created by Антон on 12.05.2016.
 */
@Controller
@RequestMapping("/discs")
public class DisciplineController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMy(ModelMap model){
        model.addAttribute("discs", storages.disciplinesRepository.findAll());
        model.addAttribute("teachs", storages.teachersRepository.findAll());
        return "discs/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute DisciplinesEntity disciplinesEntity, ModelMap model){
        if (!disciplinesEntity.getName().isEmpty() && disciplinesEntity.getTeacher() != null)
            storages.disciplinesRepository.save(disciplinesEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute DisciplinesEntity disciplinesEntity, ModelMap modelMap){
        storages.disciplinesRepository.delete(disciplinesEntity);
        return  "redirect:show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@ModelAttribute DisciplinesEntity disciplinesEntity, ModelMap modelMap){
        modelMap.addAttribute("disc", storages.disciplinesRepository.findOne(disciplinesEntity.getId()));
        modelMap.addAttribute("teachs", storages.teachersRepository.findAll());
        return "discs/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute DisciplinesEntity disciplinesEntity, ModelMap modelMap){
        if (!disciplinesEntity.getName().isEmpty() && disciplinesEntity.getTeacher() != null)
            storages.disciplinesRepository.save(disciplinesEntity);
        return "redirect:show";
    }
}
