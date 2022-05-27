package DataAccess;

import TableObjects.DepartmentObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by graphics on 5/1/2017.
 */
public class DepartmentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public DepartmentDAO(){

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
    public List<DepartmentObject> GetAllDepartments(){
        List<DepartmentObject> departmentObjectList = null;
        String sql = "SELECT * FROM DEPARTMENT";
        try{
            departmentObjectList = jdbcTemplate.query(sql,new BeanPropertyRowMapper(DepartmentObject.class));
        }catch (Exception e){

        }
        return departmentObjectList;
    }
    public DepartmentObject GetDepartmentID(int dept_id){
        String sql = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID = ? ";
        DepartmentObject departmentObject = jdbcTemplate.queryForObject(sql,new Object[]{dept_id},new BeanPropertyRowMapper<DepartmentObject>(DepartmentObject.class));
        return departmentObject;
    }
    public List<DepartmentObject> SearchDept(String name){
        String like = "%" + name + "%";
        List<DepartmentObject> departmentObjectList = null;
        String sql = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_NAME LIKE ?";
        try {
            departmentObjectList = jdbcTemplate.query(sql,new Object[]{like},new BeanPropertyRowMapper(DepartmentObject.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return departmentObjectList;
    }

}
