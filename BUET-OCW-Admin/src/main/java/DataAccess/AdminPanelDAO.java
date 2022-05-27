package DataAccess;

import TableObjects.AdminPanelObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;

/**
 * Created by graphics on 5/6/2017.
 */
public class AdminPanelDAO {
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
    public AdminPanelObject LoginValidate(int admin_id , String password){
        AdminPanelObject adminPanelObject = null;
        String sql = "SELECT * FROM ADMIN_PANEL WHERE ADMIN_ID = ? AND ADMIN_PASS = ? ";
        try{
            adminPanelObject = jdbcTemplate.queryForObject(sql,new Object[]{admin_id,password},new BeanPropertyRowMapper<AdminPanelObject>(AdminPanelObject.class));
        }catch (Exception e){
            e.printStackTrace();
            return adminPanelObject;
        }
        System.out.println("printing after query");
        System.out.println(adminPanelObject.getAdmin_id()+" " + adminPanelObject.getAdmin_name()+ " "+adminPanelObject.getJoin_date()+" "+adminPanelObject.getPassword());
        System.out.println("query ends here");
        return adminPanelObject;
    }
    public AdminPanelObject GetAdmin(int user_id , String password){
        AdminPanelObject adminPanelObject = null;
        String sql = "SELECT * FROM ADMIN_PANEL WHERE ADMIN_ID = ? AND ADMIN_PASS = ? ";
        try {
            adminPanelObject = jdbcTemplate.queryForObject(sql,new Object[]{user_id,password},new BeanPropertyRowMapper<AdminPanelObject>(AdminPanelObject.class));
        }catch (Exception e){
            System.out.println("Found NULL");
            //return p;
        }
        return adminPanelObject;
    }
    /*public void InsertAdmin(AdminPanelObject adminPanelObject){
        String sql1 = "INSERT INTO ADMIN_PANEL () VALUES ()";
    }*/
}
