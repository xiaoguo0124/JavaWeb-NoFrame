package coursemanage.stuscore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.entity.StuScore;
import com.zr.coursemanage.service.StuScoreService;
import com.zr.coursemanage.service.StuScoreServiceImp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetAllStuScore
 */
@WebServlet("/GetAllStuScore")
public class GetAllStuScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllStuScore() {
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
		StuScoreService ss=new StuScoreServiceImp();
		List<StuScore> slist=ss.getAllStuScore();
		
		JSONObject obj=new JSONObject();
		JSONArray arr=new JSONArray();
		
		for (StuScore s : slist) {
			obj.put("stuno", s.getStuno());
			obj.put("cname", s.getCname());
			obj.put("stuscore", s.getStuscore());
			
			arr.add(obj);
		}
		
		PrintWriter out=response.getWriter();
		out.println(arr);
		
		
	}

}
