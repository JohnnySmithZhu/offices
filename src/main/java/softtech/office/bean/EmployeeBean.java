package softtech.office.bean;

import lombok.Data;

@Data

// getter,setter,toStringなど、lombokで自動化される。
public class EmployeeBean {
	
	String employeeID;
	String employeeName;
	String Password;
	String phoneNumber;
	String sex;
	String age;
	String birthday;
	String hireDate;
	String address;
	String postCode;
	String authority;
	String deleteFlg;
	String insertDate;
	String updateDate;
}
