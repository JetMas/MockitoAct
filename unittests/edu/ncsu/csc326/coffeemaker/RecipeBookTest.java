package edu.ncsu.csc326.coffeemaker;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.mockito.AdditionalMatchers.*;

public class RecipeBookTest extends TestCase {

    private RecipeBook book;

	public void setUp() throws Exception {
		super.setUp();

		this.book = mock(RecipeBook.class);
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddRecipe() {
	    Recipe temp = new Recipe();
	    this.book.addRecipe(temp);
	    
	    when(book.getRecipes()).thenReturn(new Recipe[]{temp});
	    assertEquals(this.book.getRecipes()[0], temp);
	    verify(book).getRecipes();
    }

    public void testAddRecipeCopy() {
	    Recipe temp = new Recipe();
	    this.book.addRecipe(temp);
	    boolean added = this.book.addRecipe(temp);
	    
	    when(book.addRecipe(temp)).thenReturn(false);
	    assertEquals(added, false);
	    verify(book, times(2)).addRecipe(temp);
    }
    
    public void testAddRecipeArraySize() {
    	//Requirements specified only three recipes can be added to the CoffeeMaker.
    	//Which means the size of the recipe array needs to be 3
    	when(book.getRecipes()).thenReturn(new Recipe[3]);
    	
    	int recipeArraySize = book.getRecipes().length;
    
    	assertEquals("Recipe array should only hold upto three recipes.", 3, recipeArraySize);
    	verify(book).getRecipes();
    }

    public void testDeleteRecipe() {
        Recipe temp = new Recipe();
      
        this.book.addRecipe(temp);
	    this.book.deleteRecipe(0);
	    
	    when(book.getRecipes()).thenReturn(new Recipe[] {null});
	    assertNull(this.book.getRecipes()[0]);
	    verify(book).getRecipes();
    }

    public void testDeleteOutOfBounds() {
    	when(book.deleteRecipe(anyInt())).thenReturn(null);
    	
        String result = this.book.deleteRecipe(3);
        assertNull(result);
        verify(book).deleteRecipe(anyInt());
    }

    public void testDeleteNullRecipe() {
    	when(book.deleteRecipe(anyInt())).thenReturn(null);
    	
        String result = this.book.deleteRecipe(2);
        assertNull(result);
        verify(book).deleteRecipe(anyInt());
    }

    public void testEditRecipe() {
	    Recipe temp = new Recipe();
	    this.book.addRecipe(temp);
	    try {
            temp.setAmtCoffee("1000");
        } catch (Exception e) {
	        throw new AssertionFailedError("Oops!");
        }

        this.book.editRecipe(0, temp);
        
        when(book.getRecipes()).thenReturn(new Recipe[] {temp});
	    assertEquals(this.book.getRecipes()[0].getAmtCoffee(), 1000);
	    verify(book).getRecipes();
    }

    public void testEditRecipeOutOfBounds() {
    	when(book.editRecipe(anyInt(), eq(new Recipe()))).thenReturn(null);
	    String result = this.book.editRecipe(3, new Recipe());
	    
	    assertNull(result);
	    verify(book).editRecipe(anyInt(), eq(new Recipe()));
    }

    public void testEditRecipeNull() {
    	when(book.editRecipe(anyInt(), eq(null))).thenReturn(null);
	    String result = this.book.editRecipe(2, null);
	    
	    assertNull(result);
	    verify(book).editRecipe(anyInt(), eq(null));
    }
}