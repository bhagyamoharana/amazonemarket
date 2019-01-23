package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.UserRegistrationBean;

public class UserRegDAO {
	

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String userNameDB = "";
		String passwordDB = "";
		static int counter = 0;

   public String validateUserdetailsforLogin(UserRegistrationBean loginBean)
   {
	   String userName = loginBean.getUserName(); //Keeping user entered values in temporary variables.
		String password = loginBean.getPassword1();
		try
			{
				con = DBConnection.createConnection(); //establishing connection
				/*statement = con.createStatement(); //Statement is used to write queries. Read more about it.
				resultSet = statement.executeQuery("select id,userId,password from user_table where userId=(?) and password=(?)"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
				*/
				String query = "select id,userId,password from user_table where userId=(?) and password=(?)";
				PreparedStatement   pst = con.prepareStatement(query);
					
					
					pst.setString(1,userName);
					pst.setString(2,password);
					resultSet=pst.executeQuery();
				while(resultSet.next()) // Until next row is present otherwise it return false
				{	
					userNameDB = resultSet.getString("userId"); //fetch the values present in database
					passwordDB = resultSet.getString("password");
					System.out.println("the values from database are" + userNameDB + "and password is " +passwordDB);
					String id=resultSet.getInt("id")+"";
					if(userName.equals(userNameDB) && password.equals(passwordDB))
						{	
							return id; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
						}
				}
			}
		catch(Exception e)
			{
				e.printStackTrace();
			}
							return "Invalid user credentials"; // Just returning appropriate message otherwise
}
	
public String addUserdetailsinDB(UserRegistrationBean loginBean)
   
   {
	   String pwd1=loginBean.getPassword1();
	   System.out.println(pwd1);
	   String pwd2=loginBean.getPassword2();
	   System.out.println(pwd2);
	   if(pwd1.equals(pwd2))
	   {
	 //  String query = "insert into  user_table values (?,?,?,?,?)";
	 // String query="INSERT INTO user_table VALUES(?,?,?,?,?)";
		   
   	try {
   		
   		   
   		    
   		 con = DBConnection.createConnection(); //establishing connection
   		String query = "insert into user_table (fullName, email,userId,password) values (?,?,?,?)";
		PreparedStatement   pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			
			
   		   
			
			pst.setString(1,loginBean.getUserfullName());
			pst.setString(2,loginBean.getEmail());
			pst.setString(3,loginBean.getUserName());
			pst.setString(4,loginBean.getPassword2());
			
			resultSet = pst.getGeneratedKeys();
	            if(resultSet != null && resultSet.next()){
	                System.out.println("Generated userserial Id: "+resultSet.getInt(1));
	            }
		
			
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	return "Successfully Inserted";
   }
	   else
	   {
		   return "Passwords do not match";
	   }
	   
   }

public boolean customerfind(String userName, String password){
	con = DBConnection.createConnection();
	try {
		
		// String sql = "SELECT * FROM DATABASE WHERE admin_username="+AdminName+";";
		PreparedStatement psmt = con
				.prepareStatement("SELECT * FROM USER_TABLE WHERE userId=(?) and password=(?)");
		psmt.setString(1, userName);
		psmt.setString(2, password);
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {

			return true;
		}
	} catch (Exception e) {
		// TODO: handle exception
	} 
	return false;
	
}

public boolean emailIDExists(String email) {
	con = DBConnection.createConnection();
	try {
		
		// String sql = "SELECT * FROM DATABASE WHERE admin_username="+AdminName+";";
		PreparedStatement psmt = con
				.prepareStatement("SELECT * FROM USER_TABLE WHERE email=(?) ");
		psmt.setString(1, email);
		
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			
			
			return true;
		}
	} catch (Exception e) {
		// TODO: handle exception
	} 
	return false;
}
}

