package DataAccess;

import TableObjects.InteractiveTestObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by graphics on 5/1/2017.
 */
public class InteractiveTestDAO {
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

    public List<InteractiveTestObject> GetAllTests(String course_id){
        String sql = "SELECT * FROM INTERACTIVE_TESTS WHERE COURSE_ID = ? ";
        List<InteractiveTestObject> interactiveTestObjectList = null;
        try {
            interactiveTestObjectList = jdbcTemplate.query(sql,new Object[]{course_id},new BeanPropertyRowMapper(InteractiveTestObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return interactiveTestObjectList;
    }
    public void InsertTests(InteractiveTestObject interactiveTestObject){
        String sql = "INSERT INTO INTERACTIVE_TESTS (QUESTION_LINK , ANSWER_LINK , COURSE_ID) VALUES (?,?,?) ";
        jdbcTemplate.update(sql,interactiveTestObject.getQuestion_link(),interactiveTestObject.getAnswer_link(),interactiveTestObject.getCourse_id());
    }
    public List<InteractiveTestObject> SearchTests(String name){
        String like1 = "%" + name + "%";
        String like2 = "%" + name + "%";
        String sql = "SELECT * FROM INTERACTIVE_TESTS WHERE QUESTION_LINK LIKE ? OR ANSWER_LINK LIKE ?";
        List<InteractiveTestObject> interactiveTestObjectList = null;
        try{
            interactiveTestObjectList = jdbcTemplate.query(sql,new Object[]{like1,like2},new BeanPropertyRowMapper(InteractiveTestObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return interactiveTestObjectList;
    }

}
