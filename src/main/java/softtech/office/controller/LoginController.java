package softtech.office.controller;

import java.text.DateFormat;
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
import softtech.office.bean.SalaryinfoBean;
import softtech.office.service.EmployeeService;
import softtech.office.service.LoginService;
import softtech.office.service.SalaryinfoService;

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
//
//		List<EmployeeBean> beans = service.getEmployee("1");
//		EmployeeBean ebean = beans.get(0);
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
			// ③-1-1 ログイン画面で入力されたIDとパスワードを取得
            String id = request.getParameter("employeeID");
            String pass = request.getParameter("password");

            // ③-1-2 ユーザ情報をモデルに格納するために指示
            // ③-1-3 ログイン処理クラスをインスタンス化
            LoginBean login = new LoginBean();

            // ③-1-4 ID処理クラスに②-1-1で取得したIDを渡してユーザ情報をモデルに格納
            SalaryinfoBean bean = loginService.getLogin(loginbean.getEmployeeID());

            // ③-2 モデルの情報を判定
            if (bean != null) {
                // ③-2-1 モデルの情報が存在する場合はsetAttributeメソッドを使ってセッションに情報をセット
                // モデル（ユーザ情報）
                session.setAttribute("login_user_bean", bean);
                // ログイン状態
                session.setAttribute("login_state", "login");

                // ③-2-2 つぎに表示させる画面（ビュー）を指定
                rd = request.getRequestDispatcher("./ShoppingServlet");
            } else {
                // ③-3 モデルの情報が存在しない（IDに紐づくユーザ情報がない）場合
                // ③-3-1 つぎに表示させる画面（ビュー）を指定
                rd = request.getRequestDispatcher("./jsp/loginFailed.jsp");
            }

            rd.forward(request, response);

        } else if (btn.equals("ログアウト")) {
            // ④ クリックされたボタンが「logout」の場合はログアウト処理（セッションの破棄）を実施
            session.removeAttribute("login_state");
            session.removeAttribute("login_user_bean");
            response.sendRedirect("./");
        }

    }
			
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