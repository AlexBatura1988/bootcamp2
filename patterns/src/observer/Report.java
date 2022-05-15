package observer;

public class Report {
	private String msg;
	private TypeOfReports typeOfReports;
	
	public Report(String msg, TypeOfReports typeOfReports) {
		this.msg = msg;
		this.typeOfReports = typeOfReports;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public TypeOfReports getTypeOfReports() {
		return typeOfReports;
	}

	public void setTypeOfReports(TypeOfReports typeOfReports) {
		this.typeOfReports = typeOfReports;
	}
	
	
	
	

}
