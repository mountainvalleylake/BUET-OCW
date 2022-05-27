package TableObjects;

import java.io.Serializable;

/**
 * Created by graphics on 4/30/2017.
 */
public class CourseTakenObject implements Serializable {
    int taken_id;
    String email;
    String user_name;
    String course_id;
    public CourseTakenObject(){

    }
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setTaken_id(int taken_id) {
        this.taken_id = taken_id;
    }

    public int getTaken_id() {
        return taken_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }
}
