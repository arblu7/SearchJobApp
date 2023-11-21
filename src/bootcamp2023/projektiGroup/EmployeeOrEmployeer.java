package bootcamp2023.projektiGroup;

public enum EmployeeOrEmployeer {

	EMPLOYEE("Employee", 1), EMPLOYEER("Emplyeer", 2);
	
	String title;
	int id;
	
	private EmployeeOrEmployeer(String title, int id) {
		this.title = title;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
}
