package Controller;

import DataAccess.RelatedResourceDAO;
import TableObjects.CourseObject;
import TableObjects.RelatedResourceObject;
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
public class RelatedResources {
    String paths = "E:/Study Materials/CSE 3-2/Software Lab/Uploads";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    RelatedResourceDAO relatedResourceDAO = (RelatedResourceDAO) applicationContext.getBean("relatedresourceDAO");

    @RequestMapping(value = "/rresource", method = RequestMethod.POST)
    public ModelAndView AdderResource(@RequestParam Map<String, String> map, ModelMap modelMap, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("courses");
        String title = map.get("title");
        String link = map.get("link");
        RelatedResourceObject relatedResourceObject = new RelatedResourceObject();
        CourseObject courseObject = (CourseObject) session.getAttribute("CourseNow");
        relatedResourceObject.setResource_title(title);
        relatedResourceObject.setResource_link(link);
        relatedResourceObject.setCourse_id(courseObject.getCourse_id());
        relatedResourceDAO.InsertRelatedResources(relatedResourceObject);
        return modelAndView;
    }
    @RequestMapping(value = "/resource")
    public ModelAndView ResourceLink(){
        ModelAndView modelAndView = new ModelAndView("courses");
        return modelAndView;
    }
}