import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

public class LibraryManagementTest {
	 private Library library;
	 
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
	}

