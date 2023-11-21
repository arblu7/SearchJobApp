package bootcamp2023.projektiGroup;

import java.time.LocalDate;
import java.util.List;

public interface JobService {

	 List<Job> getAllJobs();
	 Job getJobById(Long id);
	 Job createJob(String title, String description, RemoteOfficeJob remoteOffice, String address, LocalDate publishedDate, 
							LocalDate deadline, double pagaMin, double pagaMax);
		void deleteJob(long id, String title);
	 
}
