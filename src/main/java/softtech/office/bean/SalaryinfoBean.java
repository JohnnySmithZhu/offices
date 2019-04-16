package softtech.office.bean;

import lombok.Data;

@Data

// getter,setter,toStringなど、lombokで自動化される。
public class SalaryinfoBean{
	String employeeNo;
	String month;
	String paymentDate;
	String base;
	String overTimePlus;
	String shortageReduce;
	String transportExpense;
	String allowancePlus;
	String allowanceReduce;
	String allowanceReason;
	String welfare;
	String withholdingTax;
	String municipalTax;
	String sum;
	String deleteFlg;
	String insertDate;
	String updateDate;
}