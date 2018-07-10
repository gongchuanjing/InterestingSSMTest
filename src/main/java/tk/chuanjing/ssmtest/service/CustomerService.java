package tk.chuanjing.ssmtest.service;

import tk.chuanjing.ssmtest.pojo.Customer;
import tk.chuanjing.ssmtest.pojo.QueryVo;
import tk.chuanjing.ssmtest.util.Page;

public interface CustomerService {

	Page<Customer> getCustomerList(QueryVo queryVo);
	
	Customer getCustomerById(Long id);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(Long id);
}
