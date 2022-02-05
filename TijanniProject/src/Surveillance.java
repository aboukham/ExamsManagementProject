import java.util.Arrays;

public class Surveillance {
    private String  classroomName;
    private String[]  supervisorsName;
    private String  examName;

    public Surveillance(String classroomName, String[] supervisorsName, String examName) {
        this.classroomName = classroomName;
        this.supervisorsName = supervisorsName;
        this.examName = examName;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String[] getSupervisorsName() {
        return supervisorsName;
    }

    public void setSupervisorsName(String[] supervisorsName) {
        this.supervisorsName = supervisorsName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    @Override
    public String toString() {
        return "Surveillance{" +
                "classroomName='" + classroomName + '\'' +
                ", supervisorsName=" + Arrays.toString(supervisorsName) +
                ", examName='" + examName + '\'' +
                '}';
    }
}
