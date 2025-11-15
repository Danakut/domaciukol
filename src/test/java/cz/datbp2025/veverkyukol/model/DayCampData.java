package cz.datbp2025.veverkyukol.model;

public class DayCampData {

    private final CourseTime courseTime;
    private final int childCount;
    private final String age;
    private final int teacherCount;

    public enum CourseTime {
        AM,
        PM
    }

    public DayCampData(CourseTime courseTime, int childCount, String age, int teacherCount) {
        this.courseTime = courseTime;
        this.childCount = childCount;
        this.age = age;
        this.teacherCount = teacherCount;
    }

    public CourseTime courseTime() {
        return courseTime;
    }

    public int childCount() {
        return childCount;
    }

    public String age() {
        return age;
    }

    public int teacherCount() {
        return teacherCount;
    }
}