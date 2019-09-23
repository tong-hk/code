package com.thk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.thk.entity.Admin;
import com.thk.entity.Role;

@Repository
public interface RoleDao {
	/**
	 * ��ѯ���еĽ�ɫ
	 * @param aid
	 * @return
	 */
	@Select("select * from tc_role")
	List<Role> selectAllRole();
	
	/**
	 * ��ӽ�ɫ
	 * @return
	 */
	@Select("")
	int addRole(Role role);
	
	/**
	 * ��ӹ�����
	 * @param role
	 * @return
	 */
	@Select("")
	int addRolePriv(Role role);
	
	/**
	 * ɾ����ɫ
	 * @param rid
	 * @return
	 */
	@Select("")
	int deleteRole(int rid);
	/**
	 * ɾ��������
	 * @param rid
	 * @return
	 */
	@Select("")
	int deleteRolePriv(int rid);
	/**
	 * �޸Ľ�ɫ
	 * @param role
	 * @return
	 */
	@Select("")
	int updateRole(Role role);
	
	/**
	 * ����rid��ѯrole
	 * @param rid
	 * @return
	 */
	@Select("")
	Role selectRoleById(int rid);
	
	/**
	 * ����aid��ѯadmin�������Role
	 * @param aid
	 * @return
	 */
	@Select("select id,rname from tc_role where id in(select rid from tc_admin_role where aid ={id})")
	List<Role> selectRoleByAid(Admin admin);
}