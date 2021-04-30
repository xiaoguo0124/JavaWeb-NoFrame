package coursemanage.zhuce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.entity.Admin;
import com.zr.coursemanage.service.AdminService;
import com.zr.coursemanage.service.AdminServiceImp;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddAdmin
 */
@WebServlet("/AddAdmin")
public class AddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Admin ad=new Admin();
		ad.setUser(request.getParameter("user"));
		ad.setUpwd(request.getParameter("upwd"));
		
		AdminService as=new AdminServiceImp();
		JSONObject obj=new JSONObject();
		
		if(as.addAdmin(ad)>0) {
			obj.put("zhuce", "OK");
		}else {
			obj.put("zhuce", "NG");
		}
		
		PrintWriter out=response.getWriter();
		out.println(obj);
		
	}

}
