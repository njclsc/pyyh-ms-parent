package com.pyyh.ms.manager.business.pojos;

import java.util.List;

public class ModularMenuPojo {
	private int id;
	private String modularName;
	private int parentId;
	private int modularLevel;
	private int modularIndex;
	private String url;
	private String icon;
	private String uiName;
	private int isAction;
	private List<ModularMenuPojo> children;
	public List<ModularMenuPojo> getChildren() {
		return children;
	}
	public void setChildren(List<ModularMenuPojo> children) {
		this.children = children;
	}
	public int getId() {
		return id;
	}
	public int getIsAction() {
		return isAction;
	}
	public void setIsAction(int isAction) {
		this.isAction = isAction;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModularName() {
		return modularName;
	}
	public void setModularName(String modularName) {
		this.modularName = modularName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getModularLevel() {
		return modularLevel;
	}
	public void setModularLevel(int modularLevel) {
		this.modularLevel = modularLevel;
	}
	public int getModularIndex() {
		return modularIndex;
	}
	public void setModularIndex(int modularIndex) {
		this.modularIndex = modularIndex;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
}
