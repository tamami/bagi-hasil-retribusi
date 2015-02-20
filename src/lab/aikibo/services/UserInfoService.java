package lab.aikibo.services;

import lab.aikibo.entity.User;

public interface UserInfoService {
	
	// find user by username 
	public User findUser(String account);
	
	// update user
	public User updateUser(User user);

}
