package softtech.office.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import softtech.office.bean.SalaryinfoBean;

@Component
public class SalaryinfoService extends comService {

	public SalaryinfoBean getSalaryinfo(String employeeID) {

		SalaryinfoBean ebean = new  SalaryinfoBean();
		//List<SalaryinfoBean> rtns = new ArrayList<SalaryinfoBean>();
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM salaryinfo where employeeID = '" + employeeID + "'");
		ebean.setSum(list.get(0).get("sum").toString());
		//rtns.add(ebean);
		
		return ebean;
	}
}

