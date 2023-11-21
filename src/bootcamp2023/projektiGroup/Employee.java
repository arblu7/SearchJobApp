package bootcamp2023.projektiGroup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;
	private String nipt;
	private String address;
	private String email;
	//private List<Job> listOfJobs;
	private EmployeeOrEmployeer punedhenesPunekerkues;

	public Employee() {
		//this.listOfJobs = new ArrayList<>();
	}

	public Employee(String name, String nipt, String address, String email) {
		this.name = name;
		this.nipt = nipt;
		this.address = address;
		this.email = email;
	//	this.listOfJobs = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNipt() {
		return nipt;
	}

	public void setNipt(String nipt) {
		this.nipt = nipt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
//	public Job createJob(String title, String description, RemoteOfficeJob remoteOffice, String address,
//			LocalDate publishedDate, LocalDate deadline, double pagaMin, double pagaMax) {
//		Job job = new Job();
//
//		job.setTitle(title);
//		job.setDescription(description);
//		job.setRemoteOffice(remoteOffice);
//		job.setAddress(address);
//		job.setPublishedDate(publishedDate);
//		job.setDeadline(deadline);
//		job.setPagaMin(pagaMin);
//		job.setPagaMax(pagaMax);
//		job.setVacance(true);
//		listOfJobs.add(job);
//	//	timePost.put(job, publishedDate);
//		return job;
//	}
	
	//postoPune(id, title, description)
	//shfaqTeGjithaPostimet();
	//
	//shikoAplikimet(long id); //aplikimet qe jane bere per nje id te caktuar
	
}
