/**
 * Represents a generic building.
 * Implements the BuildingRequirements interface which defines basic
 * building properties such as name, address, and number of floors.
 */
public class Building implements BuildingRequirements {

    /** Name of the building */
    protected String name = "<Name Unknown>";

    /** Address of the building */
    protected String address = "<Address Unknown>";

    /** Number of floors in the building */
    protected int nFloors = 1;

    /**
     * Constructs a new Building with the given name, address, and number of floors.
     *
     * @param name    The name of the building
     * @param address The address of the building
     * @param nFloors The number of floors; must be >= 1
     * @throws RuntimeException if nFloors < 1
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) this.name = name;
        if (address != null) this.address = address;
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Returns the name of the building.
     *
     * @return building name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the address of the building.
     *
     * @return building address
     */
    @Override
    public String getAddress() {
        return this.address;
    }

    /**
     * Returns the number of floors in the building.
     *
     * @return number of floors
     */
    @Override
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Returns a string representation of the building.
     *
     * @return a descriptive string with building name, floors, and address
     */
    @Override
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    /**
     * Example main method to test the Building class.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }
}