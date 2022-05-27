package TableObjects;

import java.io.Serializable;

/**
 * Created by graphics on 4/30/2017.
 */
public class InstructorObject implements Serializable {
    String teacher_name;
    int teacher_id;
    String designation;
    String profile_link;
    String about_me;
    int department_id;

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getDesignation() {
        return designation;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
    public String getTeacher_name() {
        return teacher_name;
    }

    public String getProfile_link() {
        return profile_link;
    }

    public void setProfile_link(String profile_link) {
        this.profile_link = profile_link;
    }
}
