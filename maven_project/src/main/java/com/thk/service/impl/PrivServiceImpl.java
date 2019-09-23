package com.thk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thk.dao.PrivDao;
import com.thk.entity.Priv;
import com.thk.service.PrivService;
@Service
public class PrivServiceImpl implements PrivService {
	@Autowired
	PrivDao privDao = null;
	@Override
	public List<Priv> selectAllPriv() {
		List<Priv>ls = privDao.selectAllPriv();
		return ls;
	}

}
