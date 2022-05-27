package TableObjects;

import java.io.Serializable;

/**
 * Created by graphics on 5/1/2017.
 */
public class RelatedResourceObject implements Serializable {
    String resource_title;
    String resource_link;
    String course_id;

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getResource_link() {
        return resource_link;
    }

    public void setResource_link(String resource_link) {
        this.resource_link = resource_link;
    }

    public String getResource_title() {
        return resource_title;
    }

    public void setResource_title(String resource_title) {
        this.resource_title = resource_title;
    }
}
