package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.Storages;
import spring.jpa.GroupsEntity;
import spring.jpa.SpecializationsEntity;
import java.util.*;

/**
 * Created by Антон on 12.05.2016.
 */
@Controller
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMy(ModelMap model){
        model.addAttribute("groups", storages.groupsRepository.findAll());
        model.addAttribute("courses", storages.coursesRepository.findAll());
        model.addAttribute("specs", storages.specializationsRepository.findAll());
        return "groups/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute GroupsEntity groupsEntity, ModelMap model){
        if (!groupsEntity.getName().isEmpty() && groupsEntity.getCourse() != null && groupsEntity.getSpecialization() != null)
            storages.groupsRepository.save(groupsEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute GroupsEntity groupsEntity, ModelMap modelMap){
        storages.groupsRepository.delete(groupsEntity);
        return  "redirect:show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@ModelAttribute GroupsEntity groupsEntity, ModelMap modelMap){
        modelMap.addAttribute("group", storages.groupsRepository.findOne(groupsEntity.getId()));
        modelMap.addAttribute("courses", storages.coursesRepository.findAll());
        modelMap.addAttribute("specs", storages.specializationsRepository.findAll());
        return "groups/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute GroupsEntity groupsEntity, ModelMap modelMap){
        if (!groupsEntity.getName().isEmpty() && groupsEntity.getCourse() != null && groupsEntity.getSpecialization() != null)
            storages.groupsRepository.save(groupsEntity);
        return "redirect:show";
    }
}
