package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.Storages;
import spring.jpa.StudentsEntity;
import spring.jpa.StudentsMailsEntity;

/**
 * Created by Антон on 12.05.2016.
 */
@Controller
@RequestMapping("/studmails")
public class StudentMailController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMy(ModelMap model){
        model.addAttribute("studmails", storages.studentsMailsRepository.findAll());
        model.addAttribute("studs", storages.studentsRepository.findAll());
        return "studmails/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute StudentsMailsEntity studentsMailsEntity, ModelMap model){
        if (!studentsMailsEntity.getValue().isEmpty() && studentsMailsEntity.getStudent() != null)
            storages.studentsMailsRepository.save(studentsMailsEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute StudentsMailsEntity studentsMailsEntity, ModelMap modelMap){
        storages.studentsMailsRepository.delete(studentsMailsEntity);
        return  "redirect:show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@ModelAttribute StudentsMailsEntity studentsMailsEntity, ModelMap modelMap){
        modelMap.addAttribute("studmail", storages.studentsMailsRepository.findOne(studentsMailsEntity.getId()));
        modelMap.addAttribute("studs", storages.studentsRepository.findAll());
        return "studmails/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute StudentsMailsEntity studentsMailsEntity, ModelMap modelMap){
        if (!studentsMailsEntity.getValue().isEmpty() && studentsMailsEntity.getStudent() != null)
            storages.studentsMailsRepository.save(studentsMailsEntity);
        return "redirect:show";
    }
}
