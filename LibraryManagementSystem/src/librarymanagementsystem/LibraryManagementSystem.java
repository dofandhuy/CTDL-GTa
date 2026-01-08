
package librarymanagementsystem;
import java.util.*;
import java.io.*;
public class LibraryManagementSystem {
 LinkedList<Book> books = new LinkedList<>();
    LinkedList<Reader> readers = new LinkedList<>();
    LinkedList<BorrowRecord> borrowRecords = new LinkedList<>();

    public void loadBooksFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            books.add(new Book(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Double.parseDouble(parts[4])));
        }
        br.close();
    }

    public void saveBooksToFile(String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        books.traverse(book -> {
            try {
                bw.write(String.format("%s,%s,%d,%d,%.2f%n", book.bcode, book.title, book.quantity, book.lended, book.price));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
    }

    public void displayBooks() {
        books.traverse(System.out::println);
    }

    public void addBookToEnd(String bcode, String title, int quantity, int lended, double price) {
        books.add(new Book(bcode, title, quantity, lended, price));
    }

    public void addBookToBeginning(String bcode, String title, int quantity, int lended, double price) {
        books.addToBeginning(new Book(bcode, title, quantity, lended, price));
    }

    public Book searchBookByCode(String bcode) {
        return books.find(bcode, book -> book.bcode);
    }

    public void deleteBookByCode(String bcode) {
        books.delete(bcode, book -> book.bcode);
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();

        lms.addBookToEnd("B001", "Java Programming", 10, 2, 15.99);
        lms.addBookToEnd("B002", "Data Structures", 5, 0, 12.50);
        lms.addBookToBeginning("B000", "Algorithms", 7, 1, 20.00);

        System.out.println("Book List:");
        lms.displayBooks();

        System.out.println("\nSearch for B002:");
        System.out.println(lms.searchBookByCode("B002"));

        System.out.println("\nDelete B001 and display again:");
        lms.deleteBookByCode("B001");
        lms.displayBooks();
    }
    
}
