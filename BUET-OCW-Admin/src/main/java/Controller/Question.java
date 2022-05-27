package Controller;

import DataAccess.InteractiveTestDAO;
import TableObjects.CourseObject;
import TableObjects.InteractiveTestObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Map;

/**
 * Created by graphics on 7/10/2017.
 */
@Controller
public class Question {
    String paths = "E:/Study Materials/CSE 3-2/Software Lab/Uploads";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    InteractiveTestDAO interactiveTestDAO = (InteractiveTestDAO) applicationContext.getBean("interactivetestDAO");
    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public ModelAndView QuestionUpload(@RequestParam Map<String, String> map, @RequestParam CommonsMultipartFile file, ModelMap modelMap, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("courses");
        String ext = "";
        InteractiveTestObject interactiveTestObject = new InteractiveTestObject();
        CourseObject courseObject = (CourseObject) session.getAttribute("CourseNow");
        String qlink = map.get("qlink");
        String alink = map.get("alink");
        interactiveTestObject.setCourse_id(courseObject.getCourse_id());
        String question = qlink + "_" + courseObject.getCourse_id();
        String answer = alink + "_" + courseObject.getCourse_id();
        String t = file.getOriginalFilename();
        int pos = t.lastIndexOf(".");
        if (pos > 0) {
            ext = t.substring(pos,t.length());
        }
        try {
            byte[] bytes = file.getBytes();
            System.out.println(ext);
            String ultpath = paths+ "/" + question + ext ;
            System.out.println(ultpath);
            qlink = question + ext;
            alink = answer + ext;
            interactiveTestObject.setQuestion_link(qlink);
            interactiveTestObject.setAnswer_link(alink);
            File upfile = new File(ultpath);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(upfile)));
            dos.write(bytes);
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        interactiveTestDAO.InsertTests(interactiveTestObject);
        return modelAndView;
    }
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