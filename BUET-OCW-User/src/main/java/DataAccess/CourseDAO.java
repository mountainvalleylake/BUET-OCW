package DataAccess;

import TableObjects.CourseObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by graphics on 4/29/2017.
 */
public class CourseDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public CourseDAO(){

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
    //All CRUD Operations here
    public List<CourseObject> GetAllDepartmentCourses(int dept_id){
        String sql = "SELECT * FROM COURSE WHERE DEPARTMENT_ID = ?";
        List<CourseObject> courseObjectList = null;
        try{
            courseObjectList = jdbcTemplate.query(sql,new Object[]{dept_id},new BeanPropertyRowMapper(CourseObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return courseObjectList;
    }
    public List<CourseObject> GetAllTeacherCourses(int teacher_id){
        List<CourseObject> courseObjectList = null;
        String sql = "SELECT * FROM COURSE WHERE TEACHER_ID = ?";
        try{
            courseObjectList = jdbcTemplate.query(sql,new Object[]{teacher_id}, new BeanPropertyRowMapper(CourseObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return courseObjectList;
    }
    public CourseObject GetCourse(String course_id){
        String sql = "SELECT * FROM COURSE WHERE COURSE_ID = ?";
        CourseObject courseObject = jdbcTemplate.queryForObject(sql,new Object[]{course_id},new BeanPropertyRowMapper<CourseObject>(CourseObject.class));
        System.out.println(courseObject.getCourse_name() + courseObject.getDepartment_id() + courseObject.getTeacher_id());
        return courseObject;
    }
    public List<CourseObject> SearchCourse(String name){
        String like_id = "%" + name + "%";
        String like_name = "%" + name + "%";
        List<CourseObject> courseObjectList = null;
        String sql = "SELECT * FROM COURSE WHERE COURSE_ID LIKE ? OR COURSE_NAME LIKE ?";
        try {
            courseObjectList = jdbcTemplate.query(sql,new Object[]{like_id,like_name},new BeanPropertyRowMapper(CourseObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return courseObjectList;
    }
}
