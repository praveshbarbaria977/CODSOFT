import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Number of Subjects: ");
        int numSubjects = scanner.nextInt();

        double totalMarks = 0;
        // Maximum Marks for Each Subject is 100
        double maxMarksPerSubject = 100; 

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter Marks Obtained in Subject " + i + ": ");
            double subjectMarks = scanner.nextDouble();
            
            if (subjectMarks < 0 || subjectMarks > maxMarksPerSubject) {
                System.out.println("Invalid Marks Entered. Marks should be between 0 and " + maxMarksPerSubject);
                return;
            }
            totalMarks += subjectMarks;
        }

        double average = totalMarks / numSubjects;
        double percentage = (totalMarks / (maxMarksPerSubject * numSubjects)) * 100;

        char grade;
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Total Marks Obtained: " + totalMarks);
        System.out.println("Average Marks: " + average);
        System.out.println("Percentage: " + percentage + " % ");
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}
