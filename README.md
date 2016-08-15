###Paralle Modular Framework

Selenium Modular Framework with Parallel execution support using Testng.
It also support the execution in grid enviroment. Refer to the example.
User need to setup node and hub manually and specify the details inside the xml file.
Refer to the below example

###Here is the basic code:

Extend your test class with TestCaseBase class, all the object to handle the web component will be available.

```java
package com.modular.parallel;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;

/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 *
 */
public class TestDropDown extends TestCaseBase {
	
	@Test
	public void linkHelperTest() throws Exception {
		getDriver().get("https://www.pluralsight.com/");
		wait.elementExistAndVisible(By.partialLinkText("Business"), getConfigReader().getExplicitWait(), 250);
		link.clickPartialLink("Business");
		Thread.sleep(3000);
		Assert.assertEquals(getDriver().getTitle(), "Group Plans | Pluralsight");
	}
}
```

### Use the testng.xml file to run the test case sequentially and parallely 

```xml
<suite name="Suite" parallel="tests" thread-count="5">
	<listeners>
		<listener
			class-name="com.modular.parallel.listeners.reportlistener.ExcelReportListener" />
		<listener
			class-name="com.modular.parallel.listeners.reportlistener.ExtentReportListener" />
	</listeners>
	<test name="Test - 1">
		<classes>
			<class name="com.modular.parallel.TestDropDown" />
		</classes>
	</test>
	<test name="Test - 2">
		<classes>
			<class name="com.modular.parallel.TestDropDown" />
		</classes>
	</test>
</suite>
```

### Use the gridtestng.xml file to run the test case on grid. User need to setup the node and hub manually and sepcify the details in gridtestng.xml

```xml
<suite name="Suite" parallel="tests" thread-count="5">
	<listeners>
		<listener
			class-name="com.modular.parallel.listeners.reportlistener.ExcelReportListener" />
		<listener
			class-name="com.modular.parallel.listeners.reportlistener.ExtentReportListener" />
	</listeners>
	<test name="Test - 1">
		<parameter name="hubUrl" value="http://192.168.0.107:4444/wd/hub" />
		<parameter name="browser" value="Chrome"></parameter>
		<classes>
			<class name="com.modular.parallel.TestDropDown" />
		</classes>
	</test>
	<test name="Test - 2">
		<parameter name="hubUrl" value="http://192.168.0.107:4444/wd/hub" />
		<parameter name="browser" value="Firefox"></parameter>
		<classes>
			<class name="com.modular.parallel.TestDropDown" />
		</classes>
	</test>
</suite> 
```

### To see this whole thing running simply checkout this project and run this command:
mvn clean generate-sources test
