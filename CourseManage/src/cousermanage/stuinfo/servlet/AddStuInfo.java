package cousermanage.stuinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.coursemanage.entity.StuInfo;
import com.zr.coursemanage.service.StuInfoService;
import com.zr.coursemanage.service.StuInfoServiceImp;

import net.sf.json.JSONObject;


@WebServlet("/AddStuInfo")
public class AddStuInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuno=request.getParameter("stuno");
		String stuname=request.getParameter("stuname");
		String stusex=request.getParameter("stusex");
		String stuage=request.getParameter("stuage");
		String stucourse=request.getParameter("stucourse");
		
		StuInfo stu=new StuInfo();
		stu.setStuno(stuno);
		stu.setStuname(stuname);
		stu.setStusex(stusex);
		stu.setStuage(Integer.parseInt(stuage));
		stu.setStucourse(stucourse);
		
		StuInfoService ss=new StuInfoServiceImp();
		JSONObject obj=new JSONObject();
		
		if(ss.addStuInfo(stu)>0) {
			obj.put("add", "OK");
		}else {
			obj.put("add", "NG");
		}
		
		PrintWriter out=response.getWriter();
		out.println(obj);
		
	}

}
