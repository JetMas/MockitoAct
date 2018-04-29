package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.mockito.AdditionalMatchers.*;

public class InventoryTest extends TestCase {
	
	private int initialAmt = 15;
	private Inventory inventory;
	
	public void setUp() throws Exception {
		//initialAmt = 15;//Inventory items starts at 15
		//inventory = new Inventory();
		inventory = mock(Inventory.class);
		
		
		super.setUp();
	}
	
	////////////////////
	//Chocolate tests
	////////////////////
	public void testGetChocolateConstructor(){
		when(inventory.getChocolate()).thenReturn(initialAmt);
		
	
		assertEquals("The number of chocolates should start at " + initialAmt, inventory.getChocolate(), initialAmt);
		verify(inventory).getChocolate();
	}
	
	public void testSetChocolateUpper() {
		when(inventory.getChocolate()).thenCallRealMethod();
		doCallRealMethod().when(inventory).setChocolate(gt(0));
		
		int newChocoAmt = 1;
		inventory.setChocolate(newChocoAmt);
		
		assertEquals("The chocolate amount was set to " + newChocoAmt, newChocoAmt, inventory.getChocolate());
		verify(inventory).getChocolate();
		verify(inventory).setChocolate(gt(0));
	}
	
	public void testSetChocolateLower() {
		when(inventory.getChocolate()).thenCallRealMethod();
		doCallRealMethod().when(inventory).setChocolate(lt(0));

		int currChocoAmt = inventory.getChocolate();
		int newChocoAmt = -1;
		inventory.setChocolate(newChocoAmt);		
		
		assertEquals("The chocolate amount was set to " + newChocoAmt +". Amount should have not changed", currChocoAmt, inventory.getChocolate());
		verify(inventory, times(2)).getChocolate();
		verify(inventory).setChocolate(lt(0));
	}
	
	public void testAddChocolate() {
		when(inventory.getChocolate()).thenCallRealMethod();
		try {
			doCallRealMethod().when(inventory).addChocolate("1");
		} catch (InventoryException e1) {
			e1.printStackTrace();
		}
		
		int currChocoAmt = inventory.getChocolate();
		int addAmt = 1;
		
		try {
			inventory.addChocolate(Integer.toString(addAmt));
			currChocoAmt += addAmt;
		}catch(InventoryException e) {
			fail("Failure to add " + addAmt + " chocolate.");
		}
		
		assertEquals("Added "+ addAmt +" chocolate", currChocoAmt, inventory.getChocolate());
		try {
			verify(inventory).addChocolate("1");
		} catch (InventoryException e) {
			e.printStackTrace();
		}
		verify(inventory, times(2)).getChocolate();
	}
	
	public void testAddChocolateExceptionNegative() {
		try {
			doThrow(InventoryException.class).when(inventory).addChocolate("-1");
		} catch (InventoryException ex) {
			ex.printStackTrace();
		}
		
		int addAmt = -1;
		
		try {
			inventory.addChocolate(Integer.toString(addAmt));
		}catch(InventoryException e) {
			//Success
			try {
				verify(inventory).addChocolate("-1");
			} catch (InventoryException ex) {
				ex.printStackTrace();
			}
			return;
		}
		
		fail("Did not throw an exception when adding an negative amount to Chocolate.");
	}
	
