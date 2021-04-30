package coursemanage.login.servlet;

//import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.entity.Admin;
import com.zr.coursemanage.entity.StuUser;
import com.zr.coursemanage.service.AdminServiceImp;
import com.zr.coursemanage.service.StuUserServiceImp;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("user");
		String pwd=request.getParameter("upwd");
		
		Admin a=new Admin();
		a.setUser(name);
		a.setUpwd(pwd);
		
		StuUser su=new StuUser();
		su.setStuno(name);
		su.setStuname(name);
		su.setStupwd(pwd);
		
		AdminServiceImp aimp=new AdminServiceImp();
		StuUserServiceImp simp=new StuUserServiceImp();
		
		JSONObject obj=new JSONObject();
		
		if(aimp.getAdmin(a)) {
			obj.put("admin", "OK");
		}else {
			obj.put("admin", "NG");
		}
		
		if(simp.getStuUser(su)) {
			obj.put("stuuser", "OK");
		}else {
			obj.put("stuuser", "NG");
		}
		
		PrintWriter out=response.getWriter();
		out.println(obj);
	}

}
