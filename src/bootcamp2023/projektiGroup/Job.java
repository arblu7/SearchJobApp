package bootcamp2023.projektiGroup;

import java.time.LocalDate;

public class Job {

	private static long id = 0;
	private String jobTitle;
	private String jobDescription;
	private RemoteOfficeJob typeOfWork;
	private String address;
	private LocalDate publishedDate;
	private LocalDate deadline;
	private double pagaMin;
	private double pagaMax;
	private boolean isVacant;
	private boolean statusActive;
	private boolean poAplikoj;

	public Job() {

	}

	public Job(String jobTitle, String jobDescription, RemoteOfficeJob typeOfWork, String address,
			LocalDate publishedDate, LocalDate deadline, double pagaMin, double pagaMax, boolean poAplikoj) {
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.typeOfWork = typeOfWork;
		this.address = address;
		this.publishedDate = publishedDate;
		this.deadline = deadline;
		this.pagaMin = pagaMin;
		this.pagaMax = pagaMax;
		this.isVacant = true;
		this.statusActive = true;
		this.poAplikoj = poAplikoj;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return jobTitle;
	}

	public void setTitle(String title) {
		this.jobTitle = title;
	}

	public String getDescription() {
		return jobDescription;
	}

	public void setDescription(String description) {
		this.jobDescription = description;
	}

	public RemoteOfficeJob getRemoteOffice() {
		return typeOfWork;
	}

	public void setRemoteOffice(RemoteOfficeJob remoteOffice) {
		this.typeOfWork = remoteOffice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isVacant() {
		return isVacant;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public double getPagaMin() {
		return pagaMin;
	}

	public void setPagaMin(double pagaMin) {
		this.pagaMin = pagaMin;
	}

	public double getPagaMax() {
		return pagaMax;
	}

	public void setPagaMax(double pagaMax) {
		this.pagaMax = pagaMax;
	}

	public void setVacant(boolean isVacant) {
		this.isVacant = isVacant;
	}

	public void setVacance(boolean available) {
		isVacant = available;
	}

	public boolean isStatusActive() {
		return statusActive;
	}

	public void setStatusActive(boolean active) {
		statusActive = active;
	}

	public void setApliko(boolean apliko) {
		poAplikoj = apliko;
	}

	// getters and setters

}
