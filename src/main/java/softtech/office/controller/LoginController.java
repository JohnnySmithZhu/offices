package softtech.office.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import softtech.office.bean.EmployeeBean;
import softtech.office.service.EmployeeService;



@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@ModelAttribute
    public EmployeeBean setUpEmployeeBean() {
		EmployeeBean form = new EmployeeBean();
        return form;
    }

	@Autowired
	EmployeeService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
	
//		List<EmployeeBean> beans = service.getEmployee("1");
//		EmployeeBean ebean = beans.get(0);
//		
//		model.addAttribute("employeeForm", ebean);
		
		return "login";
		
	}
}
