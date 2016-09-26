import java.sql.PreparedStatement;

public class dao {
	
	//update: update 함수만
	public int doUpdate(String empno){
		int resultrow = 0;
			try{ 
	        
	    		PreparedStatement  pstmt = null;
	            String sql = "update Emptset set ename, job, mgr, hiredate, sal, comm, deptno where id=?"; 

	            PreparedStatement ps = con.prepareStatement(sql); 
	            ps.setString(1,empno);       
	             
	            resultrow =ps.executeUpdate(); 
	           
	            if(ps!=null) ps.close(); 
	        } catch(Exception e){ 
	           System.out.println(e.getMessage());
	        } 
		return resultrow;
	}
}
