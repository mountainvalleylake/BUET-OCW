package DataAccess;

import TableObjects.RelatedCourseObject;
import TableObjects.RelatedResourceObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by graphics on 5/1/2017.
 */
public class RelatedResourceDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public RelatedResourceDAO(){

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
    public List<RelatedResourceObject> GetAllRelatedResource(String course_id){
        List<RelatedResourceObject> relatedResourceObjectList = null;
        String sql = "SELECT * FROM RELATED_RESOURCES WHERE COURSE_ID = ? ";
        try {
            relatedResourceObjectList = jdbcTemplate.query(sql, new Object[]{course_id}, new BeanPropertyRowMapper(RelatedResourceObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return relatedResourceObjectList;
    }
}
