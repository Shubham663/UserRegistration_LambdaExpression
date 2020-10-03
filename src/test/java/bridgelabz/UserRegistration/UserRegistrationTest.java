package bridgelabz.UserRegistration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UserRegistrationTest{
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String password;
	private boolean expected;
	private validateUser user;
	
	@Before
	public void init() {
		user = new validateUser();
	}
	
	public UserRegistrationTest(final String firstName,final String lastName,
			final String email, final String mobile,final String password, final boolean expected) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.expected = expected;
	}

	@Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][]{{"Shubham","Mittal","abc@yahoo.com","91 9876543210","abcS9@edff",true},
											{"Shubham","Mittal","abc-100@yahoo.com","91 9876543210","abcS9@edff",true},
											{"Shubham","Mittal","abc.100@yahoo.com","91 9876543210","abcS9@edff",true},
											{"Shubham","Mittal","abc111@yahoo.com","91 9876543210","abcS9e@dff",true},
											{"Shubham","Mittal","abc-100@abc.net","91 9876543210","abcS9ed@ff",true},
											{"Shubham","Mittal","abc.100@abc.com.au","91 9876543210","abcS@9edff",true},
											{"Shubham","Mittal","abc@1.com","91 9876543210","abcS9ed@ff",true},
											{"Shubham","Mittal","abc@gmail.com.com","91 9876543210","ab@cS9edff",true},
											{"Shubham","Mittal","abc+100@gmail.com","91 9876543210","abc@S9edff",true},
											{"Shubham","Mittal","abc","91 9876543210","abcS@9edff",false},
											{"Shubham","Mittal","abc@.com.my","91 9876543210","abc@S9edff",false},
											{"Shubham","Mittal","abc123@gmail.a","91 9876543210","ab@cS9edff",false},
											{"Shubham","Mittal","abc123@.com","91 9876543210","abcS9e@dff",false},
											{"Shubham","Mittal","abc123@.com.com","91 9876543210","abc@S9edff",false},
											{"Shubham","Mittal",".abc@abc.com","91 9876543210","abcS9ed@ff",false},
											{"Shubham","Mittal","abc()*@gmail.com","91 9876543210","abcS@9edff",false},
											{"Shubham","Mittal","abc@%*.com","91 9876543210","abcS9e@dff",false},
											{"Shubham","Mittal","abc..2002@gmail.com","91 9876543210","ab@cS9edff",false},
											{"Shubham","Mittal","abc.@gmail.com","91 9876543210","abcS9e@dff",false},
											{"Shubham","Mittal","abc@abc@gmail.com","91 9876543210","abcS@9edff",false},
											{"Shubham","Mittal","abc@gmail.com.1a","91 9876543210","abcS9@edff",false},
											{"Shubham","Mittal","abc@gmail.com.aa.au","91 9876543210","abc@S9edff",false}
							   });
	}
	
	
	@Test
	public void lastNameTest_True() {
		try {
		if(!user.validateLastName.validate(lastName))
			throw new UserValidationException("The last name is not valid");
		}catch(UserValidationException e){
			System.err.println("Execution stopped because " + e.getMessage());
		}
	}
	
	@Test
	public void firstNameTest() {
		try {
			if(!user.validateFirstName.validate(firstName))
				throw new UserValidationException("The first name is not valid");
			}catch(UserValidationException e){
				System.err.println("Execution stopped because " + e.getMessage());
			}
	}
	
	
	@Test
	public void emailTest() {
		try {
			if(this.expected != user.validateEmail.validate(email))
				throw new UserValidationException("The email is not valid");
			}catch(UserValidationException e){
				System.err.println("Execution stopped because " + e.getMessage());
			}
	}
	
	
	@Test
	public void phoneTest() {
		try {
			if(!user.validateMobile.validate(mobile))
				throw new UserValidationException("The mobile is not valid");
			}catch(UserValidationException e){
				System.err.println("Execution stopped because " + e.getMessage());
			}
	}
	
	
	@Test
	public void passwordTest() {
		try {
			if(!user.validatePassword.validate(password))
				throw new UserValidationException("The password is not valid");
			}catch(UserValidationException e){
				System.err.println("Execution stopped because " + e.getMessage());
			}
	}
	
}