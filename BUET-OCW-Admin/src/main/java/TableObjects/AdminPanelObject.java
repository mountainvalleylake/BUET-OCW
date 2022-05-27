package TableObjects;

/**
 * Created by graphics on 5/6/2017.
 */
public class AdminPanelObject {
    int admin_id;
    String admin_name;
    String password;
    String join_date;
    public AdminPanelObject(){

    }

    public int getAdmin_id() {
        return admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public String getJoin_date() {
        return join_date;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }


}
