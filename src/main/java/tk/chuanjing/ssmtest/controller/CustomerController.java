package tk.chuanjing.ssmtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 客户管理Controller
 * 
 * @author ChuanJing
 * @date 2018年3月21日 上午8:57:42
 * @version 1.0
 */
@Controller
public class CustomerController {

	@RequestMapping("/customer/list")
	public String showCustomerList() {
		return "customer";
	}
}
