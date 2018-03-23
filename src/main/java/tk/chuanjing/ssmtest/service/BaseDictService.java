package tk.chuanjing.ssmtest.service;

import java.util.List;

import tk.chuanjing.ssmtest.pojo.BaseDict;

public interface BaseDictService {

	List<BaseDict> getDictListByTypeCode(String typeCode);
}
