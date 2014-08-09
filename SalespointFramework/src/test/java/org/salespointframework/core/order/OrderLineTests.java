package org.salespointframework.core.order;

import static org.junit.Assert.*;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;
import org.salespointframework.AbstractIntegrationTests;
import org.salespointframework.core.accountancy.payment.Cash;
import org.salespointframework.core.catalog.Catalog;
import org.salespointframework.core.catalog.Keks;
import org.salespointframework.core.catalog.Product;
import org.salespointframework.core.quantity.Units;
import org.salespointframework.core.useraccount.UserAccount;
import org.salespointframework.core.useraccount.UserAccountManager;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings({ "javadoc" })
public class OrderLineTests extends AbstractIntegrationTests {

	
	@Autowired
	private UserAccountManager userAccountManager;
	
	@Autowired
	private Catalog catalog;

	private static int keksCounter = 0;
	private UserAccount user;
	private Order order;
	private OrderLine orderLine;

	@Before
	public void before() {
		Product keks = new Keks("OrderLine Keks " + keksCounter++, Money.zero(CurrencyUnit.EUR));

		catalog.add(keks);

		user = userAccountManager.create("userId", "");
		order = new Order(user, Cash.CASH);
		orderLine = new OrderLine(keks, Units.TEN);
	}

	@Test(expected = NullPointerException.class)
	public void nullTest() {
		order.addOrderLine(null);
	}

	@Test(expected = NullPointerException.class)
	public void nullTest2() {
		order.removeOrderLine(null);
	}

	@Test
	public void addTest() {
		assertTrue(order.addOrderLine(orderLine));
	}

	@Test
	public void addTest2() {
		order.addOrderLine(orderLine);
		assertFalse(order.addOrderLine(orderLine));
	}

	@Test
	public void removeTest() {
		order.addOrderLine(orderLine);
		assertTrue(order.removeOrderLine(orderLine.getIdentifier()));
	}

	@Test
	public void removeTest2() {
		assertFalse(order.removeOrderLine(orderLine.getIdentifier()));
	}

	/*
	 * @Test(expected=IllegalArgumentException.class)
	 * 
	 * @Ignore public void numberOrderedNegativeTest() { new
	 * PersistentOrderLine(new ProductIdentifier(), -1337); }
	 */
}
