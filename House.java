import java.util.ArrayList;

/**
 * A House is a type of Building that can have student residents
 * and optionally a dining room.
 */
public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
  }

  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  public int nResidents() {
    return this.residents.size();
  }

  public void moveIn(Student s) {
    if (!isResident(s))
      this.residents.add(s);
  }

  public Student moveOut(Student s) {
    if (isResident(s)) {
      this.residents.remove(s);
      return s;
    }
    return null;
  }

  public boolean isResident(Student s) {
    return this.residents.contains(s);
  }

  /** Prints full info for this House */
  public void printHouseInfo() {
    System.out.println(this.getName() + " is a " + this.getFloors() + "-story house located at " + this.getAddress());
    System.out.println("Has dining room? " + this.hasDiningRoom());
    System.out.println("Number of residents: " + this.nResidents());
  }

  public static void main(String[] args) {
    House alHouse = new House("Al House", "1 College Rd", 3, true);
    Student s1 = new Student("Boba", "A001", 2025);
    Student s2 = new Student("Lena", "B002", 2024);
    alHouse.moveIn(s1);
    alHouse.moveIn(s2);
    alHouse.printHouseInfo();
  }
}