package Controller;

import DataAccess.CourseDAO;
import DataAccess.DepartmentDAO;
import DataAccess.InstructorDAO;
import TableObjects.CourseObject;
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
 * Created by graphics on 7/9/2017.
 */
@Controller
@SessionAttributes({"TeacherCourse","Teacher"})
public class Instructor {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    DepartmentDAO departmentDAO = (DepartmentDAO) applicationContext.getBean("departmentDAO");
    CourseDAO courseDAO = (CourseDAO) applicationContext.getBean("courseDAO");
    InstructorDAO instructorDAO = (InstructorDAO) applicationContext.getBean("instructorDAO");
    @RequestMapping(value = "/instructor")
    public ModelAndView TeacherPage(@RequestParam("id") int teacher_id, ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView("instructor");
        List<CourseObject> teachercourseObjectList = courseDAO.GetAllTeacherCourses(teacher_id);
        InstructorObject instructorObject = instructorDAO.GetTeacher(teacher_id);
        modelMap.addAttribute("Teacher",instructorObject);
        modelMap.addAttribute("TeacherCourse",teachercourseObjectList);
        return modelAndView;
    }
}
