package DataAccess;

import TableObjects.InstructorObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by graphics on 5/1/2017.
 */
public class InstructorDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

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
    public List<InstructorObject> GetAllTeachers(int department_id){
        String sql = "SELECT * FROM INSTRUCTOR WHERE DEPARTMENT_ID = ? ";
        List<InstructorObject> instructorObjectList = null;
        try {
            instructorObjectList = jdbcTemplate.query(sql, new Object[]{department_id}, new BeanPropertyRowMapper(InstructorObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return instructorObjectList;
    }
    public InstructorObject GetTeacher(int teacher_id){
        String sql = "SELECT * FROM INSTRUCTOR WHERE TEACHER_ID = ?";
        InstructorObject instructor = jdbcTemplate.queryForObject(sql,new Object[]{teacher_id},new BeanPropertyRowMapper<InstructorObject>(InstructorObject.class));
        return instructor;
    }
    public void AddTeacher(InstructorObject instructorObject){
        String sql = "INSERT INTO INSTRUCTOR (TEACHER_NAME, TEACHER_ID , DESIGNATION, PROFILE_LINK, ABOUT_TEACHER, DEPARTMENT_ID) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,instructorObject.getTeacher_name(),instructorObject.getTeacher_id(),instructorObject.getDesignation(),instructorObject.getProfile_link(),instructorObject.getAbout_me(),instructorObject.getDepartment_id());
    }
    public List<InstructorObject> SearchTeacher(String name){
        String like = "%" + name + "%";
        String sql = "SELECT * FROM INSTRUCTOR WHERE TEACHER_NAME LIKE ?";
        List<InstructorObject> instructorObjectList = null;
        try{
            instructorObjectList = jdbcTemplate.query(sql,new Object[]{like},new BeanPropertyRowMapper(InstructorObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return instructorObjectList;
    }
}
