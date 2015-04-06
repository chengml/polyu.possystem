import static org.junit.Assert.*;
import junit.framework.TestCase;
import natalie.project.possystem.domain.Flavor;
import natalie.project.possystem.domain.GenericDecorator;
import natalie.project.possystem.domain.IceCream;

import org.junit.Before;
import org.junit.Test;


public class GenericDecoratorTest extends TestCase  {
    private GenericDecorator g;
    private IceCream i = new IceCream();
	@Before
	public void setUp() throws Exception {
		testGenericDecorator();
	}

	@Test
	public void testGetDescription() {
		assertEquals(g.getDescription(), "decor_descr");
	}

	@Test
	public void testGetCost() {
		assertEquals(g.getCost(), 3.2,0);
	}

	@Test
	public void testGenericDecorator() {
		Flavor _inFlavor = new Flavor("decor_descr", 3.2);
		i.setFlavor(_inFlavor);
		g = new GenericDecorator(i, "decor_descr", 3.2);
		assertEquals(g.getDescription(), "decor_descr");
	}

}
