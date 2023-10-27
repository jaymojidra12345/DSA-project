import java.util.Scanner;

public class DS_Project {
    class Node {
        Student data;
        Node next;
        Node previous;

        public Node(Student data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    Node first = null;

    public static void main(String[] args) {
        DS_Project obj = new DS_Project();
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                  WELCOME TO THE STUDENT MANAGEMENT SYSTEM                     ");
        System.out.println("                          DATA STRUCTURES PROJECT                              ");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();

        int choice;
        do {
            System.out.println("Press 1 to add the details of the Student :");
            System.out.println("Press 2 for delete the data of the Student :");
            System.out.println("Press 3 for Update the data of the Student :");
            System.out.println("Press 4 for Display all the data of the Students :");
            System.out.println("Press 5 for search the data of the Student by roll :");
            System.out.println("Press 6 for display the data of all the Students entered by course :");
            System.out.println("Press 7 for exit :");
            System.out.println();

            System.out.println("Enter your choice :");
            choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println("Enter the roll of the Student :");
                    int roll = sc.nextInt();
                    System.out.println();

                    System.out.println("Enter the name of the Student :");
                    String name = sc.next();
                    System.out.println();

                    System.out.println("Enter the course of the name :");
                    String course = sc.next();
                    System.out.println();

                    System.out.println("Enter the email of the Student :");
                    String email = sc.next();
                    System.out.println();

                    Student S_obj1 = new Student(roll, name, course, email);
                    obj.add_Student(S_obj1);

                    System.out.println("Insertion of the Student details successfully done.");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Enter the roll of the Student you want to delete :");
                    int delete_roll = sc.nextInt();
                    System.out.println();

                    obj.delete_Student(delete_roll);
                    break;

                case 3:
                    System.out.println();
                    System.out.println("Enter the roll of the Student in which you want to update the data :");
                    int update_roll = sc.nextInt();
                    System.out.println();

                    obj.update_Student(update_roll);
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Displaying all the student's details :");
                    obj.showStudentDetails();
                    break;

                case 5:
                    System.out.println("Enter the roll of the Student you want to search :");
                    int search_roll = sc.nextInt();
                    System.out.println();

                    obj.search_Student(search_roll);
                    break;

                case 6:
                    System.out.println("Enter the course by which you want to display the data of the Student :");
                    String display_course = sc.next();
                    System.out.println();

                    obj.showStudentDetailsByCouse(display_course);
                    break;

                case 7:
                    System.out.println("You exited out of the System.");
                    System.out.println("THANK YOU.");
                    System.out.println();
                    break;

                default:
                    System.out.println("Enter valid choice :");
                    break;

            }
        } while (choice != 7);
    }

    public void add_Student(Student data) {
        Node newNode = new Node(data);
        Node temp = first;

        if (first == null)
            first = newNode;

        else {
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
            newNode.previous = temp;
        }
    }

    public void delete_Student(int roll) {
        Node temp = first;
        Node temp2 = first;
        int check = 0;

        if (first == null) {
            System.out.println("There are no any student data is available in the system database for deletion.");
            System.out.println();
        } else {
            do {
                if (temp.data.roll == roll)
                    check++;

                temp = temp.next;
            } while (temp != null);

            if (check == 0) {
                System.out.println("No such Student found in the Databse.");
                System.out.println();
            } else {
                if (first.data.roll == roll) {
                    if (first.next == null)
                        first = null;
                    else {
                        first = first.next;
                        first.previous.next = null;
                        first.previous = null;
                    }
                } else {
                    while (temp2.next.data.roll != roll)
                        temp2 = temp2.next;

                    if (temp2.next.next == null) {
                        Node temp4 = temp2.next;
                        temp2.next = null;
                        temp4.previous = null;
                    } else {
                        Node temp3 = temp2.next;
                        temp2.next = temp3.next;
                        temp3.next.previous = temp2;
                        temp3.next = null;
                        temp3.previous = null;
                    }
                }
                System.out.println("Deletion done.");
                System.out.println();
            }
        }
    }

    public void update_Student(int update_roll) {
        Scanner sc = new Scanner(System.in);
        Node temp = first;
        Node temp2 = first;
        int check = 0;

        if (first == null) {
            System.out.println("There are no any student data is available in the system database for deletion.");
            System.out.println();
        } else {
            do {
                if (temp.data.roll == update_roll)
                    check++;

                temp = temp.next;
            } while (temp != null);

            if (check == 0) {
                System.out.println("No such Student found in the Databse.");
                System.out.println();
            } else {

                System.out.println("You can only change the name and the email :");
                System.out.println();

                System.out.println("Enter new Name: ");
                String update_name = sc.next();
                System.out.println();

                System.out.println("Enter new email :");
                String update_email = sc.next();
                System.out.println();

                if (first.data.roll == update_roll) {
                    first.data.name = update_name;
                    first.data.email = update_email;
                } else {
                    while (temp2.data.roll != update_roll)
                        temp2 = temp2.next;

                    temp2.data.name = update_name;
                    temp2.data.email = update_email;
                }
                System.out.println("Updation done");
                System.out.println();
            }
        }
    }

    public void showStudentDetails() {
        if (first == null) {
            System.out.println("No any Student data is available to display.");
            System.out.println();
        } else {
            Node temp = first;
            do {
                System.out.println();
                System.out.println("Roll :" + temp.data.roll);
                System.out.println("Name :" + temp.data.name);
                System.out.println("Course :" + temp.data.course);
                System.out.println("Email :" + temp.data.email);
                System.out.println();
                temp = temp.next;
            } while (temp != null);
        }
    }

    public void search_Student(int roll) {
        Node temp = first;
        Node temp2 = first;
        int count = 0;
        if (first == null)
            System.out.println("There are no any student data is available in the system database for searching.");
        else {
            do {
                if (temp.data.roll == roll)
                    count++;

                temp = temp.next;
            } while (temp != null);

            if (count == 0) {
                System.out.println("No such Student found in the Databse.");
                System.out.println();
            } else {
                while (temp2.data.roll != roll)
                    temp2 = temp2.next;

                System.out.println();
                System.out.println("Roll :" + temp2.data.roll);
                System.out.println("Name :" + temp2.data.name);
                System.out.println("Course :" + temp2.data.course);
                System.out.println("Email :" + temp2.data.email);
                System.out.println();
            }
        }
    }

    public void showStudentDetailsByCouse(String display_course) {
        if (first == null) {
            System.out.println("No any Student data is available to display.");
            System.out.println();
        } else {
            Node temp = first;
            do {
                if ((display_course).equalsIgnoreCase(temp.data.course)) {
                    System.out.println();
                    System.out.println("Roll :" + temp.data.roll);
                    System.out.println("Name :" + temp.data.name);
                    System.out.println("Course :" + temp.data.course);
                    System.out.println("Email :" + temp.data.email);
                    System.out.println();
                }
                temp = temp.next;
            } while (temp != null);
        }
    }
}

class Student {
    int roll;
    String name;
    String course;
    String email;

    public Student(int roll, String name, String course, String email) {
        this.roll = roll;
        this.name = name;
        this.course = course;
        this.email = email;
    }
}