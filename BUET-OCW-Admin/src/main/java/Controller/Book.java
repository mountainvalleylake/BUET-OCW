package Controller;

import DataAccess.BookListDAO;
import TableObjects.BookListObject;
import TableObjects.CourseObject;
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
public class Book {
    String paths = "E:/Study Materials/CSE 3-2/Software Lab/Uploads";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    BookListDAO bookListDAO = (BookListDAO) applicationContext.getBean("booklistDAO");
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ModelAndView BookUpload(@RequestParam Map<String, String> map, @RequestParam CommonsMultipartFile file, ModelMap modelMap, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("courses");
        String ext = "";
        BookListObject bookListObject = new BookListObject();
        String book_name = map.get("bname");
        String author_name = map.get("aname");
        String edition = map.get("ed");
        CourseObject courseObject = (CourseObject) session.getAttribute("CourseNow");
        bookListObject.setBook_author(author_name);
        bookListObject.setBook_edition(edition);
        bookListObject.setCourse_id(courseObject.getCourse_id());
        String book = book_name + "_" + courseObject.getCourse_id();
        String t = file.getOriginalFilename();
        int pos = t.lastIndexOf(".");
        if (pos > 0) {
            ext = t.substring(pos,t.length());
        }
        System.out.println(t);
        //file uploading
        try {
            byte[] bytes = file.getBytes();
            System.out.println(ext);
            String ultpath = paths+ "/" + book + ext ;
            System.out.println(ultpath);
            book_name = book + ext;
            bookListObject.setBook_name(book_name);
            bookListDAO.InsertBooks(bookListObject);
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
    @RequestMapping(value = "/seebook")
    public ModelAndView SeeBook(@RequestParam("id") String book, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("/books");
        //BookListObject bookListObject = bookListDAO.GetBook(book);
        System.out.println(book);
        String path = paths + "/" + book;
        System.out.println(path);
        try {
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            response.setContentType("application/pdf");
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", "inline;filename=\"" + book + "\"");
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}