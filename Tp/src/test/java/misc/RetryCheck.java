package misc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryCheck {
	@Test(retryAnalyzer=com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void activatesim() {
		System.out.println("execute retry");
		Assert.assertEquals("", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

}
