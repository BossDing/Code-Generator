package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.OrdInfo;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.OrdInfoService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.OrdInfoDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:59
 */
@Service("ordInfoService")
public class OrdInfoServiceImpl extends BaseMybatisDao<OrdInfoDao> implements OrdInfoService {

	@Autowired
	private OrdInfoDao ordInfoDao;

	@Override
	public OrdInfo getById(int id) {
		return ordInfoDao.getById(id);
	}

	@Override
	public int getListCount(OrdInfo entity) {
		return ordInfoDao.getListCount(entity);
	}

	@Override
	public List<OrdInfo> getList(OrdInfo entity) {
		List<OrdInfo> resut = null;
		resut = ordInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return ordInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<OrdInfo> getListByMap(Map<String, Object> paramMap) {
		List<OrdInfo> resut = null;
		resut = ordInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(OrdInfo entity) {
		return ordInfoDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return ordInfoDao.deleteById(id);
	}

	@Override
	public int add(OrdInfo entity) {
		return ordInfoDao.add(entity);
	}

	@Override
	public int addList(List<OrdInfo> entityList) {
		return ordInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<OrdInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<OrdInfo> getActivedList() {
		List<OrdInfo> resut = null;
		OrdInfo entity = new OrdInfo();
		entity.setIsDeleted(0);
		resut = ordInfoDao.getList(entity);
		return resut;
	}
}