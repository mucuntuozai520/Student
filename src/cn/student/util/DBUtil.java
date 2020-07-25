package cn.student.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	public static PreparedStatement state = null ;
	public static Connection connection = null ;
	public static ResultSet rs = null ; 
	private static final String URL="jdbc:mysql://localhost:3306/student";
	private static final String user="root";
	private static final String password="root";
	//查询总数据量
	public static int getCount(String sql) {
		int count=-1;
		try {
			 state = createPreParedStatement(sql, null);
			  rs = state.executeQuery();
			  if(rs.next()) {
				 count= rs.getInt(1);
			  }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, state, connection);
		}
		return count;
	}
	//通用增删改
	public static int executeUpdate(String sql,Object[] params) {
		try {
			 
				state = createPreParedStatement(sql,params);
			  int count = state.executeUpdate() ;
			  if(count>0)
				  return 1 ;
			  else 
				  return 0 ;
			  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			  return 0 ;
		} catch (SQLException e) {
			e.printStackTrace();
			  return 0 ;
		}catch (Exception e) {
			e.printStackTrace();
			return 0 ;
		}
		finally {
			closeAll(null,state,connection);
		}
}
	//关闭
	public static void closeAll(ResultSet rs,Statement stmt,Connection connection)
	{
		try {
			if(rs!=null)rs.close();
			if(state!=null)state.close();
			if(connection!=null)connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}
		
	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.jdbc.Driver") ;
		 return  DriverManager.getConnection( URL,user,password ) ;
	}
	
	public static PreparedStatement createPreParedStatement(String sql,Object[] arr) throws ClassNotFoundException, SQLException {
		  state = getConnection() .prepareStatement( sql) ;
		  if(arr!=null ) {
			  for(int i=0;i<arr.length;i++) {
				  state.setObject(i+1, arr[i]);
			  }
		  }
		  return state;
	}
		//通用查询
		public static ResultSet executeQuery( String sql ,Object[] arr) {	
			try {
				state = createPreParedStatement(sql,arr);
				 rs =  state.executeQuery() ;
				  return rs ;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null ; 
			} catch (SQLException e) {
				e.printStackTrace();
				return null ; 
			}catch (Exception e) {
				e.printStackTrace();
				return null ; 
			}

		}
	
	
	
	
	
}
