package test.inventory;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.salespointframework.core.catalog.PersistentCatalog;
import org.salespointframework.core.database.Database;
import org.salespointframework.core.inventory.PersistentInventory;
import org.salespointframework.core.inventory.PersistentInventoryItem;
import org.salespointframework.core.money.Money;
import org.salespointframework.core.quantity.Units;

import test.product.Keks;

@SuppressWarnings({ "javadoc", "unused" })
public class InventoryTest {

	//private final EntityManagerFactory emf = Database.INSTANCE.getEntityManagerFactory();

	private final PersistentInventory inventory = new PersistentInventory();
	private final PersistentCatalog catalog = new PersistentCatalog();
	private Keks keks;
	private PersistentInventoryItem item;
	
	
	@BeforeClass
	public static void beforeClass() {
		Database.INSTANCE.initializeEntityManagerFactory("SalespointFramework");
	}

	@Before
	public void before() {
		keks = new Keks("Add Superkeks", Money.ZERO);
		
		item = new PersistentInventoryItem(keks, Units.TEN);

	}

	@Test(expected = NullPointerException.class)
	public void testNullCheckConstructor() {
		PersistentInventory inventory = new PersistentInventory(null);
	}

	@Test(expected = NullPointerException.class)
	public void testNullCheckArgument() {
		inventory.add(null);
	}

	@Test
	public void testAdd() {
		inventory.add(item);
	}

	@Test
	public void testRemove() {
		inventory.add(item);
		inventory.remove(item.getIdentifier());
		assertFalse(inventory.contains(item.getIdentifier()));
	}

	@Test
	public void testContains() {
		inventory.add(item);
		assertTrue(inventory.contains(item.getIdentifier()));
	}

	@Test
	public void testGet() {
		inventory.add(item);
		assertEquals(item, inventory.get(PersistentInventoryItem.class, item.getIdentifier()));
	}
}