package softtech.office.bean;

import lombok.Data;

@Data

// getter,setter,toStringなど、lombokで自動化される。
public class LoginBean {

	private String employeeID;
	private String password;
	
}
