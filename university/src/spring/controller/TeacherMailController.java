package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.Storages;
import spring.jpa.StudentsMailsEntity;
import spring.jpa.TeachersMailsEntity;

/**
 * Created by Антон on 12.05.2016.
 */
@Controller
@RequestMapping("/teachmails")
public class TeacherMailController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMy(ModelMap model){
        model.addAttribute("teachmails", storages.teachersMailsRepository.findAll());
        model.addAttribute("teachs", storages.teachersRepository.findAll());
        return "teachmails/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute TeachersMailsEntity teachersMailsEntity, ModelMap model){
        if (!teachersMailsEntity.getValue().isEmpty() && teachersMailsEntity.getTeacher() != null)
            storages.teachersMailsRepository.save(teachersMailsEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute TeachersMailsEntity teachersMailsEntity, ModelMap modelMap){
        storages.teachersMailsRepository.delete(teachersMailsEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@ModelAttribute TeachersMailsEntity teachersMailsEntity, ModelMap modelMap){
        modelMap.addAttribute("teachmail", storages.teachersMailsRepository.findOne(teachersMailsEntity.getId()));
        modelMap.addAttribute("teachs", storages.teachersRepository.findAll());
        return "teachmails/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute TeachersMailsEntity teachersMailsEntity, ModelMap modelMap){
        if (!teachersMailsEntity.getValue().isEmpty() && teachersMailsEntity.getTeacher() != null)
            storages.teachersMailsRepository.save(teachersMailsEntity);
        return "redirect:show";
    }
}
