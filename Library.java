import java.util.Hashtable;

/**
 * A Library is a type of Building that manages a collection of books.
 */
public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;

  /**
   * Construct a new Library.
   *
   * @param name    Name of the library
   * @param address Address of the library
   * @param nFloors Number of floors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
  }

  /** Adds a book to the collection and marks it as available */
  public void addTitle(String title) {
    collection.put(title, true);
  }

  /**
   * Removes a book from the collection and returns the title, or null if not
   * found
   */
  public String removeTitle(String title) {
    if (collection.containsKey(title)) {
      collection.remove(title);
      return title;
    }
    return null;
  }

  /** Checks out a book (marks it as unavailable) */
  public void checkOut(String title) {
    if (collection.containsKey(title)) {
      collection.replace(title, false);
    }
  }

  /** Returns a book (marks it as available) */
  public void returnBook(String title) {
    if (collection.containsKey(title)) {
      collection.replace(title, true);
    }
  }

  /** Returns true if the title is in the collection */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /** Returns true if the book is currently available */
  public boolean isAvailable(String title) {
    return collection.getOrDefault(title, false);
  }

  /** Prints all titles and their status */
  public void printCollection() {
    System.out.println("Collection at " + this.getName() + ":");
    for (String title : collection.keySet()) {
      String status = collection.get(title) ? "Available" : "Checked Out";
      System.out.println("- " + title + " (" + status + ")");
    }
  }

  /** Prints Library info including Building details and book collection */
  public void printLibraryInfo() {
    System.out.println(this.getName() + " is a " + this.getFloors() + "-story library located at " + this.getAddress());
    printCollection();
  }

  /** MAIN method to test Library */
  public static void main(String[] args) {
    Library campusLibrary = new Library("Campus Library", "2 College Rd", 2);

    // Add some books
    campusLibrary.addTitle("The Lorax by Dr. Seuss");
    campusLibrary.addTitle("1984 by George Orwell");
    campusLibrary.addTitle("To Kill a Mockingbird by Harper Lee");

    // Check out a book
    campusLibrary.checkOut("1984 by George Orwell");

    // Print full library info
    campusLibrary.printLibraryInfo();

    // Return the book and show updated collection
    campusLibrary.returnBook("1984 by George Orwell");
    System.out.println("\nAfter returning 1984:");
    campusLibrary.printLibraryInfo();
  }
}