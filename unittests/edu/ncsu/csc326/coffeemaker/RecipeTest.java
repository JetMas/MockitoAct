package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.mockito.AdditionalMatchers.*;

public class RecipeTest extends TestCase {
	
	private Recipe r;
	
	public void setUp() throws Exception{
		
		r = mock(Recipe.class);
		
		try {
			r.setName("");
			r.setAmtChocolate("0");
			r.setAmtCoffee("0");
			r.setAmtMilk("0");
			r.setAmtSugar("0");
			r.setPrice("0");
		}
		catch (Exception e) {
			// Should not fail
			fail("Could not set something correctly");
		}
		
		super.setUp();
	}
	
	////////////////
	// Test Names //
	////////////////
	public void testGetName() {
		when(r.getName()).thenReturn("");
		assertEquals("", r.getName());
		verify(r).getName();
	}
	
	public void testSetName() {
		r.setName("NEWNAME");
		when(r.getName()).thenReturn("NEWNAME");
		assertEquals("NEWNAME", r.getName());
		verify(r).getName();
	}
	
	/////////////////
	// Test Prices //
	/////////////////
	public void testGetPrice() {
		when(r.getPrice()).thenReturn(0);
		assertEquals(0, r.getPrice());
		verify(r).getPrice();
	}
	
	public void testSetPrice() {
		try {
			r.setPrice("5");
		}
		catch (Exception e) {
			throw new AssertionFailedError("set price");
		}
		when(r.getPrice()).thenReturn(5);
		assertEquals("Price should be 5", 5, r.getPrice());
		verify(r).getPrice();
	}
	
	public void testSetPriceWithNegativeNumber() {
		try {
			r.setPrice("-5");
		}
		catch (Exception e) {
			when(RecipeException.class.isInstance(e)).thenReturn(true);
			assertTrue(RecipeException.class.isInstance(e));
			verify(RecipeException.class).isInstance(e);
		}
	}

	public void testSetPriceWithInvalidInput() {
        try {
            r.setPrice("abcde");
        }
        catch (Exception e) {
        	when(RecipeException.class.isInstance(e)).thenReturn(true);
            assertTrue(RecipeException.class.isInstance(e));
            verify(RecipeException.class).isInstance(e);
        }
    }
	
	/////////////////
	// Test Coffee //
	/////////////////
	public void testGetAmtCoffee() {
		when(r.getAmtCoffee()).thenReturn(0);
		assertEquals(0, r.getAmtCoffee());
		verify(r).getAmtCoffee();
	}
	
	public void testSetAmtCoffee() {
		
		try{
			r.setAmtCoffee("5");
		}
		catch(Exception e) {
			throw new AssertionFailedError("set amt coffee");
		}
		when(r.getAmtCoffee()).thenReturn(5);
		assertEquals(5, r.getAmtCoffee());
		verify(r).getAmtCoffee();
		
	}
	
	public void testSetCoffeeWithNegativeNumber() {
		try {
			r.setAmtCoffee("-5");
		}
		catch (Exception e) {
			when(Exception.class.isInstance(e)).thenReturn(true);
			assertTrue(RecipeException.class.isInstance(e));
			verify(Exception.class).isInstance(e);
		}
	}

    public void testSetCoffeeWithInvalidInput() {
        try {
            r.setAmtCoffee("abcde");
        }
        catch (Exception e) {
			when(Exception.class.isInstance(e)).thenReturn(true);
            assertTrue(RecipeException.class.isInstance(e));
			verify(Exception.class).isInstance(e);
        }
    }
	
	///////////////
	// Test Milk //
	///////////////
	public void testGetAmtMilk() {
		when(r.getAmtMilk()).thenReturn(0);
		assertEquals(0, r.getAmtMilk());
		verify(r).getAmtMilk();
	}
	
	public void testSetAmtMilk() {
		try{
			r.setAmtMilk("5");
		}
		catch(Exception e) {
			throw new AssertionFailedError("set amt milk");
		}
		when(r.getAmtMilk()).thenReturn(5);
		assertEquals(5, r.getAmtMilk());
		verify(r).getAmtMilk();
	}
	
	public void testSetMilkWithNegativeNumber() {
		try {
			r.setAmtMilk("-5");
		}
		catch (Exception e) {
			when(Exception.class.isInstance(e)).thenReturn(true);
			assertTrue(RecipeException.class.isInstance(e));
			verify(Exception.class).isInstance(e);
		}
	}

