package com.thk.service;

import java.util.List;

import com.thk.entity.Admin;

public interface AdminService {
	/**
	 * 登录：查询账号密码
	 * @param admin
	 * @return
	 */
	Admin checkUsernameAndPwd(Admin admin);
	
	/**
	 * 修改密码
	 * @param admin
	 * @return
	 */
	boolean updateApwd(Admin admin);
	
	/**
	 * 修改个人信息
	 * @param admin
	 * @return
	 */
	boolean updatePrsonalInformation(Admin admin);
	
	/**
	 * 查询所有管理员信息
	 * @return
	 */
	List<Admin> selectAllAdmin();
	
	/**
	 * 根据aid查询admin
	 * @param aid
	 * @return
	 */
	Admin selctAdminById(int aid);
}	
