package coursemanage.courseinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.entity.CourseInfo;
import com.zr.coursemanage.service.CourseInfoService;
import com.zr.coursemanage.service.CourseInfoServiceImp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetAllCourseInfo
 */
@WebServlet("/GetAllCourseInfo")
public class GetAllCourseInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllCourseInfo() {
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
		
		CourseInfoService cs=new CourseInfoServiceImp();
		List<CourseInfo> clist=cs.getAllCourseInfo();
		
		JSONObject obj=new JSONObject();
		JSONArray arr=new JSONArray();
		
		for (CourseInfo c : clist) {
			obj.put("cno", c.getCno());
			obj.put("cname", c.getCname());
			obj.put("tno", c.getTno());
			
			arr.add(obj);
		}
		
		PrintWriter out=response.getWriter();
		out.println(arr);
		
	}

}