    public void testSetMilkWithInvalidInput() {
        try {
            r.setAmtMilk("abcde");
        }
        catch (Exception e) {
        	when(Exception.class.isInstance(e)).thenReturn(true);
            assertTrue(RecipeException.class.isInstance(e));
            verify(Exception.class).isInstance(e);
        }
    }
	
	////////////////
	// Test Sugar //
	////////////////
	public void testGetAmtSugar() {
		when(r.getAmtSugar()).thenReturn(0);
		assertEquals(0, r.getAmtSugar());
		verify(r).getAmtSugar();
	}
	
	public void testSetAmtSugar() {
		try{
			r.setAmtSugar("5");
		}
		catch(Exception e) {
			throw new AssertionFailedError("set amt sugar");
		}
		when(r.getAmtSugar()).thenReturn(5);
		assertEquals(5, r.getAmtSugar());
		verify(r).getAmtSugar();
	}
	
	public void testSetSugarWithNegativeNumber() {
		try {
			r.setAmtSugar("-5");
		}
		catch (Exception e) {
			when(Exception.class.isInstance(e)).thenReturn(true);
			assertTrue(RecipeException.class.isInstance(e));
			verify(Exception.class).isInstance(e);
		}
	}

	public void testSetSugarWithInvalidInput() {
        try {
            r.setAmtSugar("abcde");
        }
        catch (Exception e) {
        	when(Exception.class.isInstance(e)).thenReturn(true);
            assertTrue(RecipeException.class.isInstance(e));
            verify(Exception.class).isInstance(e);
        }
    }
	
	////////////////////
	// Test Chocolate //
	////////////////////
	public void testGetAmtChocolate() {
		when(r.getAmtChocolate()).thenReturn(0);
		assertEquals(0, r.getAmtChocolate());
		verify(r).getAmtChocolate();
	}
	
	public void testSetAmtChocolate() {
		try{
			r.setAmtChocolate("5");
		}
		catch(Exception e) {
			throw new AssertionFailedError("set amt chocolate");
		}
		when(r.getAmtChocolate()).thenReturn(5);
		assertEquals(5, r.getAmtChocolate());
		verify(r).getAmtChocolate();
	}
	
	public void testSetChocolateWithNegativeNumber() {
		try {
			r.setAmtChocolate("-5");
		}
		catch (Exception e) {
			when(Exception.class.isInstance(e)).thenReturn(true);
			assertTrue(RecipeException.class.isInstance(e));
			verify(Exception.class).isInstance(e);
		}
	}

    public void testSetChocolateWithInvalidInput() {
        try {
            r.setAmtChocolate("abcde");
        }
        catch (Exception e) {
        	when(Exception.class.isInstance(e)).thenReturn(true);
            assertTrue(RecipeException.class.isInstance(e));
            verify(Exception.class).isInstance(e);
        }
    }
	
	public void testToString() {
		when(r.toString()).thenReturn("");
		assertEquals(r.toString(), "");
		//verify(r).toString();
	}
	
	public void testHashCode() {
		r = new Recipe();
		//Mockito cannot stub hashCode() methods, read from docs.
		assertEquals(31, r.hashCode());
	}

	public void testIsEqualNull() {
		//Mockito also cannot stub equals() methods.
		assertFalse(r.equals(null));
	}

	public void testIsEqualToSelf() {
		//Mockito also cannot stub equals() methods.
		assertTrue(r.equals(r));
	}

	public void testIsEqualEmptyString() {
		r = new Recipe();
		Recipe temp = new Recipe();
		temp.setName("");

		//Mockito also cannot stub equals() methods.
		assertTrue(r.equals(temp));
	}

	public void testIsEqualSameName() {
		r = new Recipe();
		
		Recipe temp = new Recipe();
		temp.setName("testing");
		r.setName("testing");
		
		//Mockito also cannot stub equals() methods.
		assertTrue(r.equals(temp));
	}

	public void testIsEqualDifferentName() {
        Recipe temp = new Recipe();
        temp.setName("testing");
        r.setName("");
        
        //Mockito also cannot stub equals() methods.
        assertFalse(r.equals(temp));
    }

    public void testIsEqualDifferentClass() {
    	//Mockito also cannot stub equals() methods.
	    assertFalse(r.equals(5));
    }
	
	public void tearDown() throws Exception{
		super.tearDown();
	}
}