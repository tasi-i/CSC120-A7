import java.util.Hashtable;

/**
 * A Library is a type of Building that manages a collection of books.
 * Each book is represented by its title and author (concatenated as a String),
 * and has an availability status (true = available, false = checked out).
 */
public class Library extends Building implements LibraryRequirements {

    /** Collection of books: key = title, value = availability */
    private final Hashtable<String, Boolean> collection;

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

    /** @inheritDoc */
    @Override
    public void addTitle(String title) {
        collection.put(title, true);
    }

    /** @inheritDoc */
    @Override
    public String removeTitle(String title) {
        if (!collection.containsKey(title)) {
            throw new MissingException("Cannot remove — book not found: " + title);
        }
        collection.remove(title);
        return title;
    }

    /** @inheritDoc */
    @Override
    public void checkOut(String title) {
        if (!collection.containsKey(title)) {
            throw new MissingException("Cannot check out — book not found: " + title);
        }
        if (!collection.get(title)) {
            throw new MissingException("Cannot check out — book is already checked out: " + title);
        }
        collection.put(title, false);
    }

    /** @inheritDoc */
    @Override
    public void returnBook(String title) {
        if (!collection.containsKey(title)) {
            throw new MissingException("Cannot return — book not found: " + title);
        }
        if (collection.get(title)) {
            throw new MissingException("Cannot return — book is already available: " + title);
        }
        collection.put(title, true);
    }

    /** @inheritDoc */
    @Override
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    /** @inheritDoc */
    @Override
    public boolean isAvailable(String title) {
        return collection.getOrDefault(title, false);
    }

    /** @inheritDoc */
    @Override
    public void printCollection() {
        System.out.println("Collection at " + this.getName() + ":");
        for (String title : collection.keySet()) {
            String status = collection.get(title) ? "Available" : "Checked Out";
            System.out.println("- " + title + " (" + status + ")");
        }
    }

    /**
     * Prints detailed information about the library, including building info
     * and the current book collection.
     */
    public void printLibraryInfo() {
        System.out.println(this.getName() + " is a " + this.getFloors() +
                "-story library located at " + this.getAddress());
        printCollection();
    }
}

/**
 * Exception thrown when a book is missing or cannot be processed.
 * Package-private to comply with assignment (no separate file required).
 */
class MissingException extends RuntimeException {
    public MissingException(String message) {
        super(message);
    }
}