import org.junit.Assert;
import org.junit.Test;

import com.makersacademy.acebook.Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SignUpTest {

  private final TestService testService;

  @Autowired // dependency injection - auto-instantiate the class
  public SignUpTest(TestService testService) {
    this.testService = testService;
  }

  @Test
  public void successfulSignUpRedirectsToSignIn() {
    testService.signUp();
    
    String title = testService.driver.getTitle();
    Assert.assertEquals("Please sign in", title);
  }
}
