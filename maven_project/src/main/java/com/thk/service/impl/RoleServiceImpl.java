package com.thk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thk.dao.PrivDao;
import com.thk.dao.RoleDao;
import com.thk.entity.Priv;
import com.thk.entity.Role;
import com.thk.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDao roleDao = null;
	@Autowired
	PrivDao privDao = null;

	@Override
	public List<Role> selectAllRole() {
		List<Role> allRole = roleDao.selectAllRole();
		List<Role> newAllRole = new ArrayList<>();
		if (allRole != null) {
			for (Role role : allRole) {	//������ÿ����ɫ
				List<Priv> lp = privDao.selectPrivsByRid(role);	//ʹ��ÿ����ɫ��id��ѯ�����Ǳ������Ȩ��
				role.setLp(lp);	//����ѯ����Ȩ�޷�װ�����ԵĽ�ɫ
				newAllRole.add(role);	//��ӵ��Ȩ����Ϣ�Ľ�ɫװ���µļ��ϵ���
			}
		}
		return newAllRole;
	}

	@Override
	public boolean addRole(Role role) {
		int id = roleDao.addRole(role);
		if(id != -1) {//��ʾ��ȡidֵ�ɹ�
			role.setId(id);//��ӵ�role������
			roleDao.addRolePriv(role);//��ӹ�������
		}
		return id!=-1?true:false;
	}
	
	@Override
	public boolean deleteRole(int rid) {
		int i = roleDao.deleteRole(rid);
		int j = roleDao.deleteRolePriv(rid);
		return i+j>=2?true:false;
	}

	@Override
	public boolean updateRole(Role role) {
		// TODO Auto-generated method stub
		int i = roleDao.updateRole(role);
		int j = roleDao.deleteRolePriv(role.getId());
		int k = roleDao.addRolePriv(role);
		return i+j+k>=3?true:false;
	}
	@Override
	public Role getRoleById(int rid) {
		Role role = roleDao.selectRoleById(rid);
		List<Priv> lp = privDao.selectPrivsByRid(role);
		role.setLp(lp);
		return role;
	}
}