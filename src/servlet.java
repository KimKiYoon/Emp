import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servlet() {
        super();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String cmd=request.getParameter("cmd");
		int empno=Integer.parseInt(request.getParameter("empno"));
		
		dao dao=new dao();
		
		if(cmd.equals("select1")){
			//single row
		} else if (cmd.equals("select2")) {
			//multi row
		} else if (cmd.equals("insert")){
			//insert.jsp
		} else if (cmd.equals("detail")){
			//detail.jsp
		} else if (cmd.equals("update")){
			//update.jsp
			String ename=request.getParameter("ename");
			String job=request.getParameter("job");
			int mgr=Integer.parseInt(request.getParameter("mgr"));
			String hiredate=request.getParameter("hiredate");
			int sal=Integer.parseInt(request.getParameter("sal"));
			int comm=Integer.parseInt(request.getParameter("comm"));
			int deptno=Integer.parseInt(request.getParameter("deptno"));
			
			int result=dao.doUpdate(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			
			//디스패쳐/or js 경고창 처리
			if (result!=0){
				out.println("<script>");
				out.println("alert('업데이트 성공!')");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('실패!')");
				out.println("</script>");
			}
		} else if (cmd.equals("delete")){
			//delete
		} else {
			//뭐한거니?
		}
		
		out.close();
	}
}
