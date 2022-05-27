package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by graphics on 7/11/2017.
 */
@Controller
public class RelatedResources {
    @RequestMapping(value = "/resource")
    public ModelAndView ResourceLink(){
        ModelAndView modelAndView = new ModelAndView("courses");
        return modelAndView;
    }
}
