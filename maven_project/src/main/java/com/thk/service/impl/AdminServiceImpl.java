package com.thk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thk.dao.AdminDao;
import com.thk.dao.PrivDao;
import com.thk.dao.RoleDao;
import com.thk.entity.Admin;
import com.thk.entity.Priv;
import com.thk.entity.Role;
import com.thk.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDao adminDao ;
	@Autowired
	PrivDao privDao ;
	@Autowired
	RoleDao roleDao ;
	@Override
	public Admin checkUsernameAndPwd(Admin admin) {
		Admin admin2 = adminDao.selectAdminByAcnameAndApwd(admin); 
		if(admin2 != null) {
			List<Priv> lp = privDao.selectPrivsByAid(admin2);
			admin2.setLp(lp);
		}
		return admin2;
	}
	@Override
	public boolean updateApwd(Admin admin) {
		int i = adminDao.updatePwd(admin);
		return i > 0? true : false;
	}
	@Override
	public boolean updatePrsonalInformation(Admin admin) {
		int i = adminDao.updatePrsonalInformation(admin);
		return i > 0? true : false;
	}
	@Override
	public List<Admin> selectAllAdmin() {
		List<Admin> allAdmin = adminDao.selectAllAdmin();
		List<Admin> newAllAdmin = new ArrayList<>();
		if (allAdmin != null) {
			for (Admin admin : allAdmin) {	
				List<Role> lr = roleDao.selectRoleByAid(admin);	
				admin.setLr(lr);	
				newAllAdmin.add(admin);	
			}
		}
		return newAllAdmin;
	}
	@Override
	public Admin selctAdminById(int aid) {
		Admin admin = adminDao.selectAdminById(aid);
		List<Role> lr = roleDao.selectRoleByAid(admin);
		admin.setLr(lr);
		return admin;
	}
}
