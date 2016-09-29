

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/servlet","/Servlet"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Servlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8"); 
	    response.setContentType("text/html;charset=UTF-8");
		String cmd = request.getParameter("cmd");
	    PrintWriter out=response.getWriter();
	  	Dao dao = new Dao();
	
		ArrayList<Dto> list;   
		if(cmd.equals("selectMult")){
			 list = dao.doSelectMult();
			 request.setAttribute("list", list);
			 RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
	    	dis.forward(request, response);
		}else if(cmd.equals("SelectSingle")){
	         String empno = request.getParameter("empno");
	      
	         Dto singlerow = dao.selectSingle(empno);
	      
	         request.setAttribute("singlerow", singlerow);         
	      
	         RequestDispatcher dis = request.getRequestDispatcher("selectsingle.jsp");
	         dis.forward(request, response);
	      } else if (cmd.equals("update")){
	    	  
	          //update.jsp
	    	  int empno=Integer.parseInt(request.getParameter("empno"));
	          String ename=request.getParameter("ename");   
	          String job=request.getParameter("job");	          
	          int mgr=Integer.parseInt(request.getParameter("mgr"));	        
	          //String hiredate=request.getParameter("hiredate");
	          //System.out.println(hiredate);
	          int sal=Integer.parseInt(request.getParameter("sal"));	        
	          int comm=Integer.parseInt(request.getParameter("comm"));	         
	          int deptno=Integer.parseInt(request.getParameter("deptno"));	    
	          int result=dao.doUpdate(empno, ename, job, mgr, sal, comm, deptno);
	          
	          
	          if (result!=0){
	             out.println("<script>");
	             out.println("alert('업데이트 성공!');");
	             out.println("location.href='AllSelect_main.html'");
	             out.println("</script>");
	          } else {
	             out.println("<script>");
	             out.println("alert('실패!');");
	             out.println("location.href='AllSelect_main.html'");
	             out.println("</script>");
	          }
	       } else if (cmd.equals("delete")){
	    	   String empno = request.getParameter("empno");
	    	      
	    	      //dao.deletedto(empno);
	    	      
	    	      PrintWriter pw = response.getWriter();
	    	      
	    	      if(dao.deletedto(empno) > 0){
	    	         pw.print("<script>alert('삭제 되었습니다.');");
	    	         pw.print("location.href = 'AllSelect_main.html'</script>");
	    	      }else{
	    	    	  out.println("<script>");
			             out.println("alert('삭제 실패!');");
			             out.println("location.href='AllSelect_main.html'");
			             out.println("</script>");
	    	      }
	       } else if(cmd.equals("insert")) {
	    		  int empno=Integer.parseInt(request.getParameter("empno"));
		          String ename=request.getParameter("ename");   
		          String job=request.getParameter("job");	          
		          int mgr=Integer.parseInt(request.getParameter("mgr"));	        
		          String hiredate=request.getParameter("hiredate");
		          int sal=Integer.parseInt(request.getParameter("sal"));	        
		          int comm=Integer.parseInt(request.getParameter("comm"));	         
		          int deptno=Integer.parseInt(request.getParameter("deptno"));
		          
		          System.out.println(empno+"/"+ename+"/"+job+"/"+mgr);
		           Dto dto=  new Dto(empno, ename, job, mgr, hiredate, sal, comm, deptno);
		           int result = dao.doInsert(dto);
		           if (result!=0){
			             out.println("<script>");
			             out.println("alert('가입 성공!');");
			             out.println("location.href='AllSelect_main.html'");
			             out.println("</script>");
			          } else {
			             out.println("<script>");
			             out.println("alert('실패!');");
			             out.println("location.href='AllSelect_main.html'");
			             out.println("</script>");
			          }
	       }

	   }
}
