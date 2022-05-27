package DataAccess;

import TableObjects.CourseAdminObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.activation.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by graphics on 7/6/2017.
 */
public class CourseAdminDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public CourseAdminDAO(){

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

    public List<CourseAdminObject> GetMyTakenCourses(int admin_id){
        List<CourseAdminObject> courseAdminObjectList;
        String sql = "SELECT * FROM COURSE_ADMIN WHERE ADMIN_ID = ?";
        courseAdminObjectList = jdbcTemplate.query(sql, new Object[]{admin_id}, new BeanPropertyRowMapper(CourseAdminObject.class));
        return courseAdminObjectList;
    }
}
