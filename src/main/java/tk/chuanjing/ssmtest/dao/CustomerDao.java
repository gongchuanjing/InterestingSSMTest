package tk.chuanjing.ssmtest.dao;

import java.util.List;

import tk.chuanjing.ssmtest.pojo.Customer;
import tk.chuanjing.ssmtest.pojo.QueryVo;

public interface CustomerDao {
	
	List<Customer> getCustomerList(QueryVo queryVo);
	
	Integer getCustomerListCount(QueryVo queryVo);
	
	Customer getCustomerById(Long id);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(Long id);
}
