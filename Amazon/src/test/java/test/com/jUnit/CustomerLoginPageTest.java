package test.com.jUnit;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.UserRegDAO;
import model.UserRegistrationBean;



class CustomerLoginPageTest {
	private UserRegDAO userreg = new UserRegDAO();

	//  User checks the appearance of labels Username, Password // Check the required fields by not filling any data
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		// Test if the User exists in the database
		String userName = "gidiyanm";
		String password = "Gidiyan1234";
		//assertEquals("User Exist in the Database", Adiobj.adminfind(adminUserName, adminPassword));
		 assertTrue(userreg.customerfind(userName, password));
	}
	@Test
	 void CorrectUsername() {
		// Check When Username is correct and invalid password
			String userName = "gidiyanm";
			String password = "Gidiyan123";
			assertFalse(userreg.customerfind(userName, password));
		
	}
	
	@Test
	 void CorrectPassword() {
		// Check When Password is correct and invalid Username
			String userName = "gidiyan";
			String password = "Gidiyan1234";
			assertFalse(userreg.customerfind(userName, password));
		
	}
	
	
	@Test
	 void CheckEmpty() {
		// Check When Username field and password field is required
			String userName = "";
			String password = "";
			assertFalse(userreg.customerfind(userName, password));
		
	}
	
	@Test
	 void CheckUserNameEmpty() {
		// Check When Username field and password field is required
			String userName = "";
			String password = "Gidiyan1234";
			assertFalse(userreg.customerfind(userName, password));
		
	}
	@Test
	 void CheckPasswordEmpty() {
		// Check When Username field and password field is required
			String userName = "gidiyan";
			String password = "";
			assertFalse(userreg.customerfind(userName, password));
		
	}
	
	
}