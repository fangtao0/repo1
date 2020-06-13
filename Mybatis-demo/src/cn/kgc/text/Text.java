package cn.kgc.text;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.kgc.Dao.UsersDao;
import cn.kgc.pogo.Users;

public class Text {
	
	public static void main(String[] args) {
		SqlSessionFactory  sqlSessionFactory=null;
		SqlSession  session =null;
		//������ȡ�� ��ȡӳ���ļ�
		try {
			Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
			//���� �ܴ���session�Ķ���
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			
			sqlSessionFactory = builder.build(reader);
			//���� session
			  session = sqlSessionFactory.openSession();
			
			//��ѯ���� select one  ��Ҫ����ֵ�� sql�� ӳ���ļ� id
			//int result =session.selectOne("cn.kgc.Dao.UsersDao.getCount");
			  
			 // int result=session.getMapper(UsersDao.class).getCount();
			  List<Users>list=session.getMapper(UsersDao.class).getUsers();
			  for(Users user:list){
				  System.out.println(user);
			  }
			  
			  
			//System.out.println("��������"+result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// �ر���Դ �ȿ��ĺ��  �󿪵��ȹ�
			session.close();
		}
		
		
		
	}
}
