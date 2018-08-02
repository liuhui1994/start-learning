package org.business.system.common.model;

import org.business.system.common.em.MenuType;

import javax.persistence.Table;

@Table(name="t_system_menu")
public class Menu {
	
	private Long id;
	
	private String menuNmae;
	
	private MenuType menuType;
	
	private Long parnetId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuNmae() {
		return menuNmae;
	}

	public void setMenuNmae(String menuNmae) {
		this.menuNmae = menuNmae;
	}

	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	public Long getParnetId() {
		return parnetId;
	}

	public void setParnetId(Long parnetId) {
		this.parnetId = parnetId;
	}
	
	

}
