package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import spring.Storages;
import spring.jpa.GroupsEntity;
import spring.jpa.SpecializationsEntity;

import java.util.Collection;

/**
 * Created by Антон on 12.05.2016.
 */
@Controller
@RequestMapping("/specs")
public class SpecializationController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMy(ModelMap model){
        model.addAttribute("models", storages.specializationsRepository.findAll());
        return "specs/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute SpecializationsEntity specializationsEntity, ModelMap model){
        if (!specializationsEntity.getName().isEmpty())
            storages.specializationsRepository.save(specializationsEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute SpecializationsEntity specializationsEntity, ModelMap modelMap){
        storages.specializationsRepository.delete(specializationsEntity);
        return  "redirect:show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@ModelAttribute SpecializationsEntity specializationsEntity, ModelMap modelMap){
        modelMap.addAttribute("model", storages.specializationsRepository.findOne(specializationsEntity.getId()));
        return "specs/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute SpecializationsEntity specializationsEntity, ModelMap modelMap){
        if (!specializationsEntity.getName().isEmpty())
            storages.specializationsRepository.save(specializationsEntity);
        return "redirect:show";
    }
}
