package bootcamp2023.projektiGroup;

public class Employeer {

	private String fullName;
	private	int age;
	private String address;
	private String degree;
	boolean hasCv;
	private EmployeeOrEmployeer punedhenesPunekerkues;   //?????
	
	
	public Employeer() {
		
	}
	public Employeer(String fullName, int age, String address, String degree, boolean hasCv,
			EmployeeOrEmployeer punedhenesPunekerkues) {
		this.fullName = fullName;
		this.age = age;
		this.address = address;
		this.degree = degree;
		this.hasCv = hasCv;
		this.punedhenesPunekerkues = punedhenesPunekerkues;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public boolean isHasCv() {
		return hasCv;
	}
	public void setHasCv(boolean hasCv) {
		this.hasCv = hasCv;
	}
	public EmployeeOrEmployeer getPunedhenesPunekerkues() {
		return punedhenesPunekerkues;
	}
	public void setPunedhenesPunekerkues(EmployeeOrEmployeer punedhenesPunekerkues) {
		this.punedhenesPunekerkues = punedhenesPunekerkues;
	}
	
	
	
	
}
