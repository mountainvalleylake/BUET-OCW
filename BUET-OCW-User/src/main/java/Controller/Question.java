package Controller;

import DataAccess.InteractiveTestDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by graphics on 7/10/2017.
 */
@Controller
public class Question {
    String paths = "E:/Study Materials/CSE 3-2/Software Lab/Uploads";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    InteractiveTestDAO interactiveTestDAO = (InteractiveTestDAO) applicationContext.getBean("interactivetestDAO");
    @RequestMapping(value = "/seeques")
    public ModelAndView SeeBook(@RequestParam("id") String q, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("ques");
        System.out.println(q);
        String path = paths + "/" + q;
        System.out.println(path);
        try {
            File f = new File(path);
            FileInputStream inputStream = new FileInputStream(f);
            response.setContentType("application/pdf");
            response.setContentLength((int) f.length());
            response.setHeader("Content-Disposition", "inline;filename=\"" + q + "\"");
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}