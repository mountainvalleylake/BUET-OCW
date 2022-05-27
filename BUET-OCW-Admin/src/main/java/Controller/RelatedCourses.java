package Controller;

import DataAccess.RelatedCourseDAO;
import TableObjects.CourseObject;
import TableObjects.RelatedCourseObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by graphics on 7/11/2017.
 */
@Controller
public class RelatedCourses {
    String paths = "E:/Study Materials/CSE 3-2/Software Lab/Uploads";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    RelatedCourseDAO relatedCourseDAO = (RelatedCourseDAO) applicationContext.getBean("relatedcourseDAO");
    @RequestMapping(value = "/rcourse",method = RequestMethod.POST)
    public ModelAndView AdderCourse(@RequestParam Map<String, String> map, ModelMap modelMap, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("courses");
        String course = map.get("clink");
        RelatedCourseObject relatedCourseObject = new RelatedCourseObject();
        relatedCourseObject.setCourse_name(course);
        CourseObject courseObject = (CourseObject) session.getAttribute("CourseNow");
        relatedCourseObject.setCourse_id(courseObject.getCourse_id());
        relatedCourseDAO.InsertRelatedCourses(relatedCourseObject);
        return modelAndView;
    }
}
