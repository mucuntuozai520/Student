package cn.DataSource.util;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtil {
	public static DataSource getDataSourceWithC3P0(){
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        try {
            c3p0.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        c3p0.setJdbcUrl("jdbc:mysql://localhost:3306/student");
        c3p0.setUser("root");
        c3p0.setPassword("root");

        return c3p0 ;
    }
	 public static DataSource getDataSourceWithC3P0ByXml(){
	        ComboPooledDataSource c3p0 = new ComboPooledDataSource("linfeng");
	        return c3p0 ;
	    }
}
