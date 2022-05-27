package Controller;

import DataAccess.*;
import TableObjects.*;
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
@SessionAttributes({"CourseNow","Book","Test","RCourse","RResource","Slide","Video"})
@Controller
public class Courses {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    BookListDAO bookListDAO = (BookListDAO) applicationContext.getBean("booklistDAO");
    InteractiveTestDAO interactiveTestDAO = (InteractiveTestDAO) applicationContext.getBean("interactivetestDAO");
    RelatedCourseDAO relatedCourseDAO = (RelatedCourseDAO) applicationContext.getBean("relatedcourseDAO");
    RelatedResourceDAO relatedResourceDAO = (RelatedResourceDAO) applicationContext.getBean("relatedresourceDAO");
    SlideDAO slideDAO = (SlideDAO) applicationContext.getBean("slideDAO");
    VideoTutorialDAO videoTutorialDAO = (VideoTutorialDAO) applicationContext.getBean("videotutorialDAO");
    CourseDAO courseDAO = (CourseDAO) applicationContext.getBean("courseDAO");
    CourseTakenDAO courseTakenDAO = (CourseTakenDAO) applicationContext.getBean("coursetakenDAO");
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView GetCourse(@RequestParam("id") String course_id, ModelMap modelMap, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/courses");
        List<BookListObject> bookListObjectList = bookListDAO.GetAllBooks(course_id);
        List<InteractiveTestObject> interactiveTestObjectList = interactiveTestDAO.GetAllTests(course_id);
        List<RelatedCourseObject> relatedCourseObjectList = relatedCourseDAO.GetAllRelatedCourse(course_id);
        List<RelatedResourceObject> relatedResourceObjectList = relatedResourceDAO.GetAllRelatedResource(course_id);
        List<SlideObject> slideObjectList = slideDAO.GetAllSlide(course_id);
        List<VideoTutorialObject> videoTutorialObjectList = videoTutorialDAO.GetAllVideos(course_id);
        CourseObject courseObject = courseDAO.GetCourse(course_id);
        //Integer c = courseTakenDAO.ShowCount(course_id);
        //System.out.println(c);
        if(session.getAttribute("Book") != null){
            System.out.println("khamchi");
            session.removeAttribute("Book");
        }
        modelMap.addAttribute("Book",bookListObjectList);
        if(session.getAttribute("Test") != null){
            System.out.println("khamchi");
            session.removeAttribute("Test");
        }
        modelMap.addAttribute("Test",interactiveTestObjectList);
        if(session.getAttribute("RCourse") != null){
            session.removeAttribute("RCourse");
        }
        modelMap.addAttribute("RCourse",relatedCourseObjectList);
        if(session.getAttribute("RResource") != null){
            session.removeAttribute("RResource");
        }
        modelMap.addAttribute("RResource",relatedResourceObjectList);
        if(session.getAttribute("Slide") != null){
            session.removeAttribute("Slide");
        }
        modelMap.addAttribute("Slide",slideObjectList);
        if(session.getAttribute("Video") != null){
            System.out.println("Khamchi");
            session.removeAttribute("Video");
        }
        modelMap.addAttribute("Video",videoTutorialObjectList);
        modelMap.addAttribute("CourseNow",courseObject);
        //modelMap.addAttribute("Count",c);
        return modelAndView;
    }
    @RequestMapping(value = "/courses",method = RequestMethod.POST)
    public ModelAndView AddCourse(@RequestParam Map<String,String> map, ModelMap modelMap,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("dept");
        CourseObject courseObject = new CourseObject();
        String course_id = map.get("icrs");
        String course_name = map.get("ncrs");
        String acrs = map.get("acrs");
        String tcrs = map.get("tcrs");
        int tid = Integer.valueOf(tcrs);
        DepartmentObject departmentObject = (DepartmentObject) session.getAttribute("CurrDept");
        int did = departmentObject.getDepartment_id();
        courseObject.setDepartment_id(did);
        courseObject.setCourse_id(course_id);
        courseObject.setCourse_name(course_name);
        courseObject.setAbout_course(acrs);
        courseObject.setTeacher_id(tid);
        courseDAO.InsertCourse(courseObject);
        return modelAndView;
    }
}
