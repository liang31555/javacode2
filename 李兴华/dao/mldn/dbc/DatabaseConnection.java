package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ����ר�Ÿ������ݿ��������رղ�������ʵ�����������ʱ����ζ��Ҫ�������ݿ�Ŀ���<br>
 * �����ڱ���Ĺ��췽����Ҫ�������ݿ��������������ݿ�����ȡ��
 * @author mldn
 *
 */
public class DatabaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn" ;
	private static final String DBUSER = "scott" ;
	private static final String PASSWORD = "tiger" ;
	private Connection conn = null ;
	/**
	 * �ڹ��췽������Ϊconn�������ʵ����������ֱ��ȡ�����ݿ�����Ӷ���<br>
	 * �������еĲ������ǻ������ݿ���ɵģ�������ݿ�ȡ�ò������ӣ���ôҲ����ζ�����еĲ���������ֹͣ��
	 */
	public DatabaseConnection() {
		try {
			Class.forName(DBDRIVER) ;
			this.conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD) ;
		} catch (Exception e) {	// ��Ȼ�˴����쳣�������׳������岻��
			e.printStackTrace();
		}
	}
	/**
	 * ȡ��һ�����ݿ�����Ӷ���
	 * @return Connectionʵ��������
	 */
	public Connection getConnection() {
		return this.conn ;
	}
	/**
	 * �������ݿ�Ĺر�
	 */
	public void close() {
		if (this.conn != null) {	// ��ʾ���ڴ��������Ӷ���
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
