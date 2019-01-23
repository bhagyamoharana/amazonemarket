package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.SearchDAO;
import model.SearchProduct;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String keyword = request.getParameter("searchProduct");
		
			
		//ArrayList<SearchProduct> results = SearchDAO.instance.getSearchedParameter(keyword);
		
		 SearchProduct sp =new SearchProduct();
		 sp= SearchDAO.instance.getSearchedParameter(keyword);
		String a = sp.GetProductName();
		System.out.println(a);
		
		request.setAttribute("product_Name", a);
			System.out.println("This is from the servlet" + a);
		request.getRequestDispatcher("Search.jsp").forward(request, response);
			
		}
		
	    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		//String name = request.getParameter("name");
		
		//Name A_Name = new Name(name);
		//NameDAO.instance.saveFirstName(A_Name);
		
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
