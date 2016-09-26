import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UTILS.Singleton_ConnectionHelper;

public class Dao {
	
	Connection conn = null;
	public Dao(){
		conn = Singleton_ConnectionHelper.getConnection("oracle");
	}
	PreparedStatement ps = null;
	
	public ArrayList<Dto> doSelectMult(){
		ArrayList<Dto> list = new ArrayList<Dto>();
		try{
			String sql = "select empno ,ename, job, mgr, hiredate, sal, comm, deptno from emptset";
			ps = conn.prepareStatement(sql);
			ResultSet  rs = ps.executeQuery(); 
			while (rs.next()){
				Dto dto = new Dto();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				list.add(dto);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	//문수형 코드
	public Dto selectSingle(String empno){
	      String sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno"
	            + " from emptset where empno = ?";
	      Dto dto = null;
	      try{
	    	  ps = conn.prepareStatement(sql);
	    	  ps.setString(1, empno);
	         
	    	  ResultSet rs = ps.executeQuery();
	         
	         while(rs.next()){
	            dto = new Dto();
	            dto.setEmpno(rs.getInt("empno"));
	            dto.setEname(rs.getString("ename"));
	            dto.setJob(rs.getString("job"));
	            dto.setMgr(rs.getInt("mgr"));
	            dto.setHiredate(rs.getString("hiredate"));
	            dto.setSal(rs.getInt("sal"));
	            dto.setComm(rs.getInt("comm"));
	            dto.setDeptno(rs.getInt("deptno"));
	            
	         }
	         rs.close();
	         ps.close();
	         
	      }catch(Exception e){
	         System.out.println("dao error"+e.getMessage());
	      }
	      
	      return dto;
	   }
	
	 //detail 한종이 형 코드
	   public Dto detail(int empno){
	      Dto d=new Dto();
	      
	      PreparedStatement pstmt = null;
	      ResultSet rs=null;
	        String sql = "select ename, job, mgr, hiredate, sal, comm, deptno where empno=?"; 
	        PreparedStatement ps;
			try {
				ps = conn.prepareStatement(sql);
	        
	        ps.setInt(1,empno);
	        rs=ps.executeQuery(); 
	       
	        if(ps!=null) ps.close(); 
	        System.out.println(rs.getString(1));
	      d.setEmpno(empno);
	      d.setEname(rs.getString(1));
	      d.setJob(rs.getString(2));
	      d.setMgr(rs.getInt(3));
	      d.setHiredate(rs.getString(4));
	      d.setSal(rs.getInt(5));
	      d.setComm(rs.getInt(6));
	      d.setDeptno(rs.getInt(7));
	      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	      return d;
	   }
	   
	   //update: update 함수만 
	   public int doUpdate(int empno, String ename, String job, int mgr, int sal, int comm, int deptno){
	      int resultrow = 0;
	         try{ 
	           
	            // PreparedStatement  pstmt = null;
	               String sql = "update Emptset set ename=?, job=?, mgr=?, sal=?, comm=?, deptno=? where empno=?"; 
	               //System.out.println("ㅎㅎㅎ");
	               PreparedStatement ps = conn.prepareStatement(sql); 
	               ps.setString(1,ename);
	               ps.setString(2, job);
	               ps.setInt(3, mgr);
	              
	               ps.setInt(4, sal);
	               ps.setInt(5, comm);
	               ps.setInt(6, deptno);
	               ps.setInt(7, empno);
	               //System.out.println(empno); 
	               resultrow =ps.executeUpdate(); 
	              
	               if(ps!=null) ps.close(); 
	           } catch(Exception e){ 
	              System.out.println(e.getMessage());
	           } 
	      return resultrow;
	   }
	   
	   //한솔이 코드
	   public int doInsert(Dto dto){
		      int resultrow=0;
		      
		      try{
		            String sql = "insert into Emptset (empno, ename, job, mgr, sal, comm, deptno) values(?,?,?,?,?,?,?)";   
		            PreparedStatement ps = null;
		          
		            ps = conn.prepareStatement(sql);
		                    
		            ps.setInt(1, dto.getEmpno());
		            ps.setString(2, dto.getEname());
		            ps.setString(3, dto.getJob());
		            ps.setInt(4, dto.getMgr());
		            ps.setInt(5, dto.getSal());
		            ps.setInt(6, dto.getComm());
		            ps.setInt(7, dto.getDeptno());
		            
		            resultrow = ps.executeUpdate();
		            System.out.println("resultrow :" +resultrow);   
		            ps.close();
		            
		         }catch(Exception e){
		           e.printStackTrace();
		         }
		            
		      return resultrow;
		   }
	   
	   //지율누나 코드
	   public int deletedto(String Empno){
		      int row = 0;
		      PreparedStatement pstmt = null;
		       
		      try{         
		         
		         String sql="delete from Emptset where empno=?"; 
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1,Empno);
		            row = pstmt.executeUpdate();
		            
		      } catch(Exception e){
		         e.getMessage();
		      }
		      
		      return row;
		      }
}
