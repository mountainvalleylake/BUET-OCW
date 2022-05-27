package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by graphics on 7/11/2017.
 */
@Controller
public class LogOut {
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView DoPost(HttpSession session) throws IOException {
        ModelAndView modelAndView = new ModelAndView("mylogin");
        session.removeAttribute("CurrentUser");
        session.removeAttribute("CourseTaken");
        session.removeAttribute("TeacherCourse");
        session.removeAttribute("Teacher");
        session.removeAttribute("CoursesDept");
        session.removeAttribute("TeachersDept");
        session.removeAttribute("CurrDept");
        session.removeAttribute("CourseNow");
        session.removeAttribute("Book");
        session.removeAttribute("Test");
        session.removeAttribute("RCourse");
        session.removeAttribute("RResource");
        session.removeAttribute("Slide");
        session.removeAttribute("Video");
        return modelAndView;
    }
}
