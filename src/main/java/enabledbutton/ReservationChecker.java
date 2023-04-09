package enabledbutton;
/*
	This is a Java program that uses the Selenium WebDriver library to automate a task on a web page.
	
	<tr> 		 
		<td data-title="條碼號：">
       		<span>A3017185</span>
                    
                    
  		</td>
  		<td data-title="預約：" class="t-c">            
        	<span>
        		<a class="btn-gray">預約</a>        	
        	</span>                    
    	</td>
    </tr>    
    <tr> 		 
		<td data-title="條碼號：">
       		<span>A3017186</span>                   
  		</td>
  		<td data-title="預約：" class="t-c">            
        	<span>
        		<a class="btn-light" onclick="do_pop('ready_to_reserve','A3017186'); return false;">預約</a>
        	</span>                    
    	</td>
    </tr>
    
	#1 code snippet:
		
		Note that #1 code snippet only checks the button's status once. If you want to continuously check the button's status until it becomes enabled, 
		you will need to use a loop that repeatedly checks the button's status and waits a certain amount of time between each check.  
		
	#2 code snippet:
		
		The #2 code snippet we use a loop and wait for a certain amount of time before checking again. 	
		
		Also, we do refresh the web-page with the driver.navigate().refresh() method, which will reload the current page.		
	
		Overall, the #2 example will keep refreshing the page and checking the status of the button until it is enabled. 
	
		Once it is enabled, the loop will break and you can click the button.			   

*/

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReservationChecker {
    public static void main(String[] args) {        
    	// The program starts by creating a new instance of the ChromeDriver, 
    	// which is a WebDriver implementation that controls the Chrome browser.
        WebDriver driver = new ChromeDriver();
        System.out.println(driver);
        // Navigate to the library reservation system page, with a specific URL using the get() method.
        driver.get("https://webpac.tphcc.gov.tw/webpac/content.cfm?mid=1046259&m=ss&k0=Chip%20war&t0=k&c0=and&list_num=10&current_page=1&mt=&at=&sj=&py=&pr=&it=&lr=&lg=&si=1&view=d");    
        // #1
        /*
		// Find the desired element using the XPath expression
		WebElement row = driver.findElement(By.xpath("//td[span='A3017185']/following-sibling::td[contains(@class, 't-c')]/span/a[@onclick=\"do_pop('ready_to_reserve','A3017185'); return false;\"]"));
		// Check whether the element is enabled using the isEnabled() method.
		Boolean isEnabled = row.isEnabled();
		// If the element is enabled, it prints a message indicating that the button is
		// enabled.
		if (row.isEnabled()) {
			System.out.println("Button is enabled: " + isEnabled);
		} else {
			System.out.println("Button is disabled");
		}
        */
        
		// #2
//      /*
		// The program defines a WebElement variable named button and sets it to null.
		WebElement button = null;
		// The program then enters a while loop that will continue until the button
		// element is found and is enabled.
		while (button == null) {
			try {
				// The program first calls the navigate().refresh() method to refresh the page.
				driver.navigate().refresh();
				try {
					// The program then waits for 3 seconds using Thread.sleep() method to allow the
					// web page to load completely.
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				/*
				 * The program then uses the findElement() method to locate the button element
				 * using an XPath expression that finds the td element that contains the span
				 * element with text "A3017185", then finds the following td element with a
				 * class attribute containing "t-c", then finds the span element with an anchor
				 * element containing an onclick attribute value of
				 * "do_pop('ready_to_reserve','A3017185'); return false;".
				 * 
				 * If the button is found, it is assigned to the button variable.
				 */
				button = driver.findElement(By.xpath("//td[span='A3017185']/following-sibling::td[contains(@class, 't-c')]/span/a[@onclick=\"do_pop('ready_to_reserve','A3017185'); return false;\"]"));
				// If the button is found, the program checks if it is enabled by calling the
				// isEnabled() method.
				if (button.isEnabled()) {
					System.out.println("Button is enabled: " + button.isEnabled());
					// The button is enabled and can be clicked
					// When the button is found and clicked, the program ends the while loop and
					// exits.
					button.click();
				}
			} catch (NoSuchElementException e) {
				// If the button is not found, a NoSuchElementException is thrown
				System.out.println("The button is not found yet. Waiting...");
				try {
					// waits for 1 second using Thread.sleep()
					// continues to the next iteration of the while loop.
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e.printStackTrace();
				}
			}
		}
//		*/          
        // The program calls the quit() method to close the browser.
        driver.quit();
    }
}

/*
	Console from #1 code snippet: 	 
		 	
		 	Starting ChromeDriver xxx (xxxx-refs/branch-heads/5615@{#936}) on port xxxx
			Only local connections are allowed.
			Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
			ChromeDriver was started successfully.
			Apr 09, 2023 11:55:57 AM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
			WARNING: Unable to find an exact match for CDP version 112, so returning the closest version found: 111
			ChromeDriver: chrome on MAC
			Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//td[span='A3017185']/following-sibling::td[contains(@class, 't-c')]/span/a[@onclick="do_pop('ready_to_reserve','A3017185'); return false;"]"}
			  (Session info: chrome=xxx)
			For documentation on this error, please visit: https://selenium.dev/exceptions/#no_such_element
			Build info: version: '4.8.3', revision: 'e5e76298c3'
			System info: os.name: 'Mac OS', os.arch: 'xxx', os.version: 'xxx', java.version: '16.0.1'
			Driver info: org.openqa.selenium.chrome.ChromeDriver
			Command: [xxx, findElement {using=xpath, value=//td[span='A3017185']/following-sibling::td[contains(@class, 't-c')]/span/a[@onclick="do_pop('ready_to_reserve','A3017185'); return false;"]}]
			Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: xxx, chrome: {chromedriverVersion: xxx (bd2a7bcb881c..., userDataDir: /var/folders/kg/m3gy2__x7xb...}, goog:chromeOptions: {debuggerAddress: localhost:52683}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: MAC, proxy: Proxy(), se:cdp: ws://localhost:xxx/devtoo..., se:cdpVersion: xxx, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}
			Session ID: xxx
				at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
				at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:78)
				at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
				at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
				at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)
				at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:200)
				at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:133)
				at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:53)
				at org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:193)
				at org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:183)
				at org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:158)
				at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:543)
				at org.openqa.selenium.remote.ElementLocation$ElementFinder$2.findElement(ElementLocation.java:162)
				at org.openqa.selenium.remote.ElementLocation.findElement(ElementLocation.java:60)
				at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:352)
				at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:344)
				at chromedriver123.ReservationChecker.main(ReservationChecker.java:64)	
			
	Console from #2 code snippet for catching the enabled button:		
			
			Starting ChromeDriver xxx (xxx-refs/branch-heads/5615@{#936}) on port xxx
			Only local connections are allowed.
			Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
			ChromeDriver was started successfully.
			Apr 09, 2023 12:47:43 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
			WARNING: Unable to find an exact match for CDP version 112, so returning the closest version found: 111
			ChromeDriver: chrome on MAC (xxx)
			Button is enabled: true

	Console from #2 code snippet for awaiting the enabled button:
			
			Starting ChromeDriver xxx (xxx-refs/branch-heads/5615@{#936}) on port xxx
			Only local connections are allowed.
			Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
			ChromeDriver was started successfully.
			Apr 09, 2023 12:54:11 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
			WARNING: Unable to find an exact match for CDP version 112, so returning the closest version found: 111
			ChromeDriver: chrome on MAC (xxx)
			The button is not found yet. Waiting...
			The button is not found yet. Waiting...


*/