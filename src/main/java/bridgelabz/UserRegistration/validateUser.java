package bridgelabz.UserRegistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Unit test for simple App.
 */
public class validateUser 
{
    private static final String FIRST_NAME_CHECK = "[A-Z]{1}[a-zA-Z0-9]{2,}";
    private static final String LAST_NAME_CHECK = "[A-Z]{1}[a-zA-Z0-9]{2,}";
    private static final String EMAIL_CHECK = "^[a-zA-Z0-9|_|-][a-zA-Z0-9|_|-|\\+]*(\\.)?[a-zA-Z0-9|_|-]{1,}\\@[0-9a-zA-Z]{1,}\\.[a-zA-Z]{2,}(\\.)?[a-zA-Z]*$";
    private static final String MOBILE_CHECK = "[1-9]{2}\\s[1-9]{1}[0-9]{9}";
//    private static final String PASSWORD_CHECK = "^(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}";
    private static final String PASSWORD_CHECK = "^(?=.*\\d)(?=.*[A-Z])(?=.*\\W)(?!.*\\W\\w*\\W)(?!.*\\s).{8,}$";
    
    UserValidator validateFirstName = (s) -> (Pattern.compile(FIRST_NAME_CHECK).matcher(s).matches()); 
    UserValidator validateLastName = (s) -> (Pattern.compile(LAST_NAME_CHECK).matcher(s).matches());
    UserValidator validateEmail = (s) -> (Pattern.compile(EMAIL_CHECK).matcher(s).matches());
    UserValidator validateMobile = (s) -> (Pattern.compile(MOBILE_CHECK).matcher(s).matches());
    UserValidator validatePassword = (s) -> (Pattern.compile(PASSWORD_CHECK).matcher(s).matches());
//    public boolean validateFirstName(String firstName) {
//    	Pattern pattern = Pattern.compile(FIRST_NAME_CHECK);
//    	Matcher matcher = pattern.matcher(firstName);
//    	return matcher.matches();
//    }
//    public boolean validateLastName(String lastName) {
//    	Pattern pattern = Pattern.compile(LAST_NAME_CHECK);
//    	Matcher matcher = pattern.matcher(lastName);
//    	return matcher.matches();
//    }
//    public boolean validateEmail(String email) {
//    	Pattern pattern = Pattern.compile(EMAIL_CHECK);
//    	Matcher matcher = pattern.matcher(email);
//    	return matcher.matches();
//    }
//    public boolean validateMobile(String mobile) {
//    	Pattern pattern = Pattern.compile(MOBILE_CHECK);
//    	Matcher matcher = pattern.matcher(mobile);
//    	return matcher.matches();
//    }
//    public boolean validatePassword(String password) {
//    	Pattern pattern = Pattern.compile(PASSWORD_CHECK);
//    	Matcher matcher = pattern.matcher(password);
//    	return matcher.matches();
//    }
}

@FunctionalInterface 
interface UserValidator {
	boolean validate(String s);
}
