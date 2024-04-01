import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
      static String line ="-------------------------------------------------------------------------------";
      static Scanner scanner=new Scanner(System.in);
    private static String[] studentIds = new String[100]; // Assuming a maximum of 100 students
    private static String[] studentNames = new String[100];
    private static  int[]programmingMarksArray =new int[100];
    private static int[] databaseMarksArray= new int[100];

    private static int studentCount = 0;


    public static void main(String[] args) {


        Menu();

    }

    private static void Menu() {
        System.out.println(line);
        System.out.println("|                WELCOME TO MARKS MANAGEMENT SYSTEM                      |");
        System.out.println(line);
        System.out.println("[1] Add New Student                      [2] Add New Student With Marks");
        System.out.println("[3] Add Marks                            [4] Update Student Details");
        System.out.println("[5] Update Marks                         [6] Delete Student");
        System.out.println("[7] Print Student Details                [8] Print Student Marks");
        System.out.println("[9] Best in Programming Fundamentals     [10] Best in database management System");
        System.out.println();

        System.out.print("Enter an option to continue >");
        int choice=scanner.nextInt();
        switch (choice) {
            case 1:
                addNewStudent();
                break;
            case 2:
                addNewStudentWithMarks();
                break;
            case 3:
                addMarks();
                break;
            case 4:
                updateStudentDetails();
                break;
            case 5:
               updateMarks();
                break;
            case 6:
                deleteStudent();
                break;
            case 7:
                printStudentDetails();
                break;
            case 8:
                printStudentMarks();
                break;
            case 9:
                bestInProgrammingFundamentals();
                break;
            case 10:
                bestInDatabaseManagementSystem();
                break;
            case 0:
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number from 0 to 10.");
        }
    }



    private static void addNewStudent() {

        System.out.println(line);
        System.out.println("|                              ADD NEW STUDENT                                |");
        System.out.println(line);


        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student ID :");
        String id = scanner.nextLine();
        while (isDuplicateId(id)) {
            System.out.print("Student ID already exists. Please enter a different Student ID:");
            id = scanner.nextLine();
        }

        System.out.print("Enter Student Name :");
        String name = scanner.nextLine();

        studentIds[studentCount] = id;
        studentNames[studentCount] = name;
        studentCount++;

        System.out.println("Student added successfully!");

        System.out.print("Do you want to add another student? (y/n) :");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("y")) {
            addNewStudent();
        }
        else {
            Menu();
        }
    }
    private static boolean isDuplicateId(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (studentIds[i] != null && studentIds[i].equals(id)) {
                return true;
            }
        }
        return false;
    }
    private static void addNewStudentWithMarks() {

        System.out.println(line);
        System.out.println("|                              ADD NEW STUDENT WITH MARKS                     |");
        System.out.println(line);


        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student ID :");
        String id = scanner.nextLine();
        while (isDuplicateId(id)) {
            System.out.print("Student ID already exists. Please enter a different Student ID :");
            id = scanner.nextLine();
        }

        System.out.print("Enter Student Name :");
        String name = scanner.nextLine();

        System.out.print("Enter Programming Fundamentals Marks :");
        int programmingMarks = scanner.nextInt();
        while (programmingMarks < 0 || programmingMarks > 100) {
            System.out.println("Invalid marks. Marks should be within the range of 0-100. Please enter valid marks:");
            programmingMarks = scanner.nextInt();
        }

        System.out.print("Enter Database Management Marks :");
        int databaseMarks = scanner.nextInt();
        while (databaseMarks < 0 || databaseMarks > 100) {
            System.out.println("Invalid marks. Marks should be within the range of 0-100. Please enter valid marks:");
            databaseMarks = scanner.nextInt();
        }

        studentIds[studentCount] = id;
        studentNames[studentCount] = name;
        programmingMarksArray[studentCount]=programmingMarks;
        databaseMarksArray[studentCount] = databaseMarks;
        studentCount++;

        System.out.println("Student added successfully!");

        System.out.println("Do you want to add another student with marks? (y/n)");
        scanner.nextLine(); // Consume newline
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("y")) {
            addNewStudentWithMarks();
        }
        else {
            Menu();
        }
    }
    private static void addMarks() {

        System.out.println(line);
        System.out.println("|                                  ADD MARKS                                  |");
        System.out.println(line);

        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student ID :");
        String id = scanner.nextLine();
        int studentIndex = findStudentIndexById(id);
        if (studentIndex == -1) {
            System.out.println("Student not found!");
            return;
        }

        if (programmingMarksArray[studentIndex] != 0 || databaseMarksArray[studentIndex] != 0) {
            System.out.println("Marks for this student have already been assigned.");
            return;
        }

        System.out.println("Student Name: " + studentNames[studentIndex]);

        System.out.print("Enter Programming Fundamentals Marks :");
        int programmingMarks = scanner.nextInt();
        while (programmingMarks < 0 || programmingMarks > 100) {
            System.out.println("Invalid marks. Marks should be within the range of 0-100. Please enter valid marks:");
            programmingMarks = scanner.nextInt();
        }

        System.out.print("Enter Database Management Marks :");
        int databaseMarks = scanner.nextInt();
        while (databaseMarks < 0 || databaseMarks > 100) {
            System.out.println("Invalid marks. Marks should be within the range of 0-100. Please enter valid marks:");
            databaseMarks = scanner.nextInt();
        }

        programmingMarksArray[studentIndex] = programmingMarks;
        databaseMarksArray[studentIndex] = databaseMarks;

        System.out.println("Marks added successfully!");

        System.out.println("Do you want to add marks for another student? (yes/no)");
        scanner.nextLine(); // Consume newline
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("yes")) {
            addMarks();
        }
        else {
            Menu();
        }
    }
    private static void updateStudentDetails() {

        System.out.println(line);
        System.out.println("|                               UPDATE STUDENT DETAILS                         |");
        System.out.println(line);


        scanner.nextLine(); // Consume newline
        System.out.println("Enter Student ID:");
        String id = scanner.nextLine();
        int studentIndex = findStudentIndexById(id);
        if (studentIndex == -1) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Current Student Name: " + studentNames[studentIndex]);
        System.out.println("Enter New Student Name:");
        String newName = scanner.nextLine();

        // Update student name
        studentNames[studentIndex] = newName;

        System.out.println("Student details updated successfully!");

        System.out.println("Do you want to update details for another student? (yes/no)");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("yes")) {
            updateStudentDetails();
        }
        else {
            Menu();
        }
    }
    private static void updateMarks() {

        System.out.println(line);
        System.out.println("|                                UPDATE MARKS                                 |");
        System.out.println(line);

        scanner.nextLine(); // Consume newline
        System.out.println("Enter Student ID:");
        String id = scanner.nextLine();
        int studentIndex = findStudentIndexById(id);
        if (studentIndex == -1) {
            System.out.println("Student not found!");
            return;
        }

        if (programmingMarksArray[studentIndex] == 0 && databaseMarksArray[studentIndex] == 0) {
            System.out.println("Marks for this student haven't been added yet.");
            return;
        }

        System.out.println("Student Name: " + studentNames[studentIndex]);
        System.out.println("Current Programming Fundamentals Marks: " + programmingMarksArray[studentIndex]);
        System.out.println("Current Database Management Marks: " + databaseMarksArray[studentIndex]);

        System.out.println("Enter New Programming Fundamentals Marks (0-100):");
        int newProgrammingMarks = scanner.nextInt();
        while (newProgrammingMarks < 0 || newProgrammingMarks > 100) {
            System.out.println("Invalid marks. Marks should be within the range of 0-100. Please enter valid marks:");
            newProgrammingMarks = scanner.nextInt();
        }

        System.out.println("Enter New Database Management Marks (0-100):");
        int newDatabaseMarks = scanner.nextInt();
        while (newDatabaseMarks < 0 || newDatabaseMarks > 100) {
            System.out.println("Invalid marks. Marks should be within the range of 0-100. Please enter valid marks:");
            newDatabaseMarks = scanner.nextInt();
        }

        programmingMarksArray[studentIndex] = newProgrammingMarks;
        databaseMarksArray[studentIndex] = newDatabaseMarks;

        System.out.println("Marks updated successfully!");

        System.out.println("Do you want to update marks for another student? (yes/no)");
        scanner.nextLine(); // Consume newline
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("yes")) {
            updateMarks();
        }
        else {
            Menu();
        }
    }
    private static void deleteStudent() {

        System.out.println(line);
        System.out.println("|                               DELETE STUDENT                                 |");
        System.out.println(line);


        scanner.nextLine(); // Consume newline
        System.out.println("Enter Student ID:");
        String id = scanner.nextLine();
        int studentIndex = findStudentIndexById(id);
        if (studentIndex == -1) {
            System.out.println("Student not found!");
            return;
        }

        // Shift all elements to the left to remove the student
        for (int i = studentIndex; i < studentCount - 1; i++) {
            studentIds[i] = studentIds[i + 1];
            studentNames[i] = studentNames[i + 1];
            programmingMarksArray[i] = programmingMarksArray[i + 1];
            databaseMarksArray[i] = databaseMarksArray[i + 1];
        }

        // Set the last element to null to clear it
        studentIds[studentCount - 1] = null;
        studentNames[studentCount - 1] = null;
        programmingMarksArray[studentCount - 1] = 0;
        databaseMarksArray[studentCount - 1] = 0;

        studentCount--;

        System.out.println("Student deleted successfully!");

        System.out.println("Do you want to delete another student? (yes/no)");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("yes")) {
            deleteStudent();
        }
        else {
            Menu();
        }
    }



    private static void printStudentDetails() {

        System.out.println(line);
        System.out.println("|                               PRINT STUDENT DETAILS                          |");
        System.out.println(line);


        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student ID :");
        String id = scanner.nextLine();
        int studentIndex = findStudentIndexById(id);
        if (studentIndex == -1) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Student ID: " + studentIds[studentIndex]);
        System.out.println("Student Name: " + studentNames[studentIndex]);

        if (programmingMarksArray[studentIndex] == 0 && databaseMarksArray[studentIndex] == 0) {
            System.out.println("Student marks haven't been added yet.");
        } else {
            int programmingMarks = programmingMarksArray[studentIndex];
            int databaseMarks = databaseMarksArray[studentIndex];
            int totalMarks = programmingMarks + databaseMarks;
            double averageMarks = totalMarks / 2.0;

            System.out.println("Programming Fundamentals Marks: " + programmingMarks);
            System.out.println("Database Management Marks: " + databaseMarks);
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Marks: " + averageMarks);

            // Calculate rank
            int rank = calculateRank(studentIndex, totalMarks);
            System.out.print("Rank: " + rank);
            printRankText(rank);

        }

        System.out.println("Do you want to view details of another student? (y/n) ?");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("y")) {
            printStudentDetails();
        }
        else {
            Menu();
        }
    }
    private static void printStudentMarks() {

        System.out.println(line);
        System.out.println("|                               PRINT STUDENT DETAILS                          |");
        System.out.println(line);

        System.out.println("Student Ranks:");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Student ID\tStudent Name\tTotal Marks\tAverage Marks\tRank");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < studentCount; i++) {
            if (programmingMarksArray[i] != 0 || databaseMarksArray[i] != 0) {
                int totalMarks = programmingMarksArray[i] + databaseMarksArray[i];
                double averageMarks = totalMarks / 2.0;
                int rank = calculateRank(i, totalMarks);

                System.out.printf("%-15s\t%-12s\t%-10d\t%-13.2f\t%-4d", studentIds[i], studentNames[i], totalMarks, averageMarks, rank);
                printRankText(rank);
                System.out.println();
            }
        }
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("Do you want to stay in the print student ranks section? (yes/no)");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("yes")) {
            printStudentMarks();
        }
        else {
            Menu();
        }
    }
    private static void bestInProgrammingFundamentals() {

        System.out.println(line);
        System.out.println("|                       BEST IN PROGRAMMING FUNDAMENTALS                       |");
        System.out.println(line);


        int bestProgrammingMarks = -1;
        int countBestStudents = 0;
        int[] bestStudentsIndices = new int[studentCount];

        // Find the highest programming marks
        for (int i = 0; i < studentCount; i++) {
            if (programmingMarksArray[i] != 0 && programmingMarksArray[i] > bestProgrammingMarks) {
                bestProgrammingMarks = programmingMarksArray[i];
            }
        }

        // Find students with the highest programming marks
        for (int i = 0; i < studentCount; i++) {
            if (programmingMarksArray[i] == bestProgrammingMarks) {
                bestStudentsIndices[countBestStudents++] = i;
            }
        }

        if (countBestStudents == 0) {
            System.out.println("No student has marks in Programming Fundamentals yet.");
        } else {
            System.out.println("Best in Programming Fundamentals:");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Student ID\tStudent Name\tProgramming Fundamentals Marks");
            System.out.println("-------------------------------------------------------------------------");
            for (int i = 0; i < countBestStudents; i++) {
                int index = bestStudentsIndices[i];
                System.out.printf("%-15s\t%-12s\t%d\n", studentIds[index], studentNames[index], programmingMarksArray[index]);
            }
            System.out.println("-------------------------------------------------------------------------");
        }

        System.out.println("Do you want to stay in the Best in Programming Fundamentals section? (yes/no)");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("yes")) {
            bestInProgrammingFundamentals();
        }
        else {
            Menu();
        }
    }
    private static void bestInDatabaseManagementSystem() {

        System.out.println(line);
        System.out.println("|                        BEST IN DATABASE MANAGEMENT SYSTEMS                   |");
        System.out.println(line);



        int bestDatabaseMarks = -1;
        int countBestStudents = 0;
        int[] bestStudentsIndices = new int[studentCount];

        // Find the highest database management marks
        for (int i = 0; i < studentCount; i++) {
            if (databaseMarksArray[i] != 0 && databaseMarksArray[i] > bestDatabaseMarks) {
                bestDatabaseMarks = databaseMarksArray[i];
            }
        }

        // Find students with the highest database management marks
        for (int i = 0; i < studentCount; i++) {
            if (databaseMarksArray[i] == bestDatabaseMarks) {
                bestStudentsIndices[countBestStudents++] = i;
            }
        }

        if (countBestStudents == 0) {
            System.out.println("No student has marks in Database Management System yet.");
        } else {
            System.out.println("Best in Database Management System:");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Student ID\tStudent Name\tDatabase Management Marks");
            System.out.println("-------------------------------------------------------------------------");
            for (int i = 0; i < countBestStudents; i++) {
                int index = bestStudentsIndices[i];
                System.out.printf("%-15s\t%-12s\t%d\n", studentIds[index], studentNames[index], databaseMarksArray[index]);
            }
            System.out.println("-------------------------------------------------------------------------");
        }

        System.out.println("Do you want to stay in the Best in Database Management System section? (yes/no)");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("yes")) {
            bestInDatabaseManagementSystem();
        }
        else {
            Menu();
        }
    }
    private static int findStudentIndexById(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (studentIds[i].equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private static int calculateRank(int studentIndex, int totalMarks) {
        int rank = 1;
        for (int i = 0; i < studentCount; i++) {
            if (i != studentIndex && (programmingMarksArray[i] + databaseMarksArray[i]) > totalMarks) {
                rank++;
            }
        }
        return rank;
    }

    private static void printRankText(int rank) {
        switch (rank) {
            case 1:
                System.out.print(" (First)");
                break;
            case 2:
                System.out.print(" (Second)");
                break;
            case 3:
                System.out.print(" (Third)");
                break;
            default:
                break;
        }
    }



    

}

    
