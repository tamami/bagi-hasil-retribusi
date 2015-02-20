package lab.aikibo.services;

import java.io.Serializable;

import lab.aikibo.entity.User;

public class UserInfoServiceImpl implements UserInfoService, Serializable {

	private static final long serialVersionUID = -6863663601439075742L;

	@Override
	public User findUser(String account) {
		// nothing todo, because was handled by authentication
		return null;
	}

	@Override
	public User updateUser(User user) {
		// nothing todo, because was handled by authentication
		return null;
	}

}
