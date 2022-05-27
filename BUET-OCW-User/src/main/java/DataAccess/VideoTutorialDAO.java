package DataAccess;

import TableObjects.VideoTutorialObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by graphics on 5/1/2017.
 */
public class VideoTutorialDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public VideoTutorialDAO(){

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
    public List<VideoTutorialObject> GetAllVideos(String course_id){
        List<VideoTutorialObject> videoTutorialObjectList = null;
        String sql = "SELECT * FROM VIDEO_TUTORIAL WHERE COURSE_ID = ? ";
        try {
            videoTutorialObjectList = jdbcTemplate.query(sql, new Object[]{course_id}, new BeanPropertyRowMapper(VideoTutorialObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return videoTutorialObjectList;
    }
    public List<VideoTutorialObject> SearchVideo(String name) {
        String like = "%" + name + "%";
        String sql = "SELECT * FROM VIDEO_TUTORIAL WHERE TITLE LIKE ?";
        List<VideoTutorialObject> videoTutorialObjectList = null;
        try {
            videoTutorialObjectList = jdbcTemplate.query(sql, new Object[]{like}, new BeanPropertyRowMapper(VideoTutorialObject.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videoTutorialObjectList;
    }
}
