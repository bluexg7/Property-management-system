import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.connect.DB_Con;


public class selectChange2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		
		Connection con = DB_Con.getCon();
		ResultSet rs = null;
		Statement st = null;
		
		String com_name = request.getParameter("com_name");
		com_name = java.net.URLDecoder.decode(com_name, "UTF-8");
		String build_num = request.getParameter("build_num");
		build_num = java.net.URLDecoder.decode(build_num, "UTF-8");
		
		try{
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    String sql = "select distinct r.unit_num unit_num from community c,room r where c.num=r.com_num and c.name='" + com_name + "' and build_num='" + build_num+"' order by unit_num";
			rs = st.executeQuery(sql);
			
			System.out.println(sql);
			
			rs.last(); 
			int rowCount = rs.getRow(); 
			rs.beforeFirst(); 
			
			response.setContentType("text/html; charset=GBK");   
			PrintWriter out = response.getWriter(); 
	
			out.println("document.getElementById('unit_num').length=" + (rowCount+1));  
			out.println("document.getElementById('unit_num').selectedIndex = 0");
			int i = 1;
			while(rs.next()){  			
				out.println("document.getElementById('unit_num').options[" + i + "].value = '" + rs.getString("unit_num").trim() + "'");
				out.println("document.getElementById('unit_num').options[" + i + "].text = '" + rs.getString("unit_num").trim() + "'");  
			    i++;
		    }
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Con.close(rs, st, con);
		}
		
	}

}
