package Controller;

import DataAccess.CourseDAO;
import DataAccess.DepartmentDAO;
import DataAccess.InstructorDAO;
import TableObjects.CourseObject;
import TableObjects.DepartmentObject;
import TableObjects.InstructorObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Ahmed on 15/05/2017 at 10:33 PM.
 */
@SessionAttributes({"CoursesDept","TeachersDept","CurrDept"})
@Controller
public class Department {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    DepartmentDAO departmentDAO = (DepartmentDAO) applicationContext.getBean("departmentDAO");
    CourseDAO courseDAO = (CourseDAO) applicationContext.getBean("courseDAO");
    InstructorDAO instructorDAO = (InstructorDAO) applicationContext.getBean("instructorDAO");
    @RequestMapping(value = "/department")
    public ModelAndView GetCourses(@RequestParam("id") int dept_id, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView("dept");
        modelAndView.addObject(
                "welcomeMessage", "Hi User, welcome to the first Spring MVC Application");
        DepartmentObject departmentObject = departmentDAO.GetDepartmentID(dept_id);
        //System.out.println(dept_name + departmentObject.getDepartment_id());
        List<CourseObject> courseObjectList = courseDAO.GetAllDepartmentCourses(dept_id);
        List<InstructorObject> instructorObjectList = instructorDAO.GetAllTeachers(dept_id);
        modelMap.addAttribute("CoursesDept",courseObjectList);
        modelMap.addAttribute("TeachersDept",instructorObjectList);
        modelMap.addAttribute("CurrDept",departmentObject);
        return modelAndView;
    }
}
