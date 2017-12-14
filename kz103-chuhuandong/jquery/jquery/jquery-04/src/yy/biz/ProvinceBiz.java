package yy.biz;

import java.util.List;

import yy.dao.BaseDao;
import yy.dao.CityDao;
import yy.dao.DistrictDao;
import yy.entity.City;
import yy.entity.Province;

public class ProvinceBiz {

	public List queryAll() {
		return BaseDao.queryAll(Province.class);
	}

	public List queryById(Integer pid) {
		return new CityDao().queryByPid(pid);
	}

	public List queryByCid(Integer cid) {
		// TODO Auto-generated method stub
		return new DistrictDao().queryByCid(cid);
	}

}
