import java.util.ArrayList;

/**
 * A House is a type of Building that can have student residents
 * and possible a dining room.
 */
public class House extends Building implements HouseRequirements {

    private final ArrayList<Student> residents;
    private final boolean hasDiningRoom;

    /**
     * Construct a new House.
     *
     * @param name Name of the house
     * @param address Address of the house
     * @param nFloors Number of floors
     * @param hasDiningRoom Whether the house has a dining room
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        this.residents = new ArrayList<>();
        this.hasDiningRoom = hasDiningRoom;
    }

    /** @return whether the house has a dining room */
    @Override
    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    /** @return number of students currently living in the house */
    @Override
    public int nResidents() {
        return this.residents.size();
    }

    /**
     * Moves a student into the house.
     *
     * @param s Student to move in
     */
    @Override
    public void moveIn(Student s) {
        if (isResident(s)) {
            throw new IllegalStateException("Student already resides in the house: " + s.getName());
        }
        this.residents.add(s);
    }

    /**
     * Moves a student out of the house.
     *
     * @param s Student to move out
     * @return the student removed
     */
    @Override
    public Student moveOut(Student s) {
        if (!isResident(s)) {
            throw new IllegalArgumentException("Cannot move out non-resident: " + s.getName());
        }
        this.residents.remove(s);
        return s;
    }

    /**
     * Checks if a student is a resident
     *
     * @param s Student to check
     * @return true if the student lives in the house
     */
    @Override
    public boolean isResident(Student s) {
        return this.residents.contains(s);
    }

    
}