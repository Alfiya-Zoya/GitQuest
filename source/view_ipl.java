package iplproj;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class view_ipl
 */
@WebServlet("/view_ipl")
public class view_ipl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view_ipl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		String database = request.getParameter("subject");
		String level = request.getParameter("diff");
		int i=1;
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
			//stmt = null;
			rs = null;
			pstmt = null;
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "  <meta charset=\"utf-8\" />\r\n"
					+ "  <link rel=\"icon\" href=\"/favicon.ico\" />\r\n"
					+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n"
					+ "  <meta name=\"theme-color\" content=\"#000000\" />\r\n"
					+ "  <title>land</title>\r\n"
					+ "  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Inter%3A400%2C700\"/>\r\n"
					+ "  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro%3A400%2C700\"/>\r\n"
					+ "  <link rel=\"stylesheet\" href=\"view_papr.css\"/>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<div class=\"land-Tzr\">\r\n"
					+ "  <div class=\"basicbros-landing-page-GSW\">\r\n"
					+ "    <div class=\"abc\">\r\n"
					+ "    </div>\r\n"
					+ "    <div class=\"subcrition-page-1-Dea\">\r\n"
					+ "      <div class=\"auto-group-u2qi-fWa\">\r\n"
					+ "        <div class=\"auto-group-i46w-sMk\">\r\n"
					+ "          <div class=\"search-alt-2-1-wsQ\">\r\n"
					+ "          </div>\r\n"
					+ "          <div class=\"search-box-cTk\">\r\n"
					+ "            <p class=\"search-ehG\">Search</p>\r\n"
					+ "            <img class=\"vector-S7L\" src=\"vector.png\"/>\r\n"
					+ "          </div>\r\n"
					+ "        </div>\r\n"
					+ "        <img class=\"auto-group-d2bk-i4r\" src=\"auto-group-d2bk.png\"/>\r\n"
					+ "        <img class=\"user-circle-1-M7p\" src=\"user-circle-1.png\"/>\r\n"
					+ "      </div>\r\n"
					+ "      \r\n"
					+ "      <div class=\"auto-group-oc9x-Qrn\">\r\n"
					+ "        <p class=\"git-quest-hqt\">Question Bank</p>\r\n"
					+"<button onclick=\"window.location.href = 'func_ipl.html';\" id=\"btn1\" class='rectangle-6-6pi'>Back</button>"
					+ "        \r\n"
					+"<div class=\"div1\">\r\n" + 
					"        \r\n" + 
					"          <textarea id=\"w3review\" name=\"w3review\" rows=\"4\" cols=\"50\" class=\"ques1\">\r\n" 
					
					
					);
			rs = stmt.executeQuery("select * from "+level);
			while (rs.next())
	     {
	         String n = rs.getString("question");
	         out.println(" "+i+". "+" "+n);
	         i++;
	     }

		       out.println( "            </textarea>\r\n" + 
						"        </div>"+
		    		   "      </div>\r\n"
						+ "      \r\n"
						+ "    </div>\r\n"
						+ "    <img class=\"modern-elegant-photography-tree-circle-logo-2-jNa\" src=\"modern-elegant-photography-tree-circle-logo-2.png\"/>\r\n"
						+ "  </div>\r\n"
						+ "</div>\r\n"+"</ul>\r\n"+
					"</body>\r\n" + 
					"</html>");
		}
		       catch(Exception e)
			{
				System.out.println("Cannot connect to database " + e);
			}


	}

}