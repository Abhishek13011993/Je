package misc;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.generic.baseutility.BaseClass;


@Listeners(com.comcast.crm.generic.listenerutility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass
{
	@Test
	public void createInvoiceTest() {
		System.out.println("Execute createInvoiceTest");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	@Test
	public void createInvoicewithContactTest() {
		System.out.println("Execute createInvoicewithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
