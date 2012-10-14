package test.product;

import javax.persistence.Entity;

import org.salespointframework.core.money.Money;
import org.salespointframework.core.product.PersistentProduct;
import org.salespointframework.core.quantity.Units;

@SuppressWarnings("javadoc")
@Entity
public class Keks extends PersistentProduct {

	@Deprecated
	protected Keks() {
		
	}
	
	public Keks(String name, Money price) {
		super(name, Money.OVER9000, Units.METRIC);
	}

}
