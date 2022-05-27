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
}
