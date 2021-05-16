import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
public class OnlineCalculator {

    public WebDriver driver;

    public OnlineCalculator(){
        System.setProperty("webdriver.gecko.driver", "D://Program//selenium-java//drivers/firefox/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://testpages.herokuapp.com/styled/apps/calculator.html");
        //Setup
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void pressBtn(String aID, String bID, String operator){
        driver.findElement(By.id(aID)).click();
        driver.findElement(By.id(operator)).click();
        driver.findElement(By.id(bID)).click();
        driver.findElement(By.id("buttonequals")).click();
    }

    public int add(int a, int b){
        pressBtn("button0"+a, "button0"+b, "buttonplus");
        String result = driver.findElement(By.id("calculated-display")).getAttribute("value");
        clear();

        return Integer.parseInt(result);
    }

    private void clear() {
        driver.findElement(By.id("buttonallclear")).click();
    }

    public int sub(int a, int b){
        pressBtn("button0"+a, "button0"+b, "buttonminus");
        String result = driver.findElement(By.id("calculated-display")).getAttribute("value");
        clear();
        return Integer.parseInt(result);
    }

    public void close(){
        driver.close();
    }
}
