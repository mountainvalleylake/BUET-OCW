package TableObjects;

import java.io.Serializable;

/**
 * Created by graphics on 4/30/2017.
 */
public class DepartmentObject implements Serializable {
    int department_id;
    String department_name;
    public DepartmentObject(){

    }
    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
