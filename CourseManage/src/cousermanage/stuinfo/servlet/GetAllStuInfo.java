package cousermanage.stuinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.entity.StuInfo;
import com.zr.coursemanage.service.StuInfoService;
import com.zr.coursemanage.service.StuInfoServiceImp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetAllStuInfo
 */
@WebServlet("/GetAllStuInfo")
public class GetAllStuInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllStuInfo() {
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
		
		StuInfoService ss=new StuInfoServiceImp();
		List<StuInfo> stulist=ss.getStuInfoAll();
		
		JSONObject obj=new JSONObject();
		JSONArray arr=new JSONArray();
		
		for (StuInfo s : stulist) {
			obj.put("stuno", s.getStuno());
			obj.put("stuname", s.getStuname());
			obj.put("stusex", s.getStusex());
			obj.put("stuage", s.getStuage());
			obj.put("stucourse", s.getStucourse());
			
			arr.add(obj);
		}
		
		PrintWriter out=response.getWriter();
		out.println(arr);
		
	}

}
