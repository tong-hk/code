package com.thk.service;

import java.util.List;

import com.thk.entity.Role;

public interface RoleService {
	/**
	 * 查询所有角色信息（包括角色被赋予的权限）
	 * @return
	 */
	List<Role> selectAllRole();
	
	/**
	 * 添加角色
	 * @return
	 */
	boolean addRole(Role role);
	
	/**
	 * 删除角色
	 * @param rid
	 * @return
	 */
	boolean deleteRole(int rid);
	
	/**
	 * 根据id查询角色信息
	 * @param rid
	 * @return
	 */
	Role getRoleById(int rid);
	
	/**
	 * 修改角色信息
	 * @param role
	 * @return
	 */
	boolean updateRole(Role role);

}
