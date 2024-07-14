package iplproj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class input_ipl
 */
@WebServlet("/input_ipl")
public class input_ipl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public input_ipl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String database = request.getParameter("subject");
		String level = request.getParameter("diff");
		String question = request.getParameter("ques");
		System.out.println(level+database);
		
		Connection conn;
		String userName;
		String url;
		String password;
		Statement stmt;
		ResultSet rs;
		PreparedStatement pstmt;
		conn = null;
		stmt = null;
		rs = null;
		pstmt = null;
		try
		{
			conn = null;
			userName = "root";
			password = "root";
			url = "jdbc:mysql://localhost:3306/"+database;
			Class.forName ("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,userName,password);
			System.out.println("Database connection established");
			stmt = conn.createStatement();
			stmt = null;
			rs = null;
			pstmt = null;
			String query = "insert into "+level+"(question) values(?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, question);
			pstmt.executeUpdate();
			response.sendRedirect("func_ipl.html");

		}
		catch(Exception e)
		{
			System.out.println("Cannot connect to database " + e);
		}
	}





}
