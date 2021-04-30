package coursemanage.zhuce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.entity.StuUser;
import com.zr.coursemanage.service.StuUserService;
import com.zr.coursemanage.service.StuUserServiceImp;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddStuUser
 */
@WebServlet("/AddStuUser")
public class AddStuUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStuUser() {
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
		
		StuUser su=new StuUser();
		su.setStuno(request.getParameter("user"));
		su.setStupwd(request.getParameter("upwd"));
		
		StuUserService sus=new StuUserServiceImp();
		JSONObject obj=new JSONObject();
		
		if(sus.addStuUser(su)>0) {
			obj.put("zhuce", "OK");
		}else {
			obj.put("zhuce", "NG");
		}
		
		PrintWriter out=response.getWriter();
		out.println(obj);
		
		
	}

}
