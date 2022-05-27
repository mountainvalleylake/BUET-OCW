package Controller;

import DataAccess.VideoTutorialDAO;
import TableObjects.CourseObject;
import TableObjects.VideoTutorialObject;
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
 * Created by graphics on 7/10/2017.
 */
@Controller
public class Video {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    VideoTutorialDAO videoTutorialDAO = (VideoTutorialDAO) applicationContext.getBean("videotutorialDAO");
    @RequestMapping(value = "/video", method = RequestMethod.POST)
    public ModelAndView VideoUpload(@RequestParam Map<String, String> map2, ModelMap modelMap, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("courses");
        CourseObject courseObject = (CourseObject) session.getAttribute("CourseNow");
        VideoTutorialObject videoTutorialObject = new VideoTutorialObject();
        String dept = map2.get("dept");
        String cname = map2.get("cname");
        String tname = map2.get("tname");
        String sno = map2.get("sno");
        String title = dept+" "+cname+" "+tname+" "+sno;
        String link = map2.get("ylink");
        System.out.println(link);
        videoTutorialObject.setCourse_id(courseObject.getCourse_id());
        videoTutorialObject.setTitle(title);
        videoTutorialObject.setLink(link);
        videoTutorialDAO.InsertVideos(videoTutorialObject);
        return modelAndView;
    }
    @RequestMapping(value = "/seevid")
    public ModelAndView SeeVideo(@RequestParam Map<String, String> map2, ModelMap modelMap, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("courses");
        CourseObject courseObject = (CourseObject) session.getAttribute("CourseNow");
        return modelAndView;
    }
}