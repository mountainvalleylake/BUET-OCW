package Controller;

import TableObjects.CourseObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping(value = "/seevid")
    public ModelAndView VideoUpload(@RequestParam Map<String, String> map2, ModelMap modelMap, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("courses");
        CourseObject courseObject = (CourseObject) session.getAttribute("CourseNow");
        return modelAndView;
    }
}