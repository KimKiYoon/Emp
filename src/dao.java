import java.sql.PreparedStatement;

public class dao {
	
	//update: update 함수만
	public int doUpdate(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int deptno){
		int resultrow = 0;
			try{ 
	        
	    		PreparedStatement  pstmt = null;
	            String sql = "update Emptset set ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? where id=?"; 

	            PreparedStatement ps = con.prepareStatement(sql); 
	            ps.setString(1,ename);
	            ps.setString(2, job);
	            ps.setInt(3, mgr);
	            ps.setString(4, hiredate);
	            ps.setInt(5, sal);
	            ps.setInt(6, comm);
	            ps.setInt(7, deptno);
	            ps.setInt(8, empno);
	             
	            resultrow =ps.executeUpdate(); 
	           
	            if(ps!=null) ps.close(); 
	        } catch(Exception e){ 
	           System.out.println(e.getMessage());
	        } 
		return resultrow;
	}
}
