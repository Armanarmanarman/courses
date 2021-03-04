package model;

import database.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import static model.Teacher.incCourseId;


public class Main {
    static ArrayList<Courses> coursesList = new ArrayList<>();
    static ArrayList<Courses> coursesRequestList = new ArrayList<>();


// We need following lines only when we are using array to store data instead of DBMS
//    public static void insert() {
//        //courses
//        coursesList.add(new Courses(1, "Java", "Object Oriented Programming", "Programming"));
//        coursesList.add(new Courses(2, "Calculus 2", "Math au mau", "Math"));
//        coursesList.add(new Courses(3, "C++", "C++ is a general-purpose programming language created by Bjarne Stroustrup as an extension of the C programming language", "Programming"));
//
//    }
//
//    public static void getCoursesByTitle(String input) {
//        int cnt = 0;
//        for (Courses courses : coursesList) {
//
//            if (courses.getTitle().equals(input)) {
//                System.out.println(courses.toString());
//                cnt++;
//
//            }
//            if (cnt == 0) {
//                System.out.println("No courses found with title " + input);
//            }
//
//
//        }
//    }
//
//    public static void getCourseByDiscipline(String input) {
//        int cnt = 0;
//        for (Courses courses : coursesList) {
//
//            if (Objects.equals(courses.getDiscipline(), input)) {
//                System.out.println(courses.toString());
//                cnt++;
//            }
//            if (cnt == 0) {
//                System.out.println("No courses found with discipline " + input);
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        insert();
        while (true) {
            System.out.println("You are teacher or student?");
            System.out.println("1: Student");
            System.out.println("2: Teacher");
            int answer;
            answer = scanner.nextInt();
            try{
                if (answer == 1) {
                    System.out.println("1: Search courses");
                    System.out.println("2: Request a course");
                    answer = scanner.nextInt();

                    //Searching for course
                    if (answer == 1) {
                        System.out.println("1: Search by title");
                        System.out.println("2: Search by discipline");
                        answer = scanner.nextInt();

                        //search by title
                        if (answer == 1) {
                            System.out.println("Searching by title");
                            System.out.println("Please enter title");
//                        String s;
//                        s = scanner.next();
//
//                        getCoursesByTitle(s);

                        }
                        //search by discipline
                        else if (answer == 2) {
                            System.out.println("Searching by discipline");
                            System.out.println("Please choose discipline");
                            String s;
                            s = scanner.next();
//                        getCourseByDiscipline(s);

                        }
                    }

                    //Requesting a course
                    else if (answer == 2) //Request a course by adding course info to array
                        {

                        System.out.println("Requesting a new course");
                        System.out.println("Enter title of the course:");
                        String title = scanner.next();

                        System.out.println("Enter description of the course: ");
                        String description = scanner.next();

                        System.out.println("Enter which disciple is this course: ");
                        String discipline = scanner.next();

                        coursesRequestList.add(new Courses(Teacher.getRequestId(), title, description, discipline));
                        Teacher.incRequestId();
                    }
                }
                //TEACHER
                else if (answer == 2) {
                    System.out.println("1: Add course");
                    System.out.println("2: Student's requests");
                    System.out.println("3: Delete all courses");
                    answer = scanner.nextInt();

                    if (answer == 1)//add course to db
                    {
                        System.out.println("Enter course Title:");
                        String title = "'" + getInput() + "'";//get input gets multiple string inputs
                        System.out.println("Enter course Description:");

                        String description = "'" + getInput() + "'"; // ' <= we need to wrap input in this quote so sql can read it
                        System.out.println("Enter the Discipline of the course:");
                        String discipline = "'" + getInput() + "'";


                        DBUtils.insertIntoTable("courses", new String[]{//see description on DBUtils class
                                String.valueOf(Teacher.getCourseId()),
                                title,
                                description,
                                discipline});
                        incCourseId();
                    } else if (answer == 2)//show request array if there are any
                    {
                        int cnt = 0;
                        for (Courses i : coursesRequestList) {//loop through array
                            System.out.println(i);
                            cnt++;
                        }
                        if (cnt == 0) {//if integer cnt is not incremented it means there are no requests
                            System.out.println("No requests found!");
                        }
                    } else if (answer == 3)//delete all data from table
                        {
                        DBUtils.deleteTable("courses");
                        Teacher.setZeroCourseId();//set course ud to zero
                    }
                    else {
                        System.out.println("Enter numbers '1' or '2'");
                    }


                } else System.out.println("Please enter '1' or '2' ");
            }catch(InputMismatchException ex){
            System.out.println("Exception occurred :" + ex);}

        }
    }

    private static String getInput() {
        Scanner scanner2 = new Scanner(System.in);
        return scanner2.nextLine();
    }

}
