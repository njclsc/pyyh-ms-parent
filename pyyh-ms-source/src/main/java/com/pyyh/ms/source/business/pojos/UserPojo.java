package com.pyyh.ms.source.business.pojos;

public class UserPojo {
	private int id;
	private String account;
	private String password;
	private String newPassword;
	private String confirmPassword;
	private int organizationIndex;
	private String organizationCode;
	private String createAccount;
	private String modifyAccount;
	private String createDateTime;
	private String modifyDateTime;
	private boolean isLogin;
	private int page;
	private int rows;
	private int begin;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}

	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public int getOrganizationIndex() {
		return organizationIndex;
	}
	public void setOrganizationIndex(int organizationIndex) {
		this.organizationIndex = organizationIndex;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
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
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getCreateAccount() {
		return createAccount;
	}
	public void setCreateAccount(String createAccount) {
		this.createAccount = createAccount;
	}
	public String getModifyAccount() {
		return modifyAccount;
	}
	public void setModifyAccount(String modifyAccount) {
		this.modifyAccount = modifyAccount;
	}
	public String getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getModifyDateTime() {
		return modifyDateTime;
	}
	public void setModifyDateTime(String modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}
}
