package DataAccess;

import TableObjects.RelatedCourseObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by graphics on 5/1/2017.
 */
public class RelatedCourseDAO {
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
    public List<RelatedCourseObject> GetAllRelatedCourse(String course_id){
        List<RelatedCourseObject> relatedCourseObjectList = null;
        String sql = "SELECT * FROM RELATED_COURSES WHERE COURSE_ID = ? ";
        try {
            relatedCourseObjectList = jdbcTemplate.query(sql, new Object[]{course_id}, new BeanPropertyRowMapper(RelatedCourseObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return relatedCourseObjectList;
    }
    public void InsertRelatedCourses(RelatedCourseObject relatedCourseObject){
        String sql = "INSERT INTO RELATED_COURSES (COURSE_NAME , COURSE_ID) VALUES (?,?)";
        jdbcTemplate.update(sql,relatedCourseObject.getCourse_name(),relatedCourseObject.getCourse_id());
    }
}
