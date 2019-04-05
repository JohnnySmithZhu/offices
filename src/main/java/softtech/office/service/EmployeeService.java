package softtech.office.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import softtech.office.bean.EmployeeBean;

@Component
public class EmployeeService extends comService {

	public List<EmployeeBean> getEmployee(String employeeID) {

		EmployeeBean ebean = new  EmployeeBean();
		List<EmployeeBean> rtns = new ArrayList<EmployeeBean>();
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM employee");
		ebean.setEmployeeNo(list.get(0).get("name").toString());
		rtns.add(ebean);
		
		return rtns;
	}
}

