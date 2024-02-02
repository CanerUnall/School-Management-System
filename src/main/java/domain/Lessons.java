package domain;

public class Lessons {

    private LessonNames name;
    private Teacher teacher;
    private int lessonCredit;
    private double lessonFee;
    private Integer studentNote;
    private String day;


    private SuccessDegree lessonSuccessDegree;

    public Lessons(LessonNames name, Teacher teacher, int lessonCredit, double lessonFee, String day) {
        this.name = name;
        this.teacher = teacher;
        this.lessonCredit = lessonCredit;
        this.lessonFee = lessonFee;
        this.day = day;
        this.studentNote= null;
        this.lessonSuccessDegree=null;
    }

    public Lessons() {
    }

    public SuccessDegree getLessonSuccessDegree() {
        return lessonSuccessDegree;
    }

    public void setLessonSuccessDegree(SuccessDegree lessonSuccessDegree) {
        this.lessonSuccessDegree = lessonSuccessDegree;
    }

    public Integer getStudentNote() {
        return studentNote;
    }

    public void setStudentNote(Integer studentNote) {
        this.studentNote = studentNote;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LessonNames getName() {
        return name;
    }

    public void setName(LessonNames name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getLessonCredit() {
        return lessonCredit;
    }

    public void setLessonCredit(int lessonCredit) {
        this.lessonCredit = lessonCredit;
    }

    public double getLessonFee() {
        return lessonFee;
    }

    public void setLessonFee(double lessonFee) {
        this.lessonFee = lessonFee;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "name=" + name +
                ", teacher=" + teacher +
                ", lessonCredit=" + lessonCredit +
                ", lessonFee=" + lessonFee +
                ", studentNote=" + studentNote +
                ", day='" + day + '\'' +
                ", lessonSuccessDegree=" + lessonSuccessDegree +
                '}';
    }
}
