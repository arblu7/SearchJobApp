package bootcamp2023.projektiGroup;

public enum RemoteOfficeJob {

	REMOTE("Remote"), ONSITE("Office"), HYBRID("Hibrid");

	private String title;

	private RemoteOfficeJob(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
