package TableObjects;

import java.io.Serializable;

/**
 * Created by graphics on 7/6/2017.
 */
public class CourseAdminObject implements Serializable {
    int admin_id;
    int id;
    String course_id;
    public CourseAdminObject(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }
}
