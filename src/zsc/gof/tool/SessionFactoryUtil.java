package zsc.gof.tool;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import javax.management.relation.Role;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class SessionFactoryUtil {
	private static SqlSessionFactory sqlSessionFactory = null;
	private static Reader reader = null;
	
	private SessionFactoryUtil() {
	}
	
	//�������ʱ��ȡ�������ļ�
	static {
		//String resource = "mybatis.xml";
		//InputStream inputStream = Resources.getResourceAsStream(resource);
		try {
			reader = Resources.getResourceAsReader("config/mybatis.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//����SqlSessionFactory�����������������Ǵ���SqlSession����
	private static SqlSessionFactory getSessionFactory() {
		if (sqlSessionFactory == null)
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//build(inputStream)
		return sqlSessionFactory;
	}
	
	public static SqlSession getSession() {
		return getSessionFactory().openSession();
	}
	
	
		
		//�������ݿ����ӳ�
		//PooledDataSource dataSource = new PooledDataSource();
		//dataSource.setDriver("com.mysql.jdbc.Driver");
		//dataSource.setUrl("jdbc:mysql://localhost:3306/myschool");
		//dataSource.setUsername("root");
		//dataSource.setPassword("111111");
		
		//�������ݿ�����ʽ
		//TransactionFactory transactionFactory = new JdbcTransactionFactory();
		//Environment environment = new Environment("development", transactionFactory, dataSource);
		//Configuration configuration = new Configuration(environment);
		//configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
		//configuration.addMapper()
		//sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
}
