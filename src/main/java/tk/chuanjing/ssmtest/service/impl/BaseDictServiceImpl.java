package tk.chuanjing.ssmtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.chuanjing.ssmtest.dao.BaseDictDao;
import tk.chuanjing.ssmtest.pojo.BaseDict;
import tk.chuanjing.ssmtest.service.BaseDictService;

/**
 * 字典表处理Service
 * 
 * @author ChuanJing
 * @date 2018年3月22日 下午12:03:36
 * @version 1.0
 */
@Service("baseDictServiceImpl")
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao baseDictDao;
	
	@Override
	public List<BaseDict> getDictListByTypeCode(String typeCode) {
		return baseDictDao.getDictListByTypeCode(typeCode);
	}

}
