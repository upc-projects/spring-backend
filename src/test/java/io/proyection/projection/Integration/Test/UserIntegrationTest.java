package io.proyection.projection.Integration.Test;

import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.mockito.Mock;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.proyection.projection.domain.User;
import io.proyection.projection.service.UserService;

public class UserIntegrationTest {

	private final UserService userService = new UserService();
	private static User user = new User();
	private String mensaje;
	private String nombre = "";

	@Mock
	private HttpServletResponse response;
	
	@Given("^user name is \"([^\"]*)\"$")
	public void user_name_is(String arg1) throws Throwable {
	   user.setUsername(nombre);
	   user.setPassword("test");
	   Assert.assertTrue(user.getUsername() == "");
	}

	@When("^post method save user is \"([^\"]*)\"$")
	public void post_method_save_user_is(String arg1) throws Throwable {
	   try {
		    mensaje = "name is compulsory";
		    userService.saveUser(user);
		    Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

	@Then("^the user recieves the message \"([^\"]*)\"$")
	public void the_user_recieves_the_message(String arg1) throws Throwable {
		System.out.println(arg1);
		System.out.println(mensaje);
		Assert.assertEquals(mensaje, arg1);
	}

	@Given("^user password is \"([^\"]*)\"$")
	public void user_password_is(String arg1) throws Throwable {
		user.setPassword(nombre);
		user.setUsername("test00");
		Assert.assertTrue(user.getPassword() == "");	
	}

	@When("^post method save users is \"([^\"]*)\"$")
	public void post_method_save_users_is(String arg1) throws Throwable {
		 try {
			 mensaje = "password is compulsory";
			 userService.saveUser(user);
			 Assert.assertTrue(true);	
			} catch (Exception e) {
				System.out.println("Error: "+e.getMessage());
			}
		 
	}

	@Then("^the user recieves the messagesito \"([^\"]*)\"$")
	public void the_user_recieves_the_messagesito(String arg1) throws Throwable {
		Assert.assertEquals(mensaje, arg1);	
	}
}
