/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.modular.parallel;

import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;

/**
 * @author rsr
 *
 * Aug 6, 2016
 */
public class TestJavaScript extends TestCaseBase {
	
	
	@Test
	public void testGetAlertText() {
		getDriver().get("http://www.google.com");
		javaScript.executeScript("prompt('Please enter your name');");
		System.out.println(alert.getAlertText());
		alert.AcceptPrompt("Harry Potter");
		javaScript.executeScript("prompt('Please enter your name');");
		alert.DismissAlertIfPresent();
	}
	
	@Test
	public void testPromt() {
		getDriver().get("http://www.google.com");
		javaScript.executeScript("prompt('Please enter your name');");
		alert.AcceptPrompt("Harry Potter");
		javaScript.executeScript("prompt('Please enter your name');");
		alert.DismissAlertIfPresent();
	}
	
	
	
	/*@Test
	public void testScrollToAncClick() throws IOException, InterruptedException {
		getDriver().get("https://www.udemy.com/");
		javaScript.scrollToElemetAndClick(WaitHelper.handleStaleElement(By.xpath("//a[text()='Sign Up' and @class='signup-link btn btn-success signup-btn mt20']"), 5, 2));
		GenericHelper.takeScreenShot("testScrollToClick");
		BrowserHelper.goBack();
		BrowserHelper.goForward();
		javaScript.scrollIntoViewAndClick(WaitHelper.handleStaleElement(By.xpath("//a[text()='Sign Up' and @class='dropdown__main-link']"), 5, 2));
		GenericHelper.takeScreenShot("testScrollIntoViewClick");
	}*/

}