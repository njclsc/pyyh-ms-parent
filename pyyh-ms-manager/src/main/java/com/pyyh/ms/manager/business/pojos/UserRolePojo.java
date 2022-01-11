package com.pyyh.ms.manager.business.pojos;

public class UserRolePojo {
	private int id;
	private int organizationIndex;
	private int roleIndex;
	private int userIndex;
	private String organizationName;
	private String roleName;
	private String account;
	private int page;
	private int rows;
	private int begin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getOrganizationIndex() {
		return organizationIndex;
	}
	public void setOrganizationIndex(int organizationIndex) {
		this.organizationIndex = organizationIndex;
	}
	public int getRoleIndex() {
		return roleIndex;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setRoleIndex(int roleIndex) {
		this.roleIndex = roleIndex;
	}
	public int getUserIndex() {
		return userIndex;
	}
	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}
}
