package softtech.office.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import softtech.office.bean.SalaryinfoBean;
import softtech.office.service.SalaryinfoService;



@Controller
public class SalaryinfoController {

	private static final Logger logger = LoggerFactory.getLogger(SalaryinfoController.class);

	@ModelAttribute
    public SalaryinfoBean setUpSalaryinfoBean() {
		SalaryinfoBean form = new SalaryinfoBean();
        return form;
    }

	@Autowired
	SalaryinfoService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/Salaryinfo", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//	
//		List<SalaryinfoBean> beans = service.getSalaryinfo("1");
//		SalaryinfoBean ebean = beans.get(0);
//		
//		model.addAttribute("SalaryinfoForm", ebean);
//		
//		return "SalaryInfo";
//		
//	}
}
