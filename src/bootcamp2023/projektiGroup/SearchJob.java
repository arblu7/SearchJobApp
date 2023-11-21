package bootcamp2023.projektiGroup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchJob implements JobService {

	private String name;
	private List<Job> listOfJobs; // list e puneve te publikuara si vakante
	private List<Employeer> listOfEmployeers; // lista e atyre qe jane regjistruar si Punedhenes
	private List<Employee> listOfEmployee; // lista e atyre qe jane regjistruar si punekerkues
	private Map<Job, LocalDate> timePost;
	private List<Job> listOfNonValidJobs; // lista e atyre puneve qe jane fshire tashme ose kane perfunduar afatin e
											// aplikimit
	// id e punekerkuesit dhe job
	private Map<Employeer, List<Job>> listOfAplikimeve;
	private List<Job> remoteList;
	private List<Job> officeList;

	private int countJobs;



	// konstruktori
	public SearchJob() {
		this.listOfJobs = new ArrayList<>();
		this.listOfEmployeers = new ArrayList<>();
		this.listOfEmployee = new ArrayList<>();
		this.timePost = new HashMap<>();
		this.listOfNonValidJobs = new ArrayList<>();
		this.listOfAplikimeve = new HashMap<>();
		this.remoteList = new ArrayList<>();
		this.officeList = new ArrayList<>();

	}

	public SearchJob(String name) {
		this();
		this.name = name;
	
	}
	// regjistro punedhenesin
	public Employee regjistrohuSiPunedhenes(String name, String email, String nipt, String address) {
		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmail(email);
		emp.setNipt(nipt);
		emp.setAddress(address);
		listOfEmployee.add(emp);
		// System.out.println("Ju u regjistruat si punedhenes ne app tone!
		// FALEMINDERIT!");
		return emp;
	}

	// regjistro punekerkuesin
	public Employeer regjistrohuSiPunekerkues(String name, int age, String address, String degree, boolean hasCv) {
		Employeer emp = new Employeer();
		emp.setFullName(name);
		emp.setAge(age);
		emp.setAddress(address);
		emp.setDegree(degree);
		emp.setHasCv(hasCv);
		listOfEmployeers.add(emp);
		return emp;

	}

	// Punedhenesi krijon nje pune per ta publikuar ne app
	@Override
	public Job createJob(String title, String description, RemoteOfficeJob remoteOffice, String address,
			LocalDate publishedDate, LocalDate deadline, double pagaMin, double pagaMax) {
		Job job = new Job();

		job.setTitle(title);
		job.setDescription(description);
		job.setRemoteOffice(remoteOffice);
		job.setAddress(address);
		job.setPublishedDate(publishedDate);
		job.setDeadline(deadline);
		job.setPagaMin(pagaMin);
		job.setPagaMax(pagaMax);
		job.setVacance(true);
		listOfJobs.add(job);
		timePost.put(job, publishedDate);
		return job;
	}

	/***
	 * Pasi e krijove punen, publikoje
	 */
	public boolean publikoPunen(long id, String title) {
		Job job = null;
		for (Job filterJob : listOfJobs) {
			if (filterJob.getId() == id && filterJob.getTitle().equalsIgnoreCase(title)) {
				job = filterJob;
				job.isStatusActive();
				job.setStatusActive(true);
			} else {
				System.out.println("Nuk u krye asnje veprim");
			}
		}

		return true;

	}

	/**
	 * te shfaq listen e te gjitha puneve te publikuar
	 */
	@Override
	public List<Job> getAllJobs() {
		List<Job> listoPunet = new ArrayList<>();
		if (!listOfJobs.isEmpty() || listOfJobs != null) {
			for (Job job : listOfJobs) {
				listoPunet.add(job);
			}
		} else {
			System.out.println("Nuk ka asnje Pune te publikuar");
		}
		return listoPunet;
	}

	/**
	 * shfaq nje pozicion sipas id-se
	 **/
	@Override
	public Job getJobById(Long id) {
		Job job = null;
		if (!listOfJobs.isEmpty() || listOfJobs != null) {
			for (Job jobs : listOfJobs) {
				if (jobs.getId() == id) {
					job = jobs;
				}

			}
			if (job != null) {
				System.out.println(job.getId() + " " + job.getTitle() + " " + job.getDescription());
			}
		}

		return null;
	}

	/**
	 * Aplikuesi Kerkon pune ne listen e puneve te publikuara
	 * 
	 */
	public void aplikoPerPune(String title, long id) {
		Employeer emp = new Employeer();
		List<Job> listJobs = new ArrayList<>();
		for (Job job : listOfJobs) {
			if (job.getId() == id && job.getTitle().equalsIgnoreCase(title)) {
				job.setApliko(true);
				listJobs.add(job);
				listOfAplikimeve.put(emp, listJobs);
				listOfEmployeers.add(emp);
				System.out.println(
						"Aplikimi per pozicionin: " + job.getTitle() + " me id: " + job.getId() + " u krye me sukses!");
			}
		}
	}

	/**
	 * Punekerkuesi anullon aplikimin qe ka bere per ne pune te caktuar
	 * 
	 */
	public void anulloAplikiminPerPune(String title, long id) {
		if (!listOfAplikimeve.isEmpty() || listOfAplikimeve != null) {
			for (Map.Entry<Employeer, List<Job>> entryMap : listOfAplikimeve.entrySet()) {
				Employeer emp = entryMap.getKey();
				List<Job> jobList = entryMap.getValue();
				for (Job job : jobList) {
					if (job.getId() == id && job.getTitle().equalsIgnoreCase(title)) {
						job.setApliko(false);
						listOfAplikimeve.remove(job);
						System.out
								.println("Aplikimi juaj per pozicionin e " + job.getTitle() + " u anullua me sukses!");
					}
				}
			}
		}
	}

	/**
	 * Punedhenesi ndalon aplikimet per nje pozicion te caktuar duke dhene id dhe
	 * titullin
	 */
	public boolean ndaloAplikimetPerPunen(long id, String title) {
		Job job = null;
		for (Job filterJob : listOfJobs) {
			if (filterJob.getId() == id && filterJob.getTitle().equalsIgnoreCase(title)) {
				job = filterJob;
				job.setStatusActive(false);
			}
		}

		return true;

	}

	/**
	 * Fshirja e nje pune duke dhene id dhe titullin
	 **/
	@Override
	public void deleteJob(long id, String title) {
		Job jobToBeRemoved = null;
		if (!listOfJobs.isEmpty() || listOfJobs != null) {
			for (Job jobs : listOfJobs) {
				if (jobs.getId() == id && jobs.getTitle().equalsIgnoreCase(title)) {
					jobToBeRemoved = jobs;
				}
			}
			if (jobToBeRemoved != null) {
				listOfJobs.remove(jobToBeRemoved);
				listOfNonValidJobs.add(jobToBeRemoved); // e shtojme ne listen e puneve qe nuk jane me vvakante ose ka
				jobToBeRemoved.setStatusActive(false);
				jobToBeRemoved.setVacance(false);// kaluar deadline
				System.out.println(
						"Job " + jobToBeRemoved.getId() + " " + jobToBeRemoved.getTitle() + " removed succesfully!");
			}
		}

	}

	// modifikoPozicionin
	public Job modifikoPozicionin(long id, String title, String description, RemoteOfficeJob remoteOffice,
			String address, LocalDate publishedDate, LocalDate deadline, double pagaMin, double pagaMax,
			boolean isVacant) {
		Job job = null;
		for (Job j : listOfJobs) {
			if (j.getId() == id && j.getTitle().equalsIgnoreCase(title)) {
				job = j;
			}
		}
		if (job != null) {
			job.setTitle(title);
			job.setDescription(description);
			job.setRemoteOffice(remoteOffice);
			job.setAddress(address);
			job.setPublishedDate(publishedDate);
			job.setDeadline(deadline);
			job.setPagaMin(pagaMin);
			job.setPagaMax(pagaMax);
			job.setVacant(isVacant);
			job.setVacance(isVacant);
		}
		return job;
	}

	// pozicionimi, ai qe ka postu se fundmi duhet te dal ne fillim

	public Map<Job, LocalDate> shfaqPozicionetPunesSipasDatesSeFundit() {
		Map<Job, LocalDate> pozicioni = new HashMap<>();
		for (Map.Entry<Job, LocalDate> entryJob : timePost.entrySet()) {
			Job job = entryJob.getKey();
			LocalDate date = entryJob.getValue();
			pozicioni.put(job, date);
		}

		return pozicioni;
	}

	// eshte punedhenes
	public boolean isEmployee() {
		if (EmployeeOrEmployeer.EMPLOYEE.getId() == 1) {
			return true;
		}

		return false;
	}

	// eshte punekerkues
	public boolean isEmployeer() {
		if (EmployeeOrEmployeer.EMPLOYEER.getId() == 2) {
			return true;
		}

		return false;
	}
	// shfaq aplikimet qe jane bere nga persona te ndryshem per nje pozicion te
	// caktuar

	public Map<Employeer, List<Job>> aplikimetPerPozicion(String title, long jobId) {
		Map<Employeer, List<Job>> mapAplikim = new HashMap<>();
		for (Map.Entry<Employeer, List<Job>> aplikmet : listOfAplikimeve.entrySet()) {
			Employeer emp = aplikmet.getKey(); // merr nje emer // antonela
			List<Job> jobList = aplikmet.getValue(); // listen e te gjitha aplikimeve qe kam bere
			for (Job jobFilter : jobList) {
				if (jobFilter.getId() == jobId && jobFilter.getTitle().equalsIgnoreCase(title)) {
					jobList.add(jobFilter);
					mapAplikim.put(emp, jobList);
				}
			}
		}

		return mapAplikim;

	}

	// lista e aplikimeve qe ka bere cdo person
	public Map<Employeer, List<Job>> teGjithaAplikimetEBera() {
		Map<Employeer, List<Job>> mapAplikim = new HashMap<>();
		for (Map.Entry<Employeer, List<Job>> aplikmet : listOfAplikimeve.entrySet()) {
			Employeer emp = aplikmet.getKey(); // merr nje emer // antonela
			List<Job> jobList = aplikmet.getValue(); // listen e te gjitha aplikimeve qe kam bere
			mapAplikim.put(emp, jobList);
		}

		return mapAplikim;

	}

	// kerkimi i nje pune brenda nje afati te caktuar nga kjo date ne kte date
	public List<Job> punetPublikuaraNeIntervalin(LocalDate minDate, LocalDate maxDate) {
		List<Job> newList = new ArrayList<>();
		Job saveJob = null;
		for (Job job : listOfJobs) {
			if (job.getPublishedDate().equals(minDate) || job.getPublishedDate().equals(maxDate)) {
				saveJob = job;
				newList.add(saveJob);
			}
		}

//		for (int i = 0; i < newList.size() - 1; i++) {
//			for (int j = 1; j < newList.size(); j++) {
//				if (newList.get(i).getPublishedDate().isBefore(newList.get(j).getPublishedDate())) {
//					newList.add(i, saveJob);
//				} else {
//					newList.add(i, saveJob); // kontrolloje
//				}
//			}
//
//		}

		return newList;
	}

	// punet e publikuara remote
	public List<Job> punetPublikuaraRemote() {
		List<Job> newList = new ArrayList<>();
		if (!listOfJobs.isEmpty() || (listOfJobs != null)) {
			for (Job job : listOfJobs) {
				if (job.getRemoteOffice().getTitle().equalsIgnoreCase("Remote")) {
					newList.add(job);
				}
			}
		}

		return newList;
	}

	// punet e publikuara fizikisht
	public List<Job> punetPublikuaraOffice() {
		List<Job> newList = new ArrayList<>();
		if (!listOfJobs.isEmpty() || (listOfJobs != null)) {
			for (Job job : listOfJobs) {
				if (job.getRemoteOffice().getTitle().equalsIgnoreCase("Office")) {
					newList.add(job);
				}
			}
		}

		return newList;
	}

	// kerkoPuneNeNjeQytetSpecifik()
	public List<Job> punetPublikuaraQytet(String adresa) {
		List<Job> newList = new ArrayList<>();
		if (!listOfJobs.isEmpty() || (listOfJobs != null)) {
			for (Job job : listOfJobs) {
				if (job.getAddress().equalsIgnoreCase(adresa)) {
					newList.add(job);
				}
			}
		}

		return newList;
	}

	// karakteristikat e nje poziocioni pune
	public void karakteristikatEPozicionitTePunes(String title, long id) {
		Job jobSearched = null;
		for (Job job : listOfJobs) {
			if (job.getId() == id && job.getTitle().equals(title) && job.isVacant()) {
				jobSearched = job;
			}
		}
		if (jobSearched != null) {
			System.out.println("Titulli punes: " + jobSearched.getTitle());
			System.out.println("Pershkrimi punes: " + jobSearched.getDescription());
			System.out.println("Adresa e punes: " + jobSearched.getAddress());
			System.out.println("Data e publikimit: " + jobSearched.getPublishedDate());
			System.out.println("Deadline: " + jobSearched.getDeadline());
			System.out.println("Tipi punes: " + jobSearched.getRemoteOffice());
			System.out.println("Paga Minimale: " + jobSearched.getPagaMin());
			System.out.println("Paga Maksimale: " + jobSearched.getPagaMax());

		}
	}

	// 1. Numri i punekerkueseve per nje periudhe te caktuar
	// 2.
	// Company Profiles: Include detailed profiles for companies, displaying
	// information about the company, its culture, and benefits.

}
