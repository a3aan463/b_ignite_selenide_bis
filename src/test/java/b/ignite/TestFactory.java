package b.ignite;

import java.util.ArrayList;

import org.testng.annotations.Factory;



public class TestFactory {
	
	@Factory
	public Object[] testFactory()
	{
		ArrayList<BaseTest> testObjects = new ArrayList<BaseTest> ();
		
		testObjects.add(new BisTest_4_clipboard());

		return testObjects.toArray();
	}

}
