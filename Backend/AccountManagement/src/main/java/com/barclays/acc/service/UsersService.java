package com.barclays.acc.service;

public interface UsersService {
	public void changePassword(int userid, String password);
	public void login(int userid, String password, int roleid);
}
