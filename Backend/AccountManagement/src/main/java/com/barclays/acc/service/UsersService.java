package com.barclays.acc.service;

public interface UsersService {
	public boolean changePassword(int userid, String password);
	public boolean login(int userid, String password, int roleid);
}

