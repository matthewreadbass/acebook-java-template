import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;

public class TestService {

  WebDriver driver;
  Faker faker;
  @Value("${spring.datasource.chromedriver}")
  private String chromedriver;

  @Before
  public void setup() {
      System.setProperty("webdriver.chrome.driver", chromedriver);
      driver = new ChromeDriver();
      faker = new Faker();
  }

  @After
  public void tearDown() {
      driver.close();
  }
  
  public String signUp() {
    driver.get("http://localhost:8080/users/new");
    String randomName = faker.name().firstName();
    driver.findElement(By.id("username")).sendKeys(randomName);
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.id("submit")).click();
    return randomName;
  }

  public void signIn(String randomName) {
    // TimeUnit.SECONDS.sleep(1);
    // Thread.sleep(90000);
    // driver.get("http://localhost:8080");
    driver.findElement(By.id("username")).sendKeys(randomName);
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.className("btn")).click();
  }

  public void logOut() {
    // driver.get("http://localhost:8080/posts");
    driver.findElement(By.className("logout_btn")).click();
  }
}
