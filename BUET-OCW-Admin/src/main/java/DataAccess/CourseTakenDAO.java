package DataAccess;

import TableObjects.CourseTakenObject;
import TableObjects.PeopleObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by graphics on 5/1/2017.
 */
public class CourseTakenDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public CourseTakenDAO(){

    }
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public List<CourseTakenObject> ShowTakenCourses(PeopleObject peopleObject){
        List<CourseTakenObject> courseTakenObjectList = null;
        //int user_id = peopleObject.getUser_id();
        String user_name=peopleObject.getUser_name();
        String sql = "SELECT * FROM COURSE_TAKEN WHERE USER_NAME = ?";
        try {
            courseTakenObjectList = jdbcTemplate.query(sql,new Object[]{user_name},new BeanPropertyRowMapper(CourseTakenObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        for (CourseTakenObject c:
             courseTakenObjectList) {
            System.out.println(c.getCourse_id());
        }
        return courseTakenObjectList;
    }
    public Integer ShowCount(String course_id){
        String sql = "SELECT COUNT (*) FROM COURSE_TAKEN GROUP BY COURSE_ID HAVING COURSE_ID = ?";
        Integer custId = jdbcTemplate.queryForObject(
                sql, new Object[] { course_id }, Integer.class);
        return custId;
    }
    public List<CourseTakenObject> GetAllPeople(String course_id){
        String sql = "SELECT * FROM COURSE_TAKEN GROUP BY COURSE_ID HAVING COURSE_ID = ?";
        List<CourseTakenObject> courseTakenObjectList = null;
        try{
           courseTakenObjectList = jdbcTemplate.query(sql,new Object[]{course_id},new BeanPropertyRowMapper(CourseTakenObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return courseTakenObjectList;
    }
}
