package tk.chuanjing.ssmtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.chuanjing.ssmtest.dao.CustomerDao;
import tk.chuanjing.ssmtest.pojo.Customer;
import tk.chuanjing.ssmtest.pojo.QueryVo;
import tk.chuanjing.ssmtest.service.CustomerService;
import tk.chuanjing.ssmtest.util.Page;

/**
 * 客户管理Service
 * 
 * @author ChuanJing
 * @date 2018年3月22日 下午12:02:25
 * @version 1.0
 */
@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Page<Customer> getCustomerList(QueryVo queryVo) {
		//计算分页起始记录
		if (queryVo.getPage() != null) {
			queryVo.setStart( (queryVo.getPage() - 1) * queryVo.getSize() );
		}
		
		List<Customer> customerList = customerDao.getCustomerList(queryVo);
		
		//查询总记录数
		Integer count = customerDao.getCustomerListCount(queryVo);
		
		//创建一个Page对象
		Page<Customer> page = new Page<Customer>();
		page.setPage(queryVo.getPage());
		page.setRows(customerList);
		page.setSize(queryVo.getSize());
		page.setTotal(count);
		
		//返回结果
		return page;
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerDao.getCustomerById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerDao.deleteCustomer(id);
	}

}
