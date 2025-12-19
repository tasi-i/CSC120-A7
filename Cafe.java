/**
 * A Cafe is a type of Building that sells coffee.
 * It keeps track of inventory such as coffee, sugar, cream, and cups.
 */
public class Cafe extends Building implements CafeRequirements {

    /** Number of ounces of coffee remaining */
    private int nCoffeeOunces;

    /** Number of sugar packets remaining */
    private int nSugarPackets;

    /** Number of cream remaining */
    private int nCreams;

    /** Number of cups remaining */
    private int nCups;

    /**
     * Constructs a new Cafe with an initial inventory.
     *
     * @param name            the name of the cafe
     * @param address         the address of the cafe
     * @param nFloors         number of floors in the building
     * @param nCoffeeOunces   starting ounces of coffee
     * @param nSugarPackets   starting sugar packets
     * @param nCreams         starting cream splashes
     * @param nCups           starting number of cups
     */
    public Cafe(String name, String address, int nFloors,
                int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Sells a cup of coffee and updates inventory
     * If there is not enough inventory, the cafe restocks before selling.
     *
     * @param size          number of ounces of coffee used
     * @param sugarPackets number of sugar packets used
     * @param creams        number of cream splashes used
     */
    @Override
    public void sellCoffee(int size, int sugarPackets, int creams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < sugarPackets ||
            this.nCreams < creams || this.nCups < 1) {
            restock(50, 50, 50, 25);
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= sugarPackets;
        this.nCreams -= creams;
        this.nCups -= 1;

        System.out.println("Sold coffee: " + size + "oz, " +
                sugarPackets + " sugar, " + creams + " cream.");
        System.out.println("Remaining inventory - Coffee: " + this.nCoffeeOunces +
                ", Sugar: " + this.nSugarPackets +
                ", Cream: " + this.nCreams +
                ", Cups: " + this.nCups);
    }

    /**
     * Restocks the cafe inventory.
     * This method is private because restocking should only
     * occur internally when inventory is low.
     *
     * @param coffeeOunces ounces of coffee to add
     * @param sugarPackets sugar packets to add
     * @param creams       cream splashes to add
     * @param cups         cups to add
     */
    private void restock(int coffeeOunces, int sugarPackets, int creams, int cups) {
        this.nCoffeeOunces += coffeeOunces;
        this.nSugarPackets += sugarPackets;
        this.nCreams += creams;
        this.nCups += cups;
        System.out.println("Restocked inventory!");
    }

    /**
     * Prints basic information about the cafe.
     */
    public void printCafeInfo() {
        System.out.println(this.getName() + " is a " + this.getFloors() +
                "-story cafe located at " + this.getAddress());
    }

    /**
     * Test method for the Cafe class.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Campus Cafe", "123 College Rd", 1, 30, 10, 5, 2);
        myCafe.printCafeInfo();
        myCafe.sellCoffee(12, 2, 1);
        myCafe.sellCoffee(10, 3, 2); // may trigger restock
    }
}