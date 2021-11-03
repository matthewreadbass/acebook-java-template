import com.makersacademy.acebook.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class LogoutTest {

  private final TestService testService;

  public LogoutTest(TestService testService) {
    this.testService = new TestService();
  }

  @Test
  public void successfulLogoutDirectsToSignIn() {
    String randomName = testService.signUp();
    testService.signIn(randomName);
    testService.logOut();

    String title = testService.driver.getTitle();
    Assert.assertEquals("Please sign in", title);
  }
}
