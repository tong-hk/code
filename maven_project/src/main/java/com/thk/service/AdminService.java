package com.thk.service;

import java.util.List;

import com.thk.entity.Admin;

public interface AdminService {
	/**
	 * ��¼����ѯ�˺�����
	 * @param admin
	 * @return
	 */
	Admin checkUsernameAndPwd(Admin admin);
	
	/**
	 * �޸�����
	 * @param admin
	 * @return
	 */
	boolean updateApwd(Admin admin);
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param admin
	 * @return
	 */
	boolean updatePrsonalInformation(Admin admin);
	
	/**
	 * ��ѯ���й���Ա��Ϣ
	 * @return
	 */
	List<Admin> selectAllAdmin();
	
	/**
	 * ����aid��ѯadmin
	 * @param aid
	 * @return
	 */
	Admin selctAdminById(int aid);
}	
