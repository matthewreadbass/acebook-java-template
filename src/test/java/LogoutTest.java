import com.makersacademy.acebook.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class LogoutTest {

  @Autowired // dependency injection - auto-instantiate the class
  private TestService testService;

  public LogoutTest() {

  }

  // public LogoutTest(TestService testService) {
  //   this.testService = testService;
  // }

  @Test
  public void successfulLogoutDirectsToSignIn() {
    String randomName = testService.signUp();
    testService.signIn(randomName);
    testService.logOut();

    String title = testService.driver.getTitle();
    Assert.assertEquals("Please sign in", title);
  }
}
