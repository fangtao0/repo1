package cn.kgc.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.kgc.pogo.Users;

public interface UsersDao {
	
	//��ȡ������
	public int getCount();
	@Select("select * from users")
	public List<Users> getUsers();
	
	
}
