package softtech.office.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import softtech.office.bean.EmployeeBean;

@Component
public class LoginService extends comService {

	/**
	 * ログイン画面に入力したユーザーIDを持っち、社員テーブルから検索する。
	 * @param employeeID 社員ID
	 * @return 社員情報 
	 * 	 
	 */
	public EmployeeBean getLogin(String employeeID) {

		EmployeeBean ebean = new  EmployeeBean();
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM employee where employeeID = '" +  employeeID + "'");
		if (list.size() > 0 ) {
			ebean.setEmployeeID(list.get(0).get("employeeID").toString());
			ebean.setPassword(list.get(0).get("password").toString());
			ebean.setAuthority(list.get(0).get("authority").toString());
		}
		
		return ebean;
	}

	
}

