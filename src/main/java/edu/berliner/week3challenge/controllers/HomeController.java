package edu.berliner.week3challenge.controllers;

import edu.berliner.week3challenge.models.Education;
import edu.berliner.week3challenge.models.Skills;
import edu.berliner.week3challenge.models.User;
import edu.berliner.week3challenge.models.Work;
import edu.berliner.week3challenge.repositories.EdRepo;
import edu.berliner.week3challenge.repositories.SkillRepo;
import edu.berliner.week3challenge.repositories.UserRepo;
import edu.berliner.week3challenge.repositories.WorkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController
{

    @Autowired
    EdRepo edRepo;
    @Autowired
    SkillRepo skillRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    WorkRepo workRepo;



    @GetMapping("/")
    public String start(Model model)
    {
        model.addAttribute("hasUsers", userRepo.findAll());
        return "index";
    }
    @GetMapping("/index")
    public String home()
    {
        return "index";
    }

    @GetMapping("/adduser")
    public String addUser(Model model)
    {
        model.addAttribute("person", new User());
        return "adduser";
    }

    @PostMapping("/adduser")
    public String submitUser(@Valid @ModelAttribute("person")User user, BindingResult bindingResult)
    {
        System.out.println("post");
        if(bindingResult.hasErrors())
        {
            System.out.println("has error");
            return "adduser";
        }
        userRepo.save(user);
        return "added";
    }

    @GetMapping("/addskill")
    public String addSkill(Model model)
    {
        model.addAttribute("newSkill", new Skills());
        return "addskill";
    }
    @PostMapping("addskill")
    public String submitSkill(@ModelAttribute("newSkill")Skills newSkill)
    {
        skillRepo.save(newSkill);
        return "added";
    }

    @GetMapping("/addeducation")
    public String addEducation(Model model)
    {
        model.addAttribute("newEducation", new Education());
        return "addeducation";
    }

    @PostMapping("/addeducation")
    public String submitEducation(@ModelAttribute("newEducation")Education newEducation)
    {
        edRepo.save(newEducation);
        return "added";
    }

    @GetMapping("/addwork")
    public String addWork(Model model)
    {
        model.addAttribute("newJob", new Work());
        return "addwork";
    }

    @PostMapping("/addwork")
    public String submitWork(@ModelAttribute("newJob")Work newJob)
    {
        workRepo.save(newJob);
        return "added";
    }

    @GetMapping("/resume")
    public String resume(Model model)
    {
        //get user - currently only a single user
        Iterable <User> user = userRepo.findAll();
        //Get the actual person
        User person = user.iterator().next();

        //get iterables of that single user's jobs(Work), skills(Skills), and education(Education)
        //and add to the user's ArrayList
        Iterable <Work> work = workRepo.findAll();
        ArrayList<Work> arrWork = new ArrayList<Work>();
        work.forEach(workItem ->arrWork.add(workItem));
        person.setWork(arrWork);

        Iterable <Skills> userSkills = skillRepo.findAll();
        ArrayList<Skills> arrSkills = new ArrayList<Skills>();
        userSkills.forEach(skillsItem -> arrSkills.add(skillsItem));
        person.setSkills(arrSkills);


        //edRepo.findAll().forEach(edItem -> person.getEducation().add(edItem));
        //ed.forEach(edItem -> person.getEducation().add(edItem));


        Iterable <Education> ed = edRepo.findAll();
        ArrayList<Education> arrEd = new ArrayList<Education>();
        ed.forEach(edItem -> arrEd.add(edItem));
        person.setEducation(arrEd);

        model.addAttribute("person", person);
        //model.addAttribute("work", work);
        return "resume";
    }
}
