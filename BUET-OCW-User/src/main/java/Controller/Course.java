package Controller;

import DataAccess.*;
import TableObjects.*;
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
@SessionAttributes({"CourseNow","Book","Test","RCourse","RResource","Slide","Video"})
@Controller
public class Course {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    BookListDAO bookListDAO = (BookListDAO) applicationContext.getBean("booklistDAO");
    InteractiveTestDAO interactiveTestDAO = (InteractiveTestDAO) applicationContext.getBean("interactivetestDAO");
    RelatedCourseDAO relatedCourseDAO = (RelatedCourseDAO) applicationContext.getBean("relatedcourseDAO");
    RelatedResourceDAO relatedResourceDAO = (RelatedResourceDAO) applicationContext.getBean("relatedresourceDAO");
    SlideDAO slideDAO = (SlideDAO) applicationContext.getBean("slideDAO");
    VideoTutorialDAO videoTutorialDAO = (VideoTutorialDAO) applicationContext.getBean("videotutorialDAO");
    CourseDAO courseDAO = (CourseDAO) applicationContext.getBean("courseDAO");
    @RequestMapping(value = "/courses")
    public ModelAndView GetCourses(@RequestParam("id") String course_id, ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView("courses");
        List<BookListObject> bookListObjectList = bookListDAO.GetAllBooks(course_id);
        List<InteractiveTestObject> interactiveTestObjectList = interactiveTestDAO.GetAllTests(course_id);
        List<RelatedCourseObject> relatedCourseObjectList = relatedCourseDAO.GetAllRelatedCourse(course_id);
        List<RelatedResourceObject> relatedResourceObjectList = relatedResourceDAO.GetAllRelatedResource(course_id);
        List<SlideObject> slideObjectList = slideDAO.GetAllSlide(course_id);
        List<VideoTutorialObject> videoTutorialObjectList = videoTutorialDAO.GetAllVideos(course_id);
        CourseObject courseObject = courseDAO.GetCourse(course_id);
        modelMap.addAttribute("Book",bookListObjectList);
        modelMap.addAttribute("Test",interactiveTestObjectList);
        modelMap.addAttribute("RCourse",relatedCourseObjectList);
        modelMap.addAttribute("RResource",relatedResourceObjectList);
        modelMap.addAttribute("Slide",slideObjectList);
        modelMap.addAttribute("Video",videoTutorialObjectList);
        modelMap.addAttribute("CourseNow",courseObject);
        //System.out.println("meaw " + course_id);
        return modelAndView;
    }
}
