package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.Storages;
import spring.jpa.CoursesEntity;
import spring.jpa.SpecializationsEntity;
import spring.repositories.CoursesRepository;

/**
 * Created by Антон on 12.05.2016.
 */
@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMy(ModelMap model){
        model.addAttribute("models", storages.coursesRepository.findAll());
        return "courses/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute CoursesEntity coursesEntity, ModelMap model){
        if (!coursesEntity.getName().isEmpty())
            storages.coursesRepository.save(coursesEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute CoursesEntity coursesEntity, ModelMap modelMap){
        storages.coursesRepository.delete(coursesEntity);
        return  "redirect:show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(@ModelAttribute CoursesEntity coursesEntity, ModelMap modelMap){
        modelMap.addAttribute("model", storages.coursesRepository.findOne(coursesEntity.getId()));
        return "courses/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute CoursesEntity coursesEntity, ModelMap modelMap){
        if (!coursesEntity.getName().isEmpty())
            storages.coursesRepository.save(coursesEntity);
        return "redirect:show";
    }
}
