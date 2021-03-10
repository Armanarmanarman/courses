package model;

import database.DBUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("You are teacher or student?");
            System.out.println("1: Student");
            System.out.println("2: Teacher");
            System.out.println("0: End program");
            int answer;
            answer = scanner.nextInt();
            try {
                if (answer == 1) {
                    System.out.println("1: Search courses");
                    System.out.println("2: Request a course");
                    answer = scanner.nextInt();

                    //Searching for course
                    if (answer == 1) {
                        System.out.println("1: Search by title");
                        System.out.println("2: Search by discipline");
                        System.out.println("3: Show all available courses");
                        answer = scanner.nextInt();

                        try {
                            if (answer == 1)//search by title
                            {
                                System.out.println("Searching by title");
                                System.out.println("Please enter title");
                                String title = "'" + getInput() + "'";//getting input from console
                                DBUtils.getByTitle(new String[]{title});//giving it to geByTitle method located in DBUtils
                            }
                            //search by discipline
                            else if (answer == 2)//search by discipline
                            {
                                System.out.println("Searching by discipline");
                                System.out.println("Please choose discipline");
                                String discipline = "'" + getInput() + "'";//getting input from console
                                DBUtils.getByDiscipline(new String[]{discipline});//giving input to getByTitle method
                            } else if (answer == 3)//show all available courses
                                DBUtils.showAll("courses");//look for showAll method in DBUtils
                        } catch (InputMismatchException e) {
                            System.out.println("Exception " + e);
                        }

                    }

                    //Requesting a course
                    else if (answer == 2) //Request a course by adding course info to array
                    {

                        System.out.println("Requesting a new course");
                        int id = DBUtils.getCurrentId("requested_courses") + 1;
                        System.out.println("Enter course Title:");
                        String title = "'" + getInput() + "'";//get input gets multiple string inputs
                        System.out.println("Enter course Description:");

                        String description = "'" + getInput() + "'"; // ' <= we need to wrap input in this quote so sql can read it
                        System.out.println("Enter the Discipline of the course:");
                        String discipline = "'" + getInput() + "'";
                        DBUtils.insertIntoTable("requested_courses", new String[]{String.valueOf(id), title, description,discipline});
                    }
                }
                //TEACHER
                else if (answer == 2) {
                    System.out.println("1: Add course");
                    System.out.println("2: Student's requests");
                    System.out.println("3: Delete all courses");
                    System.out.println("4: Delete all requested courses");
                    answer = scanner.nextInt();

                    try {
                        if (answer == 1)//add course to DB
                        {
                            int id = DBUtils.getCurrentId("courses") + 1;
                            System.out.println("Enter course Title:");
                            String title = "'" + getInput() + "'";//get input gets multiple string inputs
                            System.out.println("Enter course Description:");

                            String description = "'" + getInput() + "'"; // ' <= we need to wrap input in this quote so sql can read it
                            System.out.println("Enter the Discipline of the course:");
                            String discipline = "'" + getInput() + "'";

                            DBUtils.insertIntoTable("courses", new String[]{//see description on DBUtils class
                                    String.valueOf(id),
                                    title,
                                    description,
                                    discipline});


                        } else if (answer == 2)//show request array if there are any
                        {
                            DBUtils.showAll("requested_courses");
                        } else if (answer == 3)//delete all data from table
                        {
                            DBUtils.deleteTable("courses");

                        } else if(answer == 4){//delete all requested courses
                            DBUtils.deleteTable("requested_courses");
                        }
                        else {
                            System.out.println("Enter numbers '1' or '2' or '3' ");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Exception occured : " + e);
                    }


                } else if(answer == 0){
                    System.exit(0);
                }
                else System.out.println("Please enter proper number");
            } catch (InputMismatchException ex) {
                System.out.println("Exception occurred :" + ex);
            }

        }
    }

    private static String getInput() {//this method is used to get multiple string inputs
        Scanner scanner2 = new Scanner(System.in);
        return scanner2.nextLine();
    }

}
