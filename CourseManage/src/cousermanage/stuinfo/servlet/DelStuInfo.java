package cousermanage.stuinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.service.StuInfoService;
import com.zr.coursemanage.service.StuInfoServiceImp;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DelStuInfo
 */
@WebServlet("/DelStuInfo")
public class DelStuInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelStuInfo() {
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
		
		String stuno=request.getParameter("stuno");
		StuInfoService ss=new StuInfoServiceImp();
		
		JSONObject obj=new JSONObject();
		
		if(ss.delStuInfo(stuno)>0) {
			obj.put("del", "OK");
		}else {
			obj.put("del", "NG");
		}
		
		PrintWriter out=response.getWriter();
		out.println(obj);
		
		
	}

}
