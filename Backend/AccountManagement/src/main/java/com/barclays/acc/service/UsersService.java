package com.barclays.acc.service;

public interface UsersService {
	public boolean changePassword(int userid, String password, String newpassword);
	public boolean login(int userid, String password, int roleid);
}
