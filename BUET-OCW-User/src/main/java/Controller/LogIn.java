package Controller;

/**
 * Created by Ahmed on 1/05/2017 at 3:55 PM.
 */

import DataAccess.CourseTakenDAO;
import DataAccess.PeopleDAO;
import TableObjects.CourseTakenObject;
import TableObjects.PeopleObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
@SessionAttributes({"CurrentUser","CourseTaken"})
@Controller
public class LogIn {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    PeopleDAO peopleDAO = (PeopleDAO) applicationContext.getBean("peopleDAO");
    CourseTakenDAO courseTakenDAO = (CourseTakenDAO) applicationContext.getBean("coursetakenDAO");
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView LoginLoad(ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView("mylogin");
        modelAndView.addObject(
                "welcomeMessage", "Hi User, welcome to the first Spring MVC Application");
        return modelAndView;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView LoginDone(@RequestParam Map<String,String> map2,ModelMap modelMap) {
        String user_name = map2.get("uname");
        String password = map2.get("pass");
        PeopleObject p = peopleDAO.LoginValidate(user_name,password);
        if(p==null){
            ModelAndView modelAndView = new ModelAndView("mylogin");
            modelAndView.addObject(
                    "welcomeMessage", "Hi " + user_name + " please enter info correctly");
            return modelAndView;
        }
        else {
            //test
            PeopleObject peopleObject = peopleDAO.ShowingProfile(user_name,password);//this helps showing profile
            List <CourseTakenObject> courseTakenObjectList = courseTakenDAO.ShowTakenCourses(peopleObject);//this is the list of courses taken
            ModelAndView modelAndView = new ModelAndView("userProfile");
            //ModelMap modelMap = new ModelMap();
            //modelAndView.addObject("CurrentUser",peopleObject);
            //modelAndView.addObject("CourseTaken",courseTakenDAO);
            //modelAndView.addObject("CourseTaken",courseTakenObjectList);
            //return new ModelAndView("userProfile","CourseTaken", courseTakenObjectList);
            modelMap.addAttribute("CurrentUser",peopleObject);
            modelMap.addAttribute("CourseTaken",courseTakenObjectList);
            return modelAndView;
        }
    }
}

