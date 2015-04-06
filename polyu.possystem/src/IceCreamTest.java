import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import natalie.project.possystem.domain.Flavor;
import natalie.project.possystem.domain.IceCream;

public class IceCreamTest extends TestCase  {
	private IceCream i = new IceCream();
	@Before
	public void setUp() throws Exception {
		i = new IceCream();
		i.setFlavor(new Flavor("flavor", 1.0));
	}

	@Test
	public void testGetCost() {
		assertEquals(1.0, i.getCost(),0);
	}
	@Test
	public void testGetFlavor() {
		Flavor f = i.getFlavor();
		assertEquals(f.getCost(), i.getCost(),0);
	}

	@Test
	public void testSetFlavor() {
		i.setFlavor(new Flavor("flavor", 1.0));
		Flavor f = i.getFlavor();
		assertEquals(f.getDescr(), "flavor");
	}

	@Test
	public void testSetCost() {
		i.setCost(3.2);
		assertEquals(3.2, i.getCost(),0);
	}

	@Test
	public void testGetDescription() {
		assertEquals(i.getDescription(), "flavor - $1.0");
	}

	@Test
	public void testSetDescription() {
		i.setDescription("flavor2");
		assertEquals(i.getDescription(), "flavor2 - $1.0");
	}


}
