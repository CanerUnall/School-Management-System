package domain;

import java.util.Date;

public class Attendance {

    private Lessons lesson;

    private Date date;

    public Lessons getLesson() {
        return lesson;
    }

    public void setLesson(Lessons lesson) {
        this.lesson = lesson;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Attendance() {
    }
}
