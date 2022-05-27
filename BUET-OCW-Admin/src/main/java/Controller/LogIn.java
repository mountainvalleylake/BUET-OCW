package Controller;

/**
 * Created by Ahmed on 1/05/2017 at 3:55 PM.
 */

import DataAccess.AdminPanelDAO;
import DataAccess.CourseAdminDAO;
import DataAccess.DepartmentDAO;
import TableObjects.AdminPanelObject;
import TableObjects.CourseAdminObject;
import TableObjects.DepartmentObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
@SessionAttributes({"Admin","CoursesAdmin","AllDept"})
@Controller
public class LogIn {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    AdminPanelDAO adminPanelDAO = (AdminPanelDAO) applicationContext.getBean("adminpanelDAO");
    CourseAdminDAO courseAdminDAO = (CourseAdminDAO) applicationContext.getBean("courseadminDAO");
    DepartmentDAO departmentDAO = (DepartmentDAO) applicationContext.getBean("departmentDAO");
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView LoginLoad() {
        ModelAndView modelAndView = new ModelAndView("mylogin");
        modelAndView.addObject(
                "welcomeMessage", "Hi User, welcome to the first Spring MVC Application");
        return modelAndView;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView LoginDone(@RequestParam Map<String,String> map2, ModelMap modelMap) {
        String userid = map2.get("uid");
        int user_id = Integer.parseInt(userid);
        String password = map2.get("pass");
        AdminPanelObject adminPanelObject = adminPanelDAO.LoginValidate(user_id,password);
        if(adminPanelObject==null){
            ModelAndView modelAndView = new ModelAndView("mylogin");
            modelAndView.addObject(
                    "welcomeMessage", "Hi " + user_id + " please enter info correctly");
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/adminProfile");
            System.out.println("here pass correct");
            //Here we need to show the admin profile and courses under him
            List<CourseAdminObject> courseAdminObjectList = courseAdminDAO.GetMyTakenCourses(user_id);
            List<DepartmentObject> departmentObjectList = departmentDAO.GetAllDepartment();
            System.out.println(adminPanelObject.getAdmin_id() + adminPanelObject.getAdmin_name()  + adminPanelObject.getPassword());
            modelMap.addAttribute("Admin",adminPanelObject);
            modelMap.addAttribute("CoursesAdmin",courseAdminObjectList);
            modelMap.addAttribute("AllDept",departmentObjectList);
            System.out.println("MEAW");
            //System.out.println(adminPanelObject.getStatus());
            for (CourseAdminObject c: courseAdminObjectList) {
                System.out.println(c.getCourse_id());
            }
            for (DepartmentObject d: departmentObjectList){
                System.out.println(d.getDepartment_name());
            }
            return modelAndView;
        }

    }
}

