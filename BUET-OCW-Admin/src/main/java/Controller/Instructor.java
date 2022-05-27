package Controller;

import DataAccess.CourseDAO;
import DataAccess.InstructorDAO;
import TableObjects.CourseObject;
import TableObjects.DepartmentObject;
import TableObjects.InstructorObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by graphics on 7/10/2017.
 */
@Controller
@SessionAttributes({"TeacherCourse","Teacher"})
public class Instructor {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    //DepartmentDAO departmentDAO = (DepartmentDAO) applicationContext.getBean("departmentDAO");
    CourseDAO courseDAO = (CourseDAO) applicationContext.getBean("courseDAO");
    InstructorDAO instructorDAO = (InstructorDAO) applicationContext.getBean("instructorDAO");
    @RequestMapping(value = "/instructor",method = RequestMethod.GET)
    public ModelAndView TeacherPage(@RequestParam("id") int teacher_id, ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView("instructor");
        List<CourseObject> teachercourseObjectList = courseDAO.GetAllTeacherCourses(teacher_id);
        InstructorObject instructorObject = instructorDAO.GetTeacher(teacher_id);
        modelMap.addAttribute("Teacher",instructorObject);
        modelMap.addAttribute("TeacherCourse",teachercourseObjectList);
        return modelAndView;
    }
    @RequestMapping(value = "/instructor",method = RequestMethod.POST)
    public ModelAndView AddTeacher(@RequestParam Map<String,String> map, ModelMap modelMap, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("dept");
        InstructorObject instructorObject = new InstructorObject();
        String name = map.get("ntchr");
        String des = map.get("dtchr");
        String prfl = map.get("prftchr");
        String ids = map.get("itchr");
        int id = Integer.valueOf(ids);
        String about = map.get("atchr");
        DepartmentObject departmentObject = (DepartmentObject) session.getAttribute("CurrDept");
        int did = departmentObject.getDepartment_id();
        instructorObject.setTeacher_id(id);
        instructorObject.setDepartment_id(did);
        instructorObject.setTeacher_name(name);
        instructorObject.setDesignation(des);
        instructorObject.setProfile_link(prfl);
        instructorObject.setAbout_me(about);
        instructorDAO.AddTeacher(instructorObject);
        return modelAndView;
    }
}