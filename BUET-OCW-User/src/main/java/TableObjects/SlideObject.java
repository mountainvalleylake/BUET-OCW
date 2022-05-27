package TableObjects;

import java.io.Serializable;

/**
 * Created by graphics on 5/1/2017.
 */
public class SlideObject implements Serializable {
    String slide_title;
    String slide_link;
    String course_id;
    public SlideObject(){

    }
    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getSlide_link() {
        return slide_link;
    }

    public void setSlide_link(String slide_link) {
        this.slide_link = slide_link;
    }

    public String getSlide_title() {
        return slide_title;
    }

    public void setSlide_title(String slide_title) {
        this.slide_title = slide_title;
    }
}
