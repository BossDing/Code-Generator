package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.AraInfo;
import com.zlinks.zlinks-service.AraInfoService;
import com.zlinks.zlinks-repsitory.AraInfoDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:42
 */
@Service("araInfoService")
public class AraInfoServiceImpl extends BaseMybatisDao<AraInfoDao> implements AraInfoService {

	@Autowired
	private AraInfoDao araInfoDao;

	@Override
	public AraInfo getById(int id) {
		return araInfoDao.getById(id);
	}

	@Override
	public int getListCount(AraInfo entity) {
		return araInfoDao.getListCount(entity);
	}

	@Override
	public List<AraInfo> getList(AraInfo entity) {
		List<AraInfo> resut = null;
		resut = araInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return araInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<AraInfo> getListByMap(Map<String, Object> paramMap) {
		List<AraInfo> resut = null;
		resut = araInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(AraInfo entity) {
		return araInfoDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return araInfoDao.deleteById(id);
	}

	@Override
	public int add(AraInfo entity) {
		return araInfoDao.add(entity);
	}

	@Override
	public int addList(List<AraInfo> entityList) {
		return araInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<AraInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<AraInfo> getActivedList() {
		List<AraInfo> resut = null;
		AraInfo entity = new AraInfo();
		entity.setIsDeleted(0);
		resut = araInfoDao.getList(entity);
		return resut;
	}
}