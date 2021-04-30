package coursemanage.courseinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.service.CourseInfoService;
import com.zr.coursemanage.service.CourseInfoServiceImp;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DelCourseInfo
 */
@WebServlet("/DelCourseInfo")
public class DelCourseInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCourseInfo() {
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
		String cno=request.getParameter("cno");
		CourseInfoService cs=new CourseInfoServiceImp();
		
		JSONObject obj=new JSONObject();
		
		if(cs.delCourseInfo(cno)>0) {
			obj.put("del", "OK");
		}else {
			obj.put("del", "NG");
		}
		
		PrintWriter out=response.getWriter();
		out.println(obj);
	}

}
