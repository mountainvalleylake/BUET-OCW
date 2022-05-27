package DataAccess;
import TableObjects.PeopleObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by graphics on 4/29/2017.
 */
public class PeopleDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public PeopleDAO(){

    }
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    //All CRUD Operations here
    public void Insert(PeopleObject peopleObject) {
        //System.out.println("Here I am");
        int id;
        String sql1 = "SELECT * FROM PEOPLE P1 WHERE P1.USER_ID = (SELECT MAX(USER_ID) FROM PEOPLE P2)";
        PeopleObject p = jdbcTemplate.queryForObject(sql1, new BeanPropertyRowMapper<PeopleObject>(PeopleObject.class));
        id = p.getUser_id();
        System.out.println("MAX ID returned: "+id);
        id++;
        peopleObject.setUser_id(id);
        SimpleDateFormat sdf1 = new SimpleDateFormat("mm-dd-yyyy");
        java.util.Date date1 = null;
        try {
            date1 = sdf1.parse(peopleObject.getDob());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date sqldob = null;
        if (date1 != null) {
            sqldob = new Date(date1.getTime());
        }
        java.util.Date date2 = null;
        try {
            date2 = sdf1.parse(peopleObject.getRegDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("point 2");
        java.sql.Date sqlregd = new Date(date2.getTime());
        String  sql2 = "INSERT INTO PEOPLE (USER_NAME, USER_ID,PROFILE_NAME, EMAIL, PASSWORDS, INSTITUTION, PROFESSION, GENDER, COUNTRY, DISTRICT, DIVISION, ROAD_NO, HOUSE_NO, CONTACT_NO, DOB, JOIN_DATE ) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql2,peopleObject.getUser_name(),peopleObject.getUser_id(),peopleObject.getProfile_name(), peopleObject.getEmail(),peopleObject.getPassword(), peopleObject.getInstitution(),
                peopleObject.getProfession(),peopleObject.getGender(),peopleObject.getCountry(),peopleObject.getDistrict(), peopleObject.getDivision(), peopleObject.getRoad_no(),
                peopleObject.getHouse_no(),peopleObject.getContact_no(),sqldob,sqlregd);
        System.out.println("point 3");
    }
    public PeopleObject LoginValidate(String uname, String pass){
        PeopleObject p = null;
        String sql = "SELECT * FROM PEOPLE WHERE USER_NAME = ? AND PASSWORDS = ? ";
        try {
            p = jdbcTemplate.queryForObject(sql,new Object[]{uname,pass},new BeanPropertyRowMapper<PeopleObject>(PeopleObject.class));
        }catch (Exception e){
            System.out.println("Found NULL");
            //return p;
        }
        System.out.println(p.getUser_name() + p.getCountry());
        return p;
    }
    public PeopleObject ShowingProfile(String uname, String pass){
        PeopleObject p = null;
        String sql = "SELECT * FROM PEOPLE WHERE USER_NAME = ? AND PASSWORDS = ? ";
        try {
            p = jdbcTemplate.queryForObject(sql, new Object[]{uname, pass}, new BeanPropertyRowMapper<PeopleObject>(PeopleObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }
}
