package org.salespointframework.core.inventory;

import static org.junit.Assert.*;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;
import org.salespointframework.core.catalog.Keks;
import org.salespointframework.core.quantity.Units;

@SuppressWarnings({ "javadoc"})
public class InventoryItemTests {

	private static int counter = 0;

	private Keks keks;
	private InventoryItem item;

	@Before
	public void before() {
		keks = new Keks("Superkeks " + counter++, Money.zero(CurrencyUnit.EUR));

		item = new InventoryItem(keks, Units.TEN);
	}

	@Test
	public void foobar() {
		item.increaseQuantity(Units.TEN);
		assertEquals(item.getQuantity(), Units.TEN.add(Units.TEN));
	}

}
