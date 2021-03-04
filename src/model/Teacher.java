package model;

public class Teacher extends Person{
    private static int CourseId = 3;

    public Teacher(int id, String name, String role) {
        super(id, name, role);
    }


    public static int getCourseId() {
        return CourseId;
    }

    public static void incCourseId() {
        CourseId++;
    }
}
