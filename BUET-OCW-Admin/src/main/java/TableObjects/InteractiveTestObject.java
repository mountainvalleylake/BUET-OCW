package TableObjects;

import java.io.Serializable;

/**
 * Created by graphics on 5/1/2017.
 */
public class InteractiveTestObject implements Serializable {
    String question_link;
    String answer_link;
    String course_id;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getAnswer_link() {
        return answer_link;
    }

    public void setAnswer_link(String answer_link) {
        this.answer_link = answer_link;
    }

    public String getQuestion_link() {
        return question_link;
    }

    public void setQuestion_link(String question_link) {
        this.question_link = question_link;
    }
}