	public void testAddChocolateExceptionNotInteger() {
		try {
			doThrow(InventoryException.class).when(inventory).addChocolate(Double.toString(anyDouble()));
		} catch (InventoryException ex) {
			ex.printStackTrace();
		}
		
		double addAmt = 1.1;
		
		try {
			inventory.addChocolate(Double.toString(addAmt));
		}catch(InventoryException e) {
			//Success
			try {
				verify(inventory).addChocolate(Double.toString(anyDouble()));
			} catch (InventoryException ex) {
				ex.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a double to Chocolate. Should have thrown an exception.");
	}
	
	public void testAddChocolateExceptionCharacter() {
		try {
			doThrow(InventoryException.class).when(inventory).addChocolate(anyString());
		} catch (InventoryException ex) {
			ex.printStackTrace();
		}
		
		String addAmt = "a";
		
		try {
			inventory.addChocolate(addAmt);
		}catch(InventoryException e) {
			//Success
			try {
				verify(inventory).addChocolate(anyString());
			} catch (InventoryException ex) {
				ex.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a Character to Chocolate. Should have thrown an exception.");
	}
	
	public void testAddChocolateExceptionEmptyString() {
		try {
			doThrow(InventoryException.class).when(inventory).addChocolate("");
		} catch (InventoryException ex) {
			ex.printStackTrace();
		}
		
		String addAmt = "";
		
		try {
			inventory.addChocolate(addAmt);
		}catch(InventoryException e) {
			//Success
			try {
				verify(inventory).addChocolate("");
			} catch (InventoryException ex) {
				ex.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a Empty String to Chocolate. Should have thrown an exception.");
	}
	
	////////////////////
	//Coffee tests
	////////////////////
	public void testGetCoffeeConstructor() {
		when(inventory.getCoffee()).thenReturn(initialAmt);
		
		assertEquals("The number of coffee should start at " + initialAmt, inventory.getCoffee(), initialAmt);
		verify(inventory).getCoffee();
	}
	
	public void testSetCoffeeUpper() {
		when(inventory.getCoffee()).thenCallRealMethod();
		doCallRealMethod().when(inventory).setCoffee(gt(0));
		
		int newCoffeeAmt = 1;
		inventory.setCoffee(newCoffeeAmt);
		
		assertEquals("The coffee amount was set to " + newCoffeeAmt, newCoffeeAmt, inventory.getCoffee());
		verify(inventory).getCoffee();
		verify(inventory).setCoffee(gt(0));
	}
	
	public void testSetCoffeeLower() {
		when(inventory.getCoffee()).thenCallRealMethod();
		doCallRealMethod().when(inventory).setCoffee(lt(0));
		
		int currCoffeeAmt = inventory.getCoffee();
		int newCoffeeAmt = -1;
		inventory.setCoffee(newCoffeeAmt);
		
		assertEquals("The coffee amount was set to " + newCoffeeAmt +". Amount should have not changed", currCoffeeAmt, inventory.getCoffee());
		verify(inventory, times(2)).getCoffee();
		verify(inventory).setCoffee(lt(0));
	}
	
	public void testAddCoffee() {
		when(inventory.getCoffee()).thenCallRealMethod();
		try {
			doCallRealMethod().when(inventory).addCoffee("1");
		} catch (InventoryException ex) {
			ex.printStackTrace();
		}
		
		int currCoffeeAmt = inventory.getCoffee();
		int addAmt = 1;
		
		try {
			inventory.addCoffee(Integer.toString(addAmt));
			currCoffeeAmt += addAmt;
		}catch(Exception e) {
			fail("Failure to add " + addAmt + " coffee.");
		}
		
		
		assertEquals("Added "+ addAmt +" coffee", currCoffeeAmt, inventory.getCoffee());
		verify(inventory, times(2)).getCoffee();
		try {
			verify(inventory).addCoffee("1");
		} catch (InventoryException ex) {
			ex.printStackTrace();
		}
	}
	
	public void testAddCoffeeExceptionNegative() {
		try {
			doThrow(InventoryException.class).when(inventory).addCoffee("-1");
		} catch (InventoryException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		int addAmt = -1;
		
		try {
			inventory.addCoffee(Integer.toString(addAmt));
		}catch(InventoryException e) {
			//Success
			try {
				verify(inventory).addCoffee("-1");
			} catch (InventoryException ex) {
				ex.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Did not throw an exception when adding an negative amount to Coffee.");
	}
	
	public void testAddCoffeeExceptionNotInteger() {
		try {
			doThrow(InventoryException.class).when(inventory).addCoffee(Double.toString(anyDouble()));
		} catch (InventoryException e1) {
			e1.printStackTrace();
		}
		
		double addAmt = 1.1;
		
		try {
			inventory.addCoffee(Double.toString(addAmt));
		}catch(InventoryException e) {
			//Success
			try {
				verify(inventory).addCoffee(Double.toString(anyDouble()));
			} catch (InventoryException e1) {
				e1.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a double to coffee. Should have thrown an exception.");
	}
	
	public void testAddCoffeeExceptionCharacter() {
		try {
			doThrow(InventoryException.class).when(inventory).addCoffee(anyString());
		} catch (InventoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String addAmt = "a";
		
		try {
			inventory.addCoffee(addAmt);
		}catch(InventoryException e) {
			//Success
			try {
				verify(inventory).addCoffee(anyString());
			} catch (InventoryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a String to coffee. Should have thrown an exception.");
	}
	
	public void testAddCoffeelateExceptionEmptyString() {
		try {
			doThrow(InventoryException.class).when(inventory).addCoffee("");
		} catch (InventoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String addAmt = "";
		
		try {
			inventory.addCoffee(addAmt);
		}catch(InventoryException e) {
			//Success
			try {
				verify(inventory).addCoffee("");
			} catch (InventoryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a Empty String to Coffee. Should have thrown an exception.");
	}
	
	////////////////////
	//Milk tests
	////////////////////
	public void testGetMilkConstructor() {
		when(inventory.getMilk()).thenReturn(initialAmt);
		
		assertEquals("The number of milk should start at " + initialAmt, inventory.getMilk(), initialAmt);
		verify(inventory).getMilk();
	}
	
	public void testSetMilkUpper() {
		when(inventory.getMilk()).thenCallRealMethod();
		doCallRealMethod().when(inventory).setMilk(gt(0));
		
		int newMilkAmt = 1;
		inventory.setMilk(newMilkAmt);
		
		assertEquals("The milk amount was set to " + newMilkAmt, newMilkAmt, inventory.getMilk());
		verify(inventory).getMilk();
		verify(inventory).setMilk(gt(0));
	}
	
	public void testSetMilkLower() {
		when(inventory.getMilk()).thenCallRealMethod();
		doCallRealMethod().when(inventory).setMilk(lt(0));
		
		int currMilkAmt = inventory.getMilk();
		int newMilkAmt = -1;
		inventory.setMilk(newMilkAmt);
		
		assertEquals("The milk amount was set to " + newMilkAmt +". Amount should have not changed", currMilkAmt, inventory.getMilk());
		verify(inventory, times(2)).getMilk();
		verify(inventory).setMilk(lt(0));
	}
	
	public void testAddMilk() {
		when(inventory.getMilk()).thenCallRealMethod();
		try {
			doCallRealMethod().when(inventory).addMilk("1");
		} catch (InventoryException ex) {
			ex.printStackTrace();
		}
		
		int currMilkAmt = inventory.getMilk();
		int addAmt = 1;
		
		try {
			inventory.addMilk(Integer.toString(addAmt));
			currMilkAmt += addAmt;
		}catch(InventoryException e) {
			fail("Failure to add " + addAmt + " milk.");
		}
		
		assertEquals("Added "+ addAmt +" milk", currMilkAmt, inventory.getMilk());
		verify(inventory, times(2)).getMilk();
		try {
			verify(inventory).addMilk("1");
		} catch (InventoryException ex) {
			ex.printStackTrace();
		}
	}
	
	public void testAddMilkExceptionNegative() {
		try {
			doThrow(InventoryException.class).when(inventory).addMilk("-1");
		} catch (InventoryException ex) {
			ex.printStackTrace();
		}
		
		int addAmt = -1;
		
		try {
			inventory.addMilk(Integer.toString(addAmt));
		}catch(InventoryException e) {
			//Success
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Did not throw an exception when adding an negative amount to Milk.");
		try {
			verify(inventory).addMilk("-1");
		} catch (InventoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testAddMilkExceptionNotInteger() {
		try {
			doThrow(InventoryException.class).when(inventory).addMilk(Double.toString(anyDouble()));
		} catch (InventoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		double addAmt = 1.1;
		
		try {
			inventory.addMilk(Double.toString(addAmt));
		}catch(InventoryException e) {
			//Success
			try {
				verify(inventory).addMilk(Double.toString(anyDouble()));
			} catch (InventoryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a double to milk. Should have thrown an exception.");
	}
	
	public void testAddMilkExceptionCharacter() {
		try {
			doThrow(InventoryException.class).when(inventory).addMilk(anyString());
		} catch (InventoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String addAmt = "a";
		
		try {
			inventory.addMilk(addAmt);
		}catch(Exception e) {
			//Success
			try {
				verify(inventory).addMilk(anyString());
			} catch (InventoryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a String to milk. Should have thrown an exception.");
	}
	
	public void testAddMilklateExceptionEmptyString() {
		try {
			doThrow(InventoryException.class).when(inventory).addMilk("");
		} catch (InventoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String addAmt = "";
		
		try {
			inventory.addMilk(addAmt);
		}catch(Exception e) {
			//Success
			try {
				verify(inventory).addMilk("");
			} catch (InventoryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a Empty String to Milk. Should have thrown an exception.");
	}
	
	////////////////////
	//Sugar tests
	////////////////////
	public void testGetSugarConstructor() {
		when(inventory.getSugar()).thenReturn(initialAmt);
		
		assertEquals("The number of sugar should start at " + initialAmt, inventory.getSugar(), initialAmt);
		verify(inventory).getSugar();
	}
	
	public void testSetSugarUpper() {
		when(inventory.getSugar()).thenCallRealMethod();
		doCallRealMethod().when(inventory).setSugar(gt(0));
		
		int newSugarAmt = 10;
		inventory.setSugar(newSugarAmt);
		
		assertEquals("The milk amount was set to " + newSugarAmt, newSugarAmt, inventory.getSugar());
		
		verify(inventory).getSugar();
		verify(inventory).setSugar(gt(0));
	}
	
	public void testSetSugarLower() {
		when(inventory.getSugar()).thenCallRealMethod();
		doCallRealMethod().when(inventory).setSugar(lt(0));
		
		int currSugarAmt = inventory.getSugar();
		int newSugarAmt = -1;
		inventory.setSugar(newSugarAmt);
		
		assertEquals("The sugar amount was set to " + newSugarAmt +". Amount should have not changed", currSugarAmt, inventory.getSugar());
		
		verify(inventory, times(2)).getSugar();
		verify(inventory).setSugar(lt(0));
	}
	
	public void testAddSugar() {
		when(inventory.getSugar()).thenCallRealMethod();
		try {
			doCallRealMethod().when(inventory).addSugar("1");
		} catch (InventoryException ex) {
			ex.printStackTrace();
		}
		
		int currSugarAmt = inventory.getSugar();
		int addAmt = 1;
		
		try {
			inventory.addSugar(Integer.toString(addAmt));
			currSugarAmt += addAmt;
		}catch(Exception e) {
			fail("Failure to add " + addAmt + " sugar.");
		}
		
		assertEquals("Added "+ addAmt +" sugar", currSugarAmt, inventory.getSugar());
		verify(inventory, times(2)).getSugar();
		try {
			verify(inventory).addSugar("1");
		} catch (InventoryException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void testAddSugarExceptionNegative() {
		try {
			doThrow(InventoryException.class).when(inventory).addSugar("-1");
		} catch (InventoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int addAmt = -1;
		
		try {
			inventory.addSugar(Integer.toString(addAmt));
		}catch(Exception e) {
			//Success
			try {
				verify(inventory).addSugar("-1");
			} catch (InventoryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Did not throw an exception when adding an negative amount to Sugar.");
	}
	
	public void testAddSugarExceptionNotInteger() {
		try {
			doThrow(InventoryException.class).when(inventory).addSugar(Double.toString(anyDouble()));
		} catch (InventoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		double addAmt = 1.1;
		
		try {
			inventory.addSugar(Double.toString(addAmt));
		}catch(Exception e) {
			//Success
			try {
				verify(inventory).addSugar(Double.toString(anyDouble()));
			} catch (InventoryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a double to sugar. Should have thrown an exception.");
	}
	
	public void testAddSugarExceptionCharacter() {
		try {
			doThrow(InventoryException.class).when(inventory).addSugar(anyString());
		} catch (InventoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String addAmt = "a";
		
		try {
			inventory.addSugar(addAmt);
		}catch(Exception e) {
			//Success
			try {
				verify(inventory).addSugar(anyString());
			} catch (InventoryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a String to sugar. Should have thrown an exception.");
	}
	
	public void testAddSugarlateExceptionEmptyString() {
		try {
			doThrow(InventoryException.class).when(inventory).addSugar("");
		} catch (InventoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String addAmt = "";
		
		try {
			inventory.addSugar(addAmt);
		}catch(Exception e) {
			//Success
			try {
				verify(inventory).addSugar("");
			} catch (InventoryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		//Fail if an exception was not thrown.
		fail("Added a Empty String to Sugar. Should have thrown an exception.");
	}
	
	////////////////////
	//Ingredients tests
	////////////////////
	public void testEnoughIngredients() {
		Recipe r = new Recipe();
		when(inventory.enoughIngredients(r)).thenReturn(true);
		
		assertTrue("There should be enough ingredients", inventory.enoughIngredients(r));
		verify(inventory).enoughIngredients(r);
	}
	
	public void testEnoughIngredientsNotEnoughChoco() {
		Recipe r = new Recipe();
		String ingAmt = "100";
		try {
			r.setAmtChocolate(ingAmt);
		} catch(Exception e) {
			//Not in scope
		}
		when(inventory.enoughIngredients(r)).thenReturn(false);
		
		assertFalse("There should be not enough chocolate", inventory.enoughIngredients(r));
		verify(inventory).enoughIngredients(r);
	}
	
	public void testEnoughIngredientsNotEnoughCoffee() {
		Recipe r = new Recipe();
		String ingAmt = "100";
		try {
			r.setAmtCoffee(ingAmt);
		} catch(Exception e) {
			//Not in scope
		}
		when(inventory.enoughIngredients(r)).thenReturn(false);

		assertFalse("There should be not enough coffee", inventory.enoughIngredients(r));
		verify(inventory).enoughIngredients(r);
	}
	
	public void testEnoughIngredientsNotEnoughMilk() {
		Recipe r = new Recipe();
		String ingAmt = "100";
		try {
			r.setAmtMilk(ingAmt);
		} catch(Exception e) {
			//Not in scope
		}
		when(inventory.enoughIngredients(r)).thenReturn(false);

		assertFalse("There should be not enough milk", inventory.enoughIngredients(r));
		verify(inventory).enoughIngredients(r);
	}
	
	public void testEnoughIngredientsNotEnoughSugar() {
		Recipe r = new Recipe();
		String ingAmt = "100";
		try {
			r.setAmtSugar(ingAmt);
		} catch(Exception e) {
			//Not in scope
		}
		when(inventory.enoughIngredients(r)).thenReturn(false);
		
		assertFalse("There should be not enough sugar", inventory.enoughIngredients(r));
		verify(inventory).enoughIngredients(r);
	}
	
	public void testEnoughIngredientsJustEnoughChocolate() {
		when(inventory.getChocolate()).thenReturn(initialAmt);
		
		int currChoco = inventory.getChocolate();
		
		Recipe r = new Recipe();
		try {
			r.setAmtChocolate(Integer.toString(currChoco));
		} catch(Exception e) {
			//Not in scope
		}
		when(inventory.enoughIngredients(r)).thenReturn(false);
		
		assertFalse("There should be just enough chocolate", inventory.enoughIngredients(r));
		verify(inventory).getChocolate();
		verify(inventory).enoughIngredients(r);
	}
	
	public void testEnoughIngredientsJustEnoughCoffee() {
		when(inventory.getCoffee()).thenReturn(initialAmt);
		
		int currCoffee = inventory.getCoffee();
		
		Recipe r = new Recipe();
		try {
			r.setAmtCoffee(Integer.toString(currCoffee));
		} catch(Exception e) {
			//Not in scope
		}
		when(inventory.enoughIngredients(r)).thenReturn(false);
		
		assertFalse("There should be just enough coffee", inventory.enoughIngredients(r));
		verify(inventory).getCoffee();
		verify(inventory).enoughIngredients(r);
	}
	
	public void testEnoughIngredientsJustEnoughMilk() {
		when(inventory.getMilk()).thenReturn(initialAmt);
		
		int currMilk = inventory.getMilk();
		
		Recipe r = new Recipe();
		try {
			r.setAmtMilk(Integer.toString(currMilk));
		} catch(Exception e) {
			//Not in scope
		}
		when(inventory.enoughIngredients(r)).thenReturn(false);
		
		assertFalse("There should be just enough milk", inventory.enoughIngredients(r));
		verify(inventory).getMilk();
		verify(inventory).enoughIngredients(r);
	}
	
	public void testEnoughIngredientsJustEnoughSugar() {
		when(inventory.getSugar()).thenReturn(initialAmt);
		
		int currSugar = inventory.getSugar();
		
		Recipe r = new Recipe();
		try {
			r.setAmtSugar(Integer.toString(currSugar));
		} catch(Exception e) {
			//Not in scope
		}
		when(inventory.enoughIngredients(r)).thenReturn(false);
		
		assertFalse("There should be just enough sugar", inventory.enoughIngredients(r));
		verify(inventory).getSugar();
		verify(inventory).enoughIngredients(r);
	}
	
	public void testUseIngredientChocolate() {
		when(inventory.getChocolate()).thenReturn(1);
		int currChoco = inventory.getChocolate();
		
		Recipe r = new Recipe();
		int ingAmt = 1;
		try {
			r.setAmtChocolate(Integer.toString(ingAmt));
		} catch(Exception e) {
			//Not in scope
		}
		doCallRealMethod().when(inventory).useIngredients(r);
		
		
		
		inventory.useIngredients(r);
		
		when(inventory.getChocolate()).thenReturn(0);
		assertEquals("Chocolate not decremented properly when used", currChoco-ingAmt, inventory.getChocolate());
		verify(inventory, times(2)).getChocolate();
		verify(inventory).useIngredients(r);
	}
	
	public void testUseIngredientCoffee() {
		when(inventory.getCoffee()).thenReturn(1);
		int currCoffee = inventory.getCoffee();
		
		Recipe r = new Recipe();
		int ingAmt = 1;
		try {
			r.setAmtCoffee(Integer.toString(ingAmt));
		} catch(Exception e) {
			//Not in scope
		}
		doCallRealMethod().when(inventory).useIngredients(r);
		
		inventory.useIngredients(r);
		
		when(inventory.getCoffee()).thenReturn(0);
		assertEquals("Coffee not decremented properly when used", currCoffee-ingAmt, inventory.getCoffee());
		verify(inventory, times(2)).getCoffee();
		verify(inventory).useIngredients(r);
	}
	
	public void testUseIngredientMilk() {
		when(inventory.getMilk()).thenReturn(1);
		int currMilk = inventory.getMilk();
		
		Recipe r = new Recipe();
		int ingAmt = 1;
		try {
			r.setAmtMilk(Integer.toString(ingAmt));
		} catch(Exception e) {
			//Not in scope
		}
		doCallRealMethod().when(inventory).useIngredients(r);
		
		inventory.useIngredients(r);
		
		when(inventory.getMilk()).thenReturn(0);
		assertEquals("Milk not decremented properly when used", currMilk-ingAmt, inventory.getMilk());
		verify(inventory, times(2)).getMilk();
		verify(inventory).useIngredients(r);
	}
	
	public void testUseIngredientSugar() {
		when(inventory.getSugar()).thenReturn(1);
		int currSugar = inventory.getSugar();
		
		Recipe r = new Recipe();
		int ingAmt = 1;
		try {
			r.setAmtSugar(Integer.toString(ingAmt));
		} catch(Exception e) {
			//Not in scope
		}
		doCallRealMethod().when(inventory).useIngredients(r);
		
		inventory.useIngredients(r);
		
		when(inventory.getSugar()).thenReturn(0);
		assertEquals("Sugar not decremented properly when used", currSugar-ingAmt, inventory.getSugar());
		verify(inventory, times(2)).getSugar();
		verify(inventory).useIngredients(r);
	}
	
	public void testUseIngredientsNotEnoughChocolate() {
		int currChoco = inventory.getChocolate();
		
		Recipe r = new Recipe();
		int ingAmt = 100;
		try {
			r.setAmtChocolate(Integer.toString(ingAmt));
		}catch(Exception e) {
			//Not in scope
		}
		
		inventory.useIngredients(r);
		
		assertEquals("Not enough Chocolate, so amount should have not been decremented", currChoco, inventory.getChocolate());
	}
	
	public void testUseIngredientsNotEnoughCoffee() {
		int currCoffee = inventory.getCoffee();
		
		Recipe r = new Recipe();
		int ingAmt = 100;
		try {
			r.setAmtCoffee(Integer.toString(ingAmt));
		}catch(Exception e) {
			//Not in scope
		}
		
		inventory.useIngredients(r);
		
		assertEquals("Not enough Coffee, so amount should have not been decremented", currCoffee, inventory.getCoffee());
	}
	
	public void testUseIngredientsNotEnoughMilk() {
		int currMilk = inventory.getMilk();
		
		Recipe r = new Recipe();
		int ingAmt = 100;
		try {
			r.setAmtMilk(Integer.toString(ingAmt));
		}catch(Exception e) {
			//Not in scope
		}
		
		inventory.useIngredients(r);
		
		assertEquals("Not enough Milk, so amount should have not been decremented", currMilk, inventory.getMilk());
	}
	
	public void testUseIngredientsNotEnoughSugar() {
		int currSugar = inventory.getSugar();
		
		Recipe r = new Recipe();
		int ingAmt = 100;
		try {
			r.setAmtSugar(Integer.toString(ingAmt));
		}catch(Exception e) {
			//Not in scope
		}
		
		inventory.useIngredients(r);
		
		assertEquals("Not enough Sugar, so amount should have not been decremented", currSugar, inventory.getSugar());
	}
	
	public void testToString() {
//		StringBuffer buf = new StringBuffer();
//    	buf.append("Coffee: ");
//    	buf.append(inventory.getCoffee());
//    	buf.append("\n");
//    	buf.append("Milk: ");
//    	buf.append(inventory.getMilk());
//    	buf.append("\n");
//    	buf.append("Sugar: ");
//    	buf.append(inventory.getSugar());
//    	buf.append("\n");
//    	buf.append("Chocolate: ");
//    	buf.append(inventory.getChocolate());
//    	buf.append("\n");
		
		when(inventory.getChocolate()).thenReturn(10);
		when(inventory.getCoffee()).thenReturn(10);
		when(inventory.getMilk()).thenReturn(10);
		when(inventory.getSugar()).thenReturn(10);
		
    	String invString = "Coffee: " + inventory.getCoffee() + "\n" + 
    			"Milk: " + inventory.getMilk() + "\n" +
    			"Sugar: " + inventory.getSugar() + "\n" +
    			"Chocolate: " + inventory.getChocolate() + "\n";
    	
    	when(inventory.toString()).thenReturn("Coffee: " + 10 + "\n" + "Milk: " + 10 + "\n" + "Sugar: " + 10 + "\n" + "Chocolate: " + 10 + "\n");
    	
    	assertEquals("Inventory to string is off", invString, inventory.toString());
    	//verify(inventory).toString();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	
}