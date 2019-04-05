package softtech.office.bean;

import lombok.Data;

@Data

// getter,setter,toStringなど、lombokで自動化される。
public class EmployeeBean {
	String s_ID; //一意を維持ための項目

	String employeeNo;
	String employeeName;
	String Password;
	String sex;
	String birthday;
	String age;
	String hireDate;
	String lengthofSurvice;
	String postCode;
	String address;
	String phoneNumber;
	String authority;
	String deleteFlg;
	String insertDate;
	String updateDate;
}
