import static org.junit.Assert.*;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Test;


public class AllTests extends TestSuite{

	public static TestSuite suite(){
	 TestSuite suite = new TestSuite("POS Test Suite");
	 suite.addTestSuite(FlavorTest.class);
	 suite.addTestSuite(IceCreamTest.class);
	 suite.addTestSuite(GenericDecoratorTest.class);
	 return suite;
	}
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
