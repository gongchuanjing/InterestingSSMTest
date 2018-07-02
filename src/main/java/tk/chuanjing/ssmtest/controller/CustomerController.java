package tk.chuanjing.ssmtest.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.chuanjing.ssmtest.pojo.BaseDict;
import tk.chuanjing.ssmtest.pojo.Customer;
import tk.chuanjing.ssmtest.pojo.QueryVo;
import tk.chuanjing.ssmtest.service.BaseDictService;
import tk.chuanjing.ssmtest.service.CustomerService;
import tk.chuanjing.ssmtest.util.Page;


/**
 * 客户管理Controller
 * 
 * @author ChuanJing
 * @date 2018年3月21日 上午8:57:42
 * @version 1.0
 */
@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	
	@Value("${customer.source.code}")
	private String customerSourceCode;
	
	@Value("${customer.industory.code}")
	private String customerIndustoryCode;
	
	@Value("${customer.level.code}")
	private String customerLevelCode;

	@RequestMapping("/customer/list")
	public String showCustomerList(QueryVo queryVo, Model model) throws Exception {
		//乱码处理
		if (StringUtils.isNotBlank(queryVo.getCustName())) {
			queryVo.setCustName( new String(queryVo.getCustName().getBytes("iso-8859-1"), "utf-8") );
		}
		
		//初始化客户来源
		List<BaseDict> sourceList = baseDictService.getDictListByTypeCode(customerSourceCode);
		//所属行业
		List<BaseDict> industoryList = baseDictService.getDictListByTypeCode(customerIndustoryCode);
		//客户级别
		List<BaseDict> levelList = baseDictService.getDictListByTypeCode(customerLevelCode);
		//把字典信息传递给页面
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industoryList);
		model.addAttribute("levelType", levelList);
		
		//根据查询条件查询客户列表
		Page<Customer> page = customerService.getCustomerList(queryVo);
		//把客户列表传递给页面
		model.addAttribute("page", page);
		
		//参数回显
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustory());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		
		return "customer";
	}
	
	@RequestMapping("/customer/edit")
	@ResponseBody
	public Customer getCustomerById(Long id) {
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	
	@RequestMapping(value = "/customer/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateCustomer(Customer customer) {
		customerService.updateCustomer(customer);
		return "OK";
	}
	
	@RequestMapping("/customer/delete")
	@ResponseBody
	public String deleteCustomer(Long id) {
		customerService.deleteCustomer(id);
		return "OK";
	}
	
}
