import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

public class LibraryManagementTest {
	 private Library library;
	 private Transaction transaction;
	 
	@Before
	    public void setUp() {
	        library = new Library();
	    }
	    
	    @Test
	    public void testBookId() {
	        // Validate boundary cases
	        try {
	            Book validBook1 = new Book(100, "Boundary Book 100");
	            assertNotNull(validBook1);
	            

	            Book validBook2 = new Book(999, "Boundary Book 999");
	            assertNotNull(validBook2);
	            
	        } catch (Exception e) {
	            fail("Exception should not be thrown for valid book IDs 100 and 999.");
	        }

	        // Test invalid numbers
	        try {
	            Book validBook3 = new Book(1000, "Invalid Book 1000");
	            assertNull(validBook3);
	        } catch (Exception e) {
	          
	        }
	        
	        try {
	        	 new Book(99, "Invalid Book 99");
	        	
	            
	        } catch (Exception e) {
	        	assertEquals("Invalid book ID. It must be between 100 and 999.", e.getMessage());
	        	//assertNull("Exception should be thrown for invalid book ID 99.", validBook4);
	        }

	        try {
	            new Book(10000, "Invalid Book 10000");
	           
	        } catch (Exception e) {
	            assertEquals("Invalid book ID. It must be between 100 and 999.", e.getMessage());
	            }
	        }
	        @Test
	        public void testBorrowReturn() {
	            try {
	                // Instantiate a Book object and a Member object
	                Book book = new Book(200, "Test Book");
	                Member member = new Member(1, "Test Member");

	                // Ensure the book is available
	                assertTrue(book.isAvailable());

	                // Borrow the book
	                boolean borrowResult = transaction.borrowBook(book, member);
	                assertTrue(borrowResult);
	                assertFalse(book.isAvailable());

	                // Attempt to borrow the book again
	                borrowResult = transaction.borrowBook(book, member);
	                assertFalse(borrowResult);

	                // Return the book
	                boolean returnResult = transaction.returnBook(book, member);
	                assertTrue(returnResult);
	                assertTrue(book.isAvailable());

	                // Attempt to return the book again
	                returnResult = transaction.returnBook(book, member);
	                assertFalse(returnResult);
	            } catch (Exception e) {
	            } 
	    }
	}

