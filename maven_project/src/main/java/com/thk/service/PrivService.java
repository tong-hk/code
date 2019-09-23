package com.thk.service;

import java.util.List;

import com.thk.entity.Priv;

public interface PrivService {

	/**
	 * 查询所有权限
	 * @return
	 */
	List<Priv>selectAllPriv();
}
