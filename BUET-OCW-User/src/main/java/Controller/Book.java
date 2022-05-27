package Controller;

import DataAccess.BookListDAO;
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
public class Book {
    String paths = "E:/Study Materials/CSE 3-2/Software Lab/Uploads";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    BookListDAO bookListDAO = (BookListDAO) applicationContext.getBean("booklistDAO");
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