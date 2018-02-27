package tk.chuanjing.ssmtest.dao;

import java.util.List;

import tk.chuanjing.ssmtest.pojo.BaseDict;

public interface BaseDictDao {

	List<BaseDict> getDictListByTypeCode(String typeCode);
}