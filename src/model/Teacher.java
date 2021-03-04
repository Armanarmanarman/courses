package model;

public class Teacher extends Person{
    private static int CourseId = 0;
    private static int RequestId = 0;
    public Teacher(int id, String name, String role) {
        super(id, name, role);
    }


    public static int getCourseId() {
        return CourseId;
    }

    public static void incCourseId() {
        CourseId++;
    }

    public static void setZeroCourseId() {
        CourseId = 0;
    }

    public static int getRequestId() {
        return RequestId;
    }

    public static void incRequestId() {
        RequestId++;
    }
}
