package com.thk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.thk.entity.Admin;
@Repository
public interface AdminDao {
	/**
	 * 登录功能
	 * @param admin
	 * @return
	 */
	@Select("select * from tc_admin where acname = #{acname} and apwd = #{apwd}")
	Admin selectAdminByAcnameAndApwd(Admin admin);
	/**
	 * 
	 * @param admin
	 * @return
	 */
	@Select("update  tc_admin set apwd =#{apwd} where id =#{id}")
	int updatePwd(Admin admin);
	
	/**
	 * 
	 * @param admin
	 * @return
	 */
	@Select("pdate  tc_admin set aname=#{acname} ,atel =#{atel},aemail =#{aemail} where id =#{id}")
	int updatePrsonalInformation(Admin admin);

	/**
	 * 
	 * @return
	 */
	@Select("select * from tc_admin")
	List<Admin> selectAllAdmin();

	/**
	 * 
	 * @param rid
	 * @return
	 */
	@Select("select * from tc_admin where id=")
	Admin selectAdminById(int aid);

}
