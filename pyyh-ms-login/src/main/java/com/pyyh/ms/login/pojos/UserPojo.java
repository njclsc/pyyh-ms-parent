package com.pyyh.ms.login.pojos;

public class UserPojo {
	private int id;
	private String account;
	private String password;
	private int organizationId;
	private int roleIndex;
	private boolean isLogin = false;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public int getRoleIndex() {
		return roleIndex;
	}
	public void setRoleIndex(int roleIndex) {
		this.roleIndex = roleIndex;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
}
