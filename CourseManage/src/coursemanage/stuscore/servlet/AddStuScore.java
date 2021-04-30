package coursemanage.stuscore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.entity.StuScore;
import com.zr.coursemanage.service.StuScoreService;
import com.zr.coursemanage.service.StuScoreServiceImp;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddStuScore
 */
@WebServlet("/AddStuScore")
public class AddStuScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStuScore() {
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
		String cname=request.getParameter("cname");
		String stuscore=request.getParameter("stuscore");
		
		StuScore ss=new StuScore();
		ss.setStuno(stuno);
		ss.setCname(cname);
		ss.setStuscore(Integer.parseInt(stuscore));
		
		StuScoreService sss=new StuScoreServiceImp();
		JSONObject obj=new JSONObject();
		
		if(sss.addStuScore(ss)>0) {
			obj.put("add", "OK");
		}else {
			obj.put("add", "NG");
		}
		
		PrintWriter out=response.getWriter();
		out.println(obj);
		
	}

}
