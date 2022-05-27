package Controller;

import DataAccess.SlideDAO;
import TableObjects.CourseObject;
import TableObjects.SlideObject;
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
public class Slide {
    String paths = "E:/Study Materials/CSE 3-2/Software Lab/Uploads";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    SlideDAO slideDAO = (SlideDAO) applicationContext.getBean("slideDAO");
    @RequestMapping(value = "/slides", method = RequestMethod.POST)
    public ModelAndView SlideUpload(@RequestParam CommonsMultipartFile file,@RequestParam Map<String, String> map, ModelMap modelMap, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("courses");
        SlideObject slideObject = new SlideObject();
        CourseObject courseObject = (CourseObject) session.getAttribute("CourseNow");
        String dept = map.get("dept");
        String cname = map.get("cname");
        String tname = map.get("tname");
        String sno = map.get("sno");
        String title = dept + "_" + cname + "_" + tname + "_" +sno;
        String t = file.getOriginalFilename();
        String ext = "";
        int pos = t.lastIndexOf(".");
        if (pos > 0) {
            ext = t.substring(pos,t.length());
        }
        String link = title + ext;
        slideObject.setCourse_id(courseObject.getCourse_id());
        slideObject.setSlide_link(link);
        slideObject.setSlide_title(title);
        slideDAO.InsertSlides(slideObject);
        try {
            byte[] bytes = file.getBytes();
            String ultpath = paths+ "/" + link;
            File upfile = new File(ultpath);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(upfile)));
            dos.write(bytes);
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
    @RequestMapping(value = "/seeslide")
    public ModelAndView SlideShow(@RequestParam("id") String slide, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("slide");
        String path = paths + "/" + slide;
        try {
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            response.setContentType("application/pdf");
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", "inline;filename=\"" + slide + "\"");
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}