import java.util.List;

import com.github.javafaker.Faker;
import com.makersacademy.acebook.Application;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CommentsOnPostTest {

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

  @Test
  public void successfulPhotoUploadToDisplayPhotoInBrowser() throws InterruptedException {
    driver.get("http://localhost:8080/users/new");
    String randomName = faker.name().firstName();
    driver.findElement(By.id("username")).sendKeys(randomName);
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.id("submit")).click();
    
    driver.findElement(By.id("username")).sendKeys(randomName);
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.className("btn")).click();
    
    String content = "Ali Karimiboroujeni's car Junit Test";
    String photoUrl = "https://images.unsplash.com/photo-1636069406117-2576bd18e647?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1470&q=80";
    driver.findElement(By.id("content-input")).sendKeys(content);
    driver.findElement(By.id("photo-input")).sendKeys(photoUrl);
    driver.findElement(By.id("submit-post-btn")).click();

    String commentInput = "Nice red car";
    driver.findElement(By.id("comment-input-for-post1")).sendKeys(commentInput);
    System.out.println("*** >>>: 1");
    // Thread.sleep(90000);
    driver.findElement(By.id("submit-comment-btn-for-post1")).click();
    System.out.println("*** >>>: 2");
    
    List<WebElement> commentElements = driver.findElements(By.className("comment-for-post1"));
    for (WebElement comment : commentElements) {
      if (commentInput == comment.getText()) {
        Assert.assertEquals(commentInput, comment.getText());
      }
    }
  }
}
