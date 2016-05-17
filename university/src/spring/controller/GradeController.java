package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.Storages;
import spring.jpa.GradesEntity;
import spring.jpa.StudentsEntity;
import spring.repositories.GradesRepository;

/**
 * Created by Антон on 12.05.2016.
 */
@Controller
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private Storages storages;

    int[] gradePul = {2,3,4,5};

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMy(ModelMap model){
        model.addAttribute("grades", storages.gradesRepository.findAll());
        model.addAttribute("studs", storages.studentsRepository.findAll());
        model.addAttribute("discs", storages.disciplinesRepository.findAll());
        model.addAttribute("gradePul", gradePul);
        return "grades/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute GradesEntity gradesEntity, ModelMap model){
        if (gradesEntity.getStudent() != null && gradesEntity.getDiscipline() != null)
            storages.gradesRepository.save(gradesEntity);
        return "redirect:show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute GradesEntity gradesEntity, ModelMap modelMap){
        storages.gradesRepository.delete(gradesEntity);
        return "redirect:show";
    }
}
