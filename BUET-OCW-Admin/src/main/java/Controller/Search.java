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

import java.util.List;

/**
 * Created by graphics on 7/12/2017.
 */
@Controller
@SessionAttributes({"sBook","sCourse","sTest","sTeacher","sDept","sSlide","sVideo"})
public class Search {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    BookListDAO bookListDAO = (BookListDAO) applicationContext.getBean("booklistDAO");
    InteractiveTestDAO interactiveTestDAO = (InteractiveTestDAO) applicationContext.getBean("interactivetestDAO");
    DepartmentDAO departmentDAO  = (DepartmentDAO) applicationContext.getBean("departmentDAO");
    InstructorDAO instructorDAO = (InstructorDAO) applicationContext.getBean("instructorDAO");
    SlideDAO slideDAO = (SlideDAO) applicationContext.getBean("slideDAO");
    VideoTutorialDAO videoTutorialDAO = (VideoTutorialDAO) applicationContext.getBean("videotutorialDAO");
    CourseDAO courseDAO = (CourseDAO) applicationContext.getBean("courseDAO");
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ModelAndView GetSearchResult(@RequestParam("searchValue") String searchValue, ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView("search");
        List<BookListObject> bookListObjectList = bookListDAO.SearchBook(searchValue);
        modelMap.addAttribute("sBook",bookListObjectList);
        List<CourseObject> courseObjectList = courseDAO.SearchCourse(searchValue);
        modelMap.addAttribute("sCourse",courseObjectList);
        List<InteractiveTestObject> interactiveTestObjectList = interactiveTestDAO.SearchTests(searchValue);
        modelMap.addAttribute("sTest",interactiveTestObjectList);
        List<InstructorObject> instructorObjectList = instructorDAO.SearchTeacher(searchValue);
        modelMap.addAttribute("sTeacher",instructorObjectList);
        List<DepartmentObject> departmentObjectList = departmentDAO.SearchDept(searchValue);
        modelMap.addAttribute("sDept",departmentObjectList);
        List<SlideObject> slideObjectList = slideDAO.SearchSlide(searchValue);
        modelMap.addAttribute("sSlide",slideObjectList);
        List<VideoTutorialObject> videoTutorialObjectList = videoTutorialDAO.SearchVideo(searchValue);
        modelMap.addAttribute("sVideo",videoTutorialObjectList);
        return modelAndView;
    }
}
