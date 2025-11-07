/**
 * A Cafe Building that keeps track of coffee inventory.
 */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Construct a new Cafe.
     *
     * @param name          Name of the cafe
     * @param address       Address of the cafe
     * @param nFloors       Number of floors
     * @param nCoffeeOunces Starting ounces of coffee
     * @param nSugarPackets Starting sugar packets
     * @param nCreams       Starting cream splashes
     * @param nCups         Starting cups
     */
    public Cafe(String name, String address, int nFloors,
            int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors); // This calls Building’s constructor
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    public void sellCoffee(int size, int sugarPackets, int creams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < sugarPackets ||
                this.nCreams < creams || this.nCups < 1) {
            restock(50, 50, 50, 25);
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= sugarPackets;
        this.nCreams -= creams;
        this.nCups -= 1;

        System.out.println("Sold coffee: " + size + "oz, " + sugarPackets + " sugar, " + creams + " cream.");
        System.out.println("Remaining inventory - Coffee: " + this.nCoffeeOunces +
                ", Sugar: " + this.nSugarPackets + ", Cream: " + this.nCreams +
                ", Cups: " + this.nCups);
    }

    private void restock(int coffeeOunces, int sugarPackets, int creams, int cups) {
        this.nCoffeeOunces += coffeeOunces;
        this.nSugarPackets += sugarPackets;
        this.nCreams += creams;
        this.nCups += cups;
        System.out.println("Restocked inventory!");
    }

    // **Cafe interacts with Building properties**
    public void printCafeInfo() {
        System.out.println(this.getName() + " is a " + this.getFloors() +
                "-story cafe located at " + this.getAddress());
    }

    public static void main(String[] args) {
        // Create Cafe object (interacts with Building)
        Cafe myCafe = new Cafe("Campus Cafe", "123 College Rd", 1, 30, 10, 5, 2);

        // Use Building methods
        myCafe.printCafeInfo();

        // Sell some coffee
        myCafe.sellCoffee(12, 2, 1);
        myCafe.sellCoffee(10, 3, 2); // triggers restock if inventory is low
    }
}