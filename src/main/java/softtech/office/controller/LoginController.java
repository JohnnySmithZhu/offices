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
import softtech.office.bean.LoginBean;
import softtech.office.service.EmployeeService;
import softtech.office.service.LoginService;

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

	@Autowired
	LoginService loginService;
	
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("LoginBean") LoginBean loginbean) {
		
		// 社員IDが渡されない場合、入力してくださいメッセージを表示する。
		if (loginbean.getEmployeeID() == null || loginbean.getEmployeeID().length() == 0 
				|| loginbean.getPassword() == null || loginbean.getPassword().length() == 0) {
			// TODO:ログイン画面に入力してくださいメッセージを表示する。
			return "login";
		}
		// ログイン処理。
		EmployeeBean eBean = loginService.getLogin(loginbean.getEmployeeID());
		
		// パスワードの判断
		if (loginbean.getPassword().equals(eBean.getPassword())){

			// 給料明細の情報を取得する。
			// TODO:①salaryサービス
			// TODO:②給料明細を取得
			// TODO:②給料明細JSP作成
			// TODO:②給料明細をMODELにセットする。
			return "salaryInfo";
		}
		return "login";
	}
}