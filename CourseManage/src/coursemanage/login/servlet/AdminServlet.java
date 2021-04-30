package coursemanage.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.entity.Admin;
import com.zr.coursemanage.service.AdminServiceImp;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String upwd=request.getParameter("upwd");
		
		Admin a=new Admin();
		a.setUser(user);
		a.setUpwd(upwd);
		
		AdminServiceImp aimp=new AdminServiceImp();
		
		JSONObject obj=new JSONObject();
		if(aimp.getAdmin(a)) {
			obj.put("state", "OK");
		}else {
			obj.put("state", "NG");
		}
		
		PrintWriter out=response.getWriter();
		out.println(obj);
		
		
	}

}
