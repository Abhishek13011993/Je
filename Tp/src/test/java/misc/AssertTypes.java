package misc;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertTypes
{
	@Test
	public void hm(Method mtd) {
		System.out.println(mtd.getName() + " Test Start");
		SoftAssert assertObj= new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertEquals("hm", "hm");
		System.out.println("step-3");
		assertObj.assertEquals("Title", "Title");
		System.out.println("step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName() + "Test End");
	}
	@Test
	public void vl(Method mtd) {
		System.out.println(mtd.getName() + " Test Start");
		SoftAssert assertObj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		assertObj.assertTrue(true);
		System.out.println("step-3");
		System.out.println("step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName() + "Test End");
	}
}
