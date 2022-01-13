package com.pyyh.ms.manager.business.pojos;

public class ModularMenuRolePojo {
	private int id;
	private int roleIndex;
	private int modularIndex;
	private int organizationIndex;
	private int[] roleIndexes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleIndex() {
		return roleIndex;
	}
	public void setRoleIndex(int roleIndex) {
		this.roleIndex = roleIndex;
	}
	public int getModularIndex() {
		return modularIndex;
	}
	public int[] getRoleIndexes() {
		return roleIndexes;
	}
	public void setRoleIndexes(int[] roleIndexes) {
		this.roleIndexes = roleIndexes;
	}
	public void setModularIndex(int modularIndex) {
		this.modularIndex = modularIndex;
	}
	public int getOrganizationIndex() {
		return organizationIndex;
	}
	public void setOrganizationIndex(int organizationIndex) {
		this.organizationIndex = organizationIndex;
	}
}
