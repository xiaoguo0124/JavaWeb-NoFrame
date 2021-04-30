package coursemanage.courseinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.entity.CourseInfo;
import com.zr.coursemanage.service.CourseInfoService;
import com.zr.coursemanage.service.CourseInfoServiceImp;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddCourseInfo
 */
@WebServlet("/AddCourseInfo")
public class AddCourseInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseInfo() {
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
		String cname=request.getParameter("cname");
		String tno=request.getParameter("tno");
		
		CourseInfo ci=new CourseInfo();
		ci.setCno(cno);
		ci.setCname(cname);
		ci.setTno(tno);
		
		CourseInfoService cs=new CourseInfoServiceImp();
		JSONObject obj=new JSONObject();
		
		if(cs.addCourseInfo(ci)>0) {
			obj.put("add","OK");
		}else {
			obj.put("add", "OK");
		}
		
		PrintWriter out=response.getWriter();
		out.println(obj);
		
	}

}
