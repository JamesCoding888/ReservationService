package enabledbutton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonStatusTracker {
  public static void main(String[] args) {
    // Set up the driver
    WebDriver driver = new ChromeDriver();
    System.out.println(driver);
    // Navigate to the webpage
    driver.get("https://webpac.tphcc.gov.tw/webpac/content.cfm?mid=1046259&m=ss&k0=Chip%20war&t0=k&c0=and&list_num=10&current_page=1&mt=&at=&sj=&py=&pr=&it=&lr=&lg=&si=1&view=d");
//    driver.get("https://webpac.tphcc.gov.tw/webpac/search.cfm");
    
    // Find the button with class "btn-light" and click it
    WebElement button = driver.findElement(By.className("btn-light"));
    button.click();
    
    
    // Wait for the webpage to load after the button click
    try {
        Thread.sleep(5000); // wait for 5 seconds
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    // Check the status of the button
    boolean isEnabled = button.isEnabled();
    System.out.println("The button is enabled: " + isEnabled);
    
    // Close the driver
    driver.quit();
  }
}
