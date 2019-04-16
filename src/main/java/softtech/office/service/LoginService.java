package softtech.office.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import softtech.office.bean.LoginBean;

@Component
public class LoginService extends comService {

	public List<LoginBean> getLogin(String employeeID) {

		LoginBean ebean = new  LoginBean();
		List<LoginBean> rtns = new ArrayList<LoginBean>();
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM employee");
		ebean.setEmployeeID(list.get(0).get("name").toString());
		rtns.add(ebean);
		
		return rtns;
	}

	
}

