package com.thk.service;

import java.util.List;

import com.thk.entity.Role;

public interface RoleService {
	/**
	 * ��ѯ���н�ɫ��Ϣ��������ɫ�������Ȩ�ޣ�
	 * @return
	 */
	List<Role> selectAllRole();
	
	/**
	 * ��ӽ�ɫ
	 * @return
	 */
	boolean addRole(Role role);
	
	/**
	 * ɾ����ɫ
	 * @param rid
	 * @return
	 */
	boolean deleteRole(int rid);
	
	/**
	 * ����id��ѯ��ɫ��Ϣ
	 * @param rid
	 * @return
	 */
	Role getRoleById(int rid);
	
	/**
	 * �޸Ľ�ɫ��Ϣ
	 * @param role
	 * @return
	 */
	boolean updateRole(Role role);

}
