import java.util.ArrayList;

/**
 * Represents a student with a name, ID, class year, and a list of courses.
 */
public class Student {

    /** The student's name */
    private final String name; 

    /** The student's ID */
    private final String id; 

    /** The student's class year */
    private final int classYear; 

    /** List of courses the student is enrolled in */
    private final ArrayList<Course> classes; 

    /**
     * Constructs a new Student with the given name, ID, and class year.
     *
     * @param name      the student's name
     * @param id        the student's ID
     * @param classYear the student's class year
     */
    public Student(String name, String id, int classYear) {
        this.name = name;
        this.id = id;
        this.classYear = classYear;
        this.classes = new ArrayList<>(); 
    }

    /**
     * Returns the name of the student.
     *
     * @return student's name
     */
    public String getName() {
        return this.name; 
    }

    /**
     * Returns a string representation of the student including name, ID, and class year.
     *
     * @return formatted string of student info
     */
    @Override
    public String toString() {
        return this.name + " ID: " + this.id + " Class Year: " + this.classYear;
    }

    /**
     * Example main method to test the Student class.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Student ab = new Student("Ab", "9909abc", 2014);
        System.out.println(ab);
        Course csc120 = new Course("OOP", "CSC120", "TR 10:50");
        ab.classes.add(csc120);
        System.out.println(ab.classes);
    }
}