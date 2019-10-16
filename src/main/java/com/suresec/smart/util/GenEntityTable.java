package com.suresec.smart.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * 
 * @author wcc
 * @time 2019-10-11 10:55
 * @description 根据表生成实体类
 */
public class GenEntityTable {
	
	/**
	 * 这里是Oracle连接方法
	 *private static final String driver = "oracle.jdbc.driver.OracleDriver";
	 *private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	 *private static final String uid = "system";
	 *private static final String pwd = "sys";
	 *这里是SQL Server连接方法
	 *private static final String url = "jdbc:sqlserver://localhost:1433;DateBaseName=数据库名";
	 *private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
	 *private static final String uid = "sa";
	 *private static final String pwd = "sa";
	 *
	 *
	 * 这里是MySQL连接方法
	 */
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String pwd="123456";
	private static final String user="root";
	private static final String url = "jdbc:mysql://localhost:3306/cc3" + "?user=" + user + "&password=" + pwd + "&useUnicode=true&characterEncoding=UTF-8";
	private static String[] tablename = null;//null;//{"sys_users","sys_roles","sys_menus","sys_roles_menus","sys_users_roles","sys_logs"};// 表名
	
	private static String setpackage="com.suresec.smart.entity";//你的实体类所在的包的位置
	
	private static Connection getConnection=null;
	
	public static void main(String[] args) {
		File temp = new File("");
		String path = temp.getAbsolutePath() + "/src/main/java/" + setpackage.replace(".", "/");
		getConnection=getConnections();
		try {
			DatabaseMetaData dbmd=getConnection.getMetaData();
		    ResultSet resultSet = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });
		    
		    while (resultSet.next()) {
		    	String tableName=resultSet.getString("TABLE_NAME");
		    	//ResultSet rs =getConnection.getMetaData().getColumns(null, getXMLConfig.getSchema(),tableName.toUpperCase(), "%");//其他数据库不需要这个方法的，直接传null，这个是oracle和db2这么用
	    		ResultSet rs1 = dbmd.getColumns(null, "%", tableName, "%");
	    		//ResultSet rs2 = dbmd.getColumns(null, "%", tableName, "%");
		    	//System.out.println(tableName);
		    	if(tablename == null) {//生成所有
		    		createFile(path,tableName,rs1);
			    }else if(Arrays.asList(tablename).contains(tableName)){//这里干掉IF可对库里面所有表直接生成tableName
			    	createFile(path,tableName,rs1);
			    }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public static void createFile(String path,String tableName,ResultSet rs1) throws SQLException, IOException{
		File directory = new File(path+"\\"+ initcap(tableName)+".java");
		FileWriter fw = new FileWriter(directory);
		PrintWriter pw = new PrintWriter(fw);
		pw.write("package "+setpackage+";\r\n");

		pw.write("import javax.persistence.Entity;\r\n");
		//pw.write("import javax.persistence.GeneratedValue;\r\n");
		//pw.write("import javax.persistence.GenerationType;\r\n");
		//pw.write("import javax.persistence.Id;\r\n");
		pw.write("import javax.persistence.Table;\r\n");
		
		pw.write("import lombok.Data;\r\n");
		pw.write("/**\r\n");
		pw.write("* " + tableName + " 实体类\r\n");
		pw.write("* " + getDate()+ " wcc\r\n");
		pw.write("*/ \r\n");
		pw.write("@Entity\r\n");
		pw.write("@Table(name=\""+tableName+"\")\r\n");
		pw.write("@Data\r\n");
		pw.write("public class " + initcap(tableName) + "{\r\n");
		System.out.println(tableName+"表生成");
		while(rs1.next()){
			String type = sqlType2JavaType(rs1.getString("TYPE_NAME"));
			String name = rs1.getString("COLUMN_NAME");
			String remark = rs1.getString("REMARKS");
			createPrtype(pw,type,name,remark);
		}
		//提供Get和Set方法
//		pw.write("\r\n");
//		while(rs2.next()){
//			String name = rs2.getString("COLUMN_NAME");
//			String type = rs2.getString("TYPE_NAME");
//			createMethod(pw,type,name);
//		}
		pw.write("}\r\n");
		
		pw.flush();
		pw.close();
	}
	
	/**生成属性*/
	public static void createPrtype(PrintWriter pw,String type,String name,String remark){
		if(remark!=null && !"".equals(remark)){
			pw.write("\t/**\r\n");
			pw.write("\t*"+remark+"\r\n");
			pw.write("\t*/\r\n");
		}else{
			pw.write("\t//"+name+"\r\n");
		}
		pw.write("\tprivate " +type+" "+name+";\r\n");
	}
	
	/**生成方法*/
	public static void createMethod(PrintWriter pw,String type,String name){
		pw.write("\tpublic void set " + initcap(name) + "("+ sqlType2JavaType(type) + " " + name+ "){\r\n");
		pw.write("\t\tthis." + name + "=" + name + ";\r\n");
		pw.write("\t}\r\n");
		pw.write("\tpublic " + sqlType2JavaType(type) + " get "+ initcap(name) + "(){\r\n");
		pw.write("\t\treturn " + name + ";\r\n");
		pw.write("\t}\r\n");
		pw.write("\r\n");
	}
	
	
	// 创建数据库连接
	public static Connection getConnections() {
		try {
			Class.forName(driver);
			getConnection = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getConnection;
	}
 
	// 将单词字母首字母改为大写
	private static String initcap(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}
 
	// 判断属性类型
	public static String sqlType2JavaType(String sqlType) {
		String str = null;
		if (sqlType.equalsIgnoreCase("bit")) {
			str = "boolean";
		} else if (sqlType.equalsIgnoreCase("tinyint")) {
			str = "byte";
		} else if (sqlType.equalsIgnoreCase("smallint")) {
			str = "short";
		} else if (sqlType.equalsIgnoreCase("int")) {
			str = "int";
		} else if (sqlType.equalsIgnoreCase("bigint")) {
			str = "long";
		} else if (sqlType.equalsIgnoreCase("float")) {
			str = "float";
		} else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
				|| sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
				|| sqlType.equalsIgnoreCase("smallmoney")) {
			str = "double";
		} else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
				|| sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
				|| sqlType.equalsIgnoreCase("text")) {
			str = "String";
		} else if (sqlType.equalsIgnoreCase("datetime")) {
			str = "String";
		} else if (sqlType.equalsIgnoreCase("image")) {
			str = "Blod";
		}
		return str;
	}
 
	// 获取格式化后的时间
	private static String getDate() {
		String time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time = sdf.format(new Date());
		return time;
	}
 
}
