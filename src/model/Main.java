package model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    static ArrayList<Courses> coursesList = new ArrayList<>();
    static ArrayList<Courses> coursesRequestList = new ArrayList<>();

    static ArrayList<Student> studentsList = new ArrayList<>();
    public static void insert(){
        //courses
        coursesList.add(new Courses(1, "Java", "Object Oriented Programming", "Programming"));
        coursesList.add(new Courses(2, "Calculus 2", "Math au mau", "Math"));
        coursesList.add(new Courses(3, "C++", "C++ is a general-purpose programming language created by Bjarne Stroustrup as an extension of the C programming language", "Programming"));

    }
    public static void getCoursesByTitle(String input){
        int cnt = 0;
        for(Courses courses : coursesList){

            if(courses.getTitle().equals(input)){
                System.out.println(courses.toString());
                int i = cnt++;

            }
            if(cnt == 0){
                System.out.println("No courses found with title " + input);
            }


        }
    }
    public static void getCourseByDiscipline(String input){
        int cnt=0;
        for(Courses courses: coursesList){

            if(Objects.equals(courses.getDiscipline(), input)){
                System.out.println(courses.toString());
                cnt++;
            }
            if(cnt == 0){
                System.out.println("No courses found with discipline " + input);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        insert();
        while(true){
            System.out.println("You are teacher or student?");
            System.out.println("1: Student");
            System.out.println("2: Teacher");
            int answer;
            answer = scanner.nextInt();
            if(answer == 1){
                System.out.println("1: Search courses");
                System.out.println("2: Request a course");
                answer = scanner.nextInt();

                //Searching for course
                if (answer == 1){
                    System.out.println("1: Search by title");
                    System.out.println("2: Search by discipline");
                    answer = scanner.nextInt();

                    //search by title
                    if (answer == 1){
                        System.out.println("Searching by title");
                        System.out.println("Please enter title");
                        String s;
                        s = scanner.next();

                        getCoursesByTitle(s);

                    }
                    //search by discipline
                    else if (answer == 2){
                        System.out.println("Searching by discipline");
                        System.out.println("Please choose discipline");
                        String s;
                        s = scanner.next();
                        getCourseByDiscipline(s);
                    }}

                //Requesting a course
                else if (answer == 2){
                    int id =1;
                    System.out.println("Requesting a new course");
                    System.out.println("Enter title of the course:");
                    String title = scanner.next();

                    System.out.println("Enter description of the course: ");
                    String description = scanner.next();

                    System.out.println("Enter which disciple is this course: ");
                    String discipline = scanner.next();

                    coursesRequestList.add(new Courses(id, title , description, discipline));
                    id++;
                }
            }
            //TEACHER
            else if (answer == 2){
                System.out.println("1: Add course");
                System.out.println("2: Student's requests");


            }
            else {
                System.out.println("Please enter '1' or '2' ");
            }

        }
    }
}
