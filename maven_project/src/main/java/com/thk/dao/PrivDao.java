package com.thk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.thk.entity.Admin;
import com.thk.entity.Priv;
import com.thk.entity.Role;


@Repository
public interface PrivDao {
	/**
	 * 
	 * @param aid
	 * @return
	 */
	@Select("select * from tc_priv where id in(select pid from tc_role_priv where rid in(select rid from tc_admin_role where aid = #{id}))")
	List<Priv> selectPrivsByAid(Admin admin);
	
	/**
	 * 
	 * @param aid
	 * @return
	 */
	@Select("select * from tc_priv where id in(select pid from tc_role_priv where rid =#{id})")
	List<Priv> selectPrivsByRid(Role role);
	
	/**
	 *
	 * @return
	 */
	@Select("select * from tc_priv")
	List<Priv> selectAllPriv();
}
