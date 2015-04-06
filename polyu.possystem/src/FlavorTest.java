import static org.junit.Assert.*;
import natalie.project.possystem.domain.Flavor;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;


public class FlavorTest extends TestCase {
	private Flavor f;
	@Before
	public void setUp() throws Exception {
		f = new Flavor("flavor description", 50);
	}

	@Test
	public void testFlavor() {
		
		f = new Flavor("flavor description", 50);
	}

	@Test
	public void testGetDescr() {
		assertEquals("flavor description", f.getDescr());
	}

	@Test
	public void testGetCost() {
		assertEquals(50, f.getCost(),0);
	}

}
