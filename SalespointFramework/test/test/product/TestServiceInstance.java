package test.product;

import javax.persistence.Entity;

import org.joda.time.DateTime;
import org.salespointframework.core.product.later.AbstractServiceInstance;
import org.salespointframework.core.product.later.ServiceType;


@Entity
public class TestServiceInstance extends AbstractServiceInstance{

	@Deprecated
	public TestServiceInstance(){}
	
	public TestServiceInstance(ServiceType serviceType, DateTime start, DateTime end) {
		super(serviceType, start, end);
		}
}
