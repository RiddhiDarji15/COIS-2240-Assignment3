import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	private static Transaction instance;
	private Transaction() {

	}
	public static Transaction getTransaction() {
		if (instance == null) {
		instance = new Transaction();
		}
		return instance;
	}
    // Perform the borrowing of a book
    public  boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails);
            
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public boolean returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails);
            return true;

        } else {
            System.out.println("This book was not borrowed by the member.");
            return false;

        }
    }

    // Get the current date and time in a readable format
    private  String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    // Save transaction details to a file
    private void saveTransaction(String transactionDetails) {
        try {
        	BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true));        
            writer.write(transactionDetails);
            writer.newLine();
            writer.newLine(); // Add an extra newline for separation
            System.out.println("Transaction saved: " + transactionDetails);
            writer.close();
        } catch (IOException e) {
        	e.printStackTrace();
            System.out.println("An error occurred while saving the transaction: " + e.getMessage());
        }
    }
 // Display transaction history
    public void displayTransactionHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            System.out.println("Transaction History:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the transaction history: " + e.getMessage());
        }
    }
}