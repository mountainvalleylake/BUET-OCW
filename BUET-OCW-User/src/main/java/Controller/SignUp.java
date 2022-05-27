package Controller;
import DataAccess.PeopleDAO;
import TableObjects.PeopleObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anisha on 4/22/2017.
 */


@Controller
//@SessionAttributes({"SignUser"})
public class SignUp {
    private Pattern pattern;
    private  String message = "";
    static int invalidEmail = 0;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public void EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    private boolean validate(final String hex) {
        System.out.println("howdy" + hex);
        EmailValidator();
        Matcher matcher = pattern.matcher(hex);
        System.out.println("howdy2" + matcher.matches());
        return matcher.matches();

    }

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    PeopleDAO peopleDAO = (PeopleDAO) applicationContext.getBean("peopleDAO");

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView SignUpLoad() {
        return new ModelAndView("mysignup");
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView Home(@RequestParam Map<String, String> map1, ModelMap modelMap) {
        PeopleObject peopleObject = new PeopleObject();
        int val = 0;
        String user = map1.get("fname") + ' ' + map1.get("lname");
        peopleObject.setProfile_name(user);
        String user_names = map1.get("uname");
        peopleObject.setUser_name(user_names);
        peopleObject.setEmail(map1.get("mail"));
        if (!validate(peopleObject.getEmail())) {
            System.out.println("invalid email" + peopleObject.getEmail());
            peopleObject = null;
            val = 1;
            invalidEmail = 1;
        }
        if (val==0) {
            peopleObject.setPassword(map1.get("pass"));
            peopleObject.setProfession(map1.get("profession"));
            peopleObject.setInstitution(map1.get("institute"));
            peopleObject.setContact_no(map1.get("contact"));
            peopleObject.setCountry(map1.get("country"));
            peopleObject.setDivision(map1.get("division"));
            peopleObject.setDistrict(map1.get("dist"));
            peopleObject.setRoad_no(map1.get("road"));
            peopleObject.setHouse_no(map1.get("house"));
            peopleObject.setDob(map1.get("dob"));
            peopleObject.setGender(map1.get("gender"));
            String date = new SimpleDateFormat("mm-dd-yyyy").format(new Date());
            peopleObject.setRegDate(date);
            peopleDAO.Insert(peopleObject);
            ModelAndView modelAndView = new ModelAndView("mylogin");
            modelAndView.addObject("welcomeMessage", "Hi, " + user + " welcome to the first Spring MVC Application");
            return modelAndView;
        }
        else{
            ModelAndView modelAndView = new ModelAndView("mysignup");
            message = "Invalid Email Format";
            modelAndView.addObject("Invalid Email Please Enter Info Again.", message);
            //modelMap.addAttribute("SignUser",peopleObject);
            return modelAndView;
        }
    }
}

