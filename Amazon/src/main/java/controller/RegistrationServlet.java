package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserRegDAO;
import model.UserRegistrationBean;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String fullName = request.getParameter("userFullName");
		 System.out.println("Full name of user is "+fullName);
		 
		 String emailI = request.getParameter("email");
			System.out.println("email entered is"+emailI);
		 
		String userName = request.getParameter("username");
		System.out.println("username entered is"+userName);
		
		 String password1 = request.getParameter("password1");
		 System.out.println("password1 entered is"+password1);
		 
		 String password2 = request.getParameter("password2");
		 System.out.println("password2 entered is"+password2);
		 
		 UserRegistrationBean loginBean = new UserRegistrationBean(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
		  System.out.println("the password one entered is :" +password1);
		  System.out.println("the password two enetered is :" +password2);
		  if(password1.equals(password2)){
			  
		  
		 
		 loginBean.setUserfullName(fullName);
		 loginBean.setEmail(emailI);
		 loginBean.setUserName(userName); //setting the username and password through the loginBean object then only you can get it in future.
		  loginBean.setPassword1(password1);
		  loginBean.setPassword2(password2);
		
		  
		  String data1=loginBean.getUserfullName();
		  String data2= loginBean.getPassword1();
		  System.out.println("the entered values is bean class are"+data1+"    "+data2);
		
		  
		  UserRegDAO dao = new UserRegDAO();
		  Boolean emailid = dao.emailIDExists(emailI);
		  System.out.println("the boolean value of email id existing in the database is "+emailid);
		 
		  String successinsert = dao.addUserdetailsinDB(loginBean);
		  if(successinsert.equals("Successfully Inserted"))
		  {
			  request.setAttribute("userName", userName); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
			  request.getRequestDispatcher("/index.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
			  }
			  else
			  {
			  request.setAttribute("errMessage", successinsert); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
			  request.getRequestDispatcher("/register.jsp").forward(request, response);//forwarding the request
			  }
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
		  else {
			  response.setContentType("text/html;charset=UTF-8");
			  PrintWriter out = response.getWriter();
			  out.println("<script type=\"text/javascript\">");
		       out.println("alert('User or password incorrect');");
		       out.println("</script>");
		       response.sendRedirect("register.jsp"); 
		  }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out=response.getWriter();
         String emailid=request.getParameter("email");
         UserRegDAO dao = new UserRegDAO();
		  Boolean emailiiid = dao.emailIDExists(emailid);
		  System.out.println("the boolean value of email id existing in the database in post method is "+emailid);
		  if(emailid.equals(true)) {
			  out.println("<script type=\"text/javascript\">");
			  out.println("<font color=red>");
		       out.println("alert('User emailid already exists');");
		       out.println("</script>");
		  }
		doGet(request, response);
	}

}
