import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent() {
        enrolledStudents++;
    }

    public void dropStudent() {
        enrolledStudents--;
    }

    public boolean hasAvailableSlots() {
        return enrolledStudents < capacity;
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.hasAvailableSlots()) {
            registeredCourses.add(course);
            course.enrollStudent();
            System.out.println("Course " + course.getCourseCode() + " enrolled successfully for " + name);
        } else {
            System.out.println("Course " + course.getCourseCode() + " is full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.dropStudent();
            System.out.println("Course " + course.getCourseCode() + " dropped successfully for " + name);
        } else {
            System.out.println("You are not registered for course " + course.getCourseCode());
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        List<Course> courses = initializeCourses();
        List<Student> students = initializeStudents();

        displayCourses(courses);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter student ID to perform registration/drop (or -1 to exit): ");
            int studentID = scanner.nextInt();

            if (studentID == -1) {
                break;
            }

            Student currentStudent = findStudentById(students, studentID);
            if (currentStudent == null) {
                System.out.println("Student not found.");
                continue;
            }

            displayCourses(courses);

            System.out.println("Enter course code to register/drop (or '0' to go back): ");
            scanner.nextLine(); // Consume the newline
            String courseCode = scanner.nextLine();

            if (courseCode.equals("0")) {
                continue;
            }

            Course selectedCourse = findCourseByCode(courses, courseCode);
            if (selectedCourse == null) {
                System.out.println("Course not found.");
                continue;
            }

            if (currentStudent.getRegisteredCourses().contains(selectedCourse)) {
                currentStudent.dropCourse(selectedCourse);
            } else {
                currentStudent.registerCourse(selectedCourse);
            }
        }
    }

    private static List<Course> initializeCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CS101", "Introduction to Programming", "Basic programming concepts", 20));
        courses.add(new Course("MATH202", "Calculus II", "Advanced calculus topics", 25));
        courses.add(new Course("ENG301", "Advanced English Writing", "Essay writing and composition", 25));
        courses.add(new Course("PHY404", "Physics", "About dynamic theory", 20));
        courses.add(new Course("CHE501", "Chemistry", "Descriptive inorganic chemistry", 20));
        courses.add(new Course("IOT602", "Internet of Things", "Use of AI sensors in real life", 10));
        courses.add(new Course("CPP002", "C++ Programming", "Object and class concepts", 20));
        courses.add(new Course("JP307", "Java Programming", "Using of OOPs concept with Java", 15));
        courses.add(new Course("PP008", "Python", "Using python and create code", 15));
        courses.add(new Course("DMS302", "Database Management System", "Advanced data filtering using different technologies", 10));
        return courses;
    }

    private static List<Student> initializeStudents() {
        List<Student> students = new ArrayList<>();
        // This student database is assumed
        students.add(new Student(1001, "Anita"));
        students.add(new Student(1002, "Ajay"));
        students.add(new Student(1003, "Bulbul"));
        students.add(new Student(1004, "Brijesh"));
        students.add(new Student(1005, "Chandni"));
        students.add(new Student(1006, "Chandradeep"));
        students.add(new Student(1007, "Deepash"));
        students.add(new Student(1008, "Dilip"));
        students.add(new Student(1009, "Deepak"));
        students.add(new Student(1010, "Dheeraj"));
        students.add(new Student(1011, "Dharmaram"));
        students.add(new Student(1012, "Daksh"));
        students.add(new Student(1013, "Dikshit"));
        students.add(new Student(1014, "Divyanshu"));
        students.add(new Student(1015, "Deepika"));
        students.add(new Student(1016, "Dinesh"));
        students.add(new Student(1017, "Endrapal"));
        students.add(new Student(1018, "Fardeen"));
        students.add(new Student(1019, "Fahrook"));
        students.add(new Student(1020, "Fijja"));
        students.add(new Student(1021, "Garima"));
        students.add(new Student(1022, "Ganesh"));
        students.add(new Student(1023, "Gajendra"));
        students.add(new Student(1024, "Gagan"));
        students.add(new Student(1025, "Geeta"));
        students.add(new Student(1026, "Gajju"));
        students.add(new Student(1027, "Harshita"));
        students.add(new Student(1028, "Hamid"));
        students.add(new Student(1029, "Hemlata"));
        students.add(new Student(1030, "Honey"));
        students.add(new Student(1031, "Indra"));
        students.add(new Student(1032, "Indhu"));
        students.add(new Student(1033, "Jatin"));
        students.add(new Student(1034, "Jyoti"));
        students.add(new Student(1035, "Jagdish"));
        students.add(new Student(1036, "Jagatpal"));
        students.add(new Student(1037, "Jeetu"));
        students.add(new Student(1038, "Jaswant"));
        students.add(new Student(1039, "Jitendra"));
        students.add(new Student(1040, "Janvi"));
        students.add(new Student(1041, "Jasmin"));
        students.add(new Student(1042, "Jigyashu"));
        students.add(new Student(1043, "Kamal"));
        students.add(new Student(1044, "Komal"));
        students.add(new Student(1045, "Kajol"));
        students.add(new Student(1046, "Kismat"));
        students.add(new Student(1047, "Kavita"));
        students.add(new Student(1048, "Kapil"));
        students.add(new Student(1049, "Kailash"));
        students.add(new Student(1050, "Kalyani"));
        students.add(new Student(1051, "Khushi"));
        students.add(new Student(1052, "Krishan"));
        students.add(new Student(1053, "Krishna"));
        students.add(new Student(1054, "Lokesh"));
        students.add(new Student(1055, "Lovely"));
        students.add(new Student(1056, "Lalita"));
        students.add(new Student(1057, "Lucky"));
        students.add(new Student(1058, "Mukesh"));
        students.add(new Student(1059, "Mahendra"));
        students.add(new Student(1060, "Manoj"));
        students.add(new Student(1061, "Mamta"));
        students.add(new Student(1062, "Muskan"));
        students.add(new Student(1063, "Mamta"));
        students.add(new Student(1064, "Manisha"));
        students.add(new Student(1065, "Manan"));
        students.add(new Student(1066, "Manish"));
        students.add(new Student(1067, "Manushya"));
        students.add(new Student(1068, "Manjeet"));
        students.add(new Student(1069, "Mahima"));
        students.add(new Student(1070, "Mahi"));
        students.add(new Student(1071, "Monika"));
        students.add(new Student(1072, "Megha"));
        students.add(new Student(1073, "Mono"));
        students.add(new Student(1074, "Mrityunjay"));
        students.add(new Student(1075, "Narendra"));
        students.add(new Student(1076, "Naresh"));
        students.add(new Student(1077, "Nandhini"));
        students.add(new Student(1078, "Nisha"));
        students.add(new Student(1079, "Neeraj"));
        students.add(new Student(1080, "Nadeem"));
        students.add(new Student(1081, "Nadeesh"));
        students.add(new Student(1082, "Nidhi"));
        students.add(new Student(1083, "Omprakash"));
        students.add(new Student(1084, "Pradeeo"));
        students.add(new Student(1085, "Pankaj"));
        students.add(new Student(1086, "Pravesh"));
        students.add(new Student(1087, "Prateek"));
        students.add(new Student(1088, "Priti"));
        students.add(new Student(1089, "Pooja"));
        students.add(new Student(1090, "Poonam"));
        students.add(new Student(1091, "Piyu"));
        students.add(new Student(1092, "Prameela"));
        students.add(new Student(1093, "Priyanka"));
        students.add(new Student(1094, "Priyanshi"));
        students.add(new Student(1095, "Pinki"));
        students.add(new Student(1096, "Palak"));
        students.add(new Student(1097, "Payal"));                        
        students.add(new Student(1098, "Preetam"));
        students.add(new Student(1099, "Prince"));
        students.add(new Student(1100, "Ritu"));
        
        return students;
    }

    private static void displayCourses(List<Course> courses) {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode() +
                    " | Title: " + course.getTitle() +
                    " | Description: " + course.getDescription() +
                    " | Capacity: " + course.getCapacity() +
                    " | Enrolled Students: " + course.getEnrolledStudents());
        }
    }

    private static Student findStudentById(List<Student> students, int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseByCode(List<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
