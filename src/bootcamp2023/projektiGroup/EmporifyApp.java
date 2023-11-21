package bootcamp2023.projektiGroup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EmporifyApp {

	public static void main(String[] args) {
		String RESET = "\u001B[0m";
		String RED = "\u001B[31m";
		String GREEN = "\u001B[32m";
		String YELLOW = "\u001B[33m";
		char quit = 'n';
		Scanner scan = new Scanner(System.in);
		SearchJob emporifyApp = new SearchJob("Emporify");
		int choice;
		while (quit != 'y') {

			System.out.println(
					RED + "\t\t\t\tMire se erdhet ne Emporify \n\t\tKetu do te gjeni punen e endrrave tuaja!" + RESET);
			System.out.println();
			System.out.println("Deshironi te hyni ne aplikacionin tone?");
			System.out.println("1. Log in as a Employee");
			System.out.println("2. Log in as a Employeer");
			System.out.println("4. FSHI LIBRA"); // done

			System.out.println("Zgjidhni nje nga opsionet e meposhtme:");
			choice = scan.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Ju lutem vendosni id tuaj per tu identifikuar qe jeni nje Punedhenes: ");
				int id = scan.nextInt();
				if (EmployeeOrEmployeer.EMPLOYEE.getId() == id) {
					System.out.println("A keni krijuar profilin tuaj ne app tone? (1-Jo/2- Po)");
					String answerNow = scan.next();
					if (answerNow.equalsIgnoreCase("jo")) {						
						System.out.println("Ju lutem vendosni emrin e kompanise suaj: ");
						String name = scan.nextLine();
						Employee emp = new Employee();
						System.out.println();
						System.out.println("Ju lutem vendosni niptin e kompanise suaj: ");
						String nipt = scan.nextLine();

						System.out.println("Ju lutem vendosni email e kompanise suaj: ");
						String email = scan.nextLine();

						System.out.println("Ju lutem vendosni adresen e kompanise suaj: ");
						String address = scan.nextLine();
						
						emporifyApp.regjistrohuSiPunedhenes(name, nipt, email, address);   ///u regjistrua si punedhenes

						System.out.println("Deshironi te postoni nje pozicion per pune? po/Jo");
						String posto = scan.nextLine();
						if (posto.equalsIgnoreCase("po")) {
							System.out.println("Ju lutem vendosni emrin e punes qe do postoni: ");
							String title = scan.nextLine();
							System.out.println("Ju lutem vendosni pershkrimin e punes qe do postoni: ");  //paga
							String description = scan.nextLine();
							
							System.out.println("Ju lutem vendosni nese puna eshte remote apo ne zyre:");  //paga
							String tipiPunes = scan.nextLine();
							RemoteOfficeJob tipi = RemoteOfficeJob.valueOf(tipiPunes);
							
							System.out.println("Ju lutem vendosni adressen/qytetin e punes qe do postoni: ");  //paga
							String adresa = scan.nextLine();
							
							System.out.println("Ju lutem vendosni daten e postimit te punes qe do postoni ne formatin(psh. 01.01.2001): ");  //paga
							String date = scan.next();
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
							LocalDate publishDate = LocalDate.parse(date, dtf);  //kjo mund te jete edhe data e sotme
							
							System.out.println("Ju lutem vendosni deadline e punes qe do postoni: ");  //paga
							String dateDeadline = scan.next();
							DateTimeFormatter dtfline = DateTimeFormatter.ofPattern("dd.MM.yyyy");
							LocalDate deadline = LocalDate.parse(date, dtf);
							
							System.out.println("Ju lutem vendosnipagen min te punes qe do postoni: ");  //paga
							double pagaMin  = scan.nextDouble();
							
							System.out.println("Ju lutem vendosnipagen max te punes qe do postoni: ");  //paga
							double pagaMax  = scan.nextDouble();
							
							emporifyApp.createJob(title, description, tipi, adresa, publishDate, deadline, pagaMin, pagaMax);
							emporifyApp.publikoPunen(id, title);
							
						} else if (posto.equalsIgnoreCase("jo")) {
							System.out
									.println("Faleminerit qe uregjistruat si Punedhenes ne aplikacioni  tone Emporify");
						}
					} else if (answerNow == "po") {
						System.out.println(
								"Cfare veprimesh deshironi te kryeni?  \n1.Te postoni nje pune te re? \n2.Te shihni sa aplikante keni per nje pozicion te caktuar?");
						int answer = scan.nextInt();
						if (answer == 1) {
							String title = scan.nextLine();
							String description = scan.nextLine();
							//s.postJob(title, description);
						}
					} else {
						System.out.println("Hidh exception");
					}
				} else {
					System.out.println("Do te hidhet nje  exeption: Failed to Login");
				}
				break;
			}

			// rasti i dyte kur perdoruesi eshte aiqe po kerkon pune
			case 2: {
				System.out.println("Ju lutem vendosni id tuaj per tu identifikuar qe jeni nje Punekerkues: ");
				int id = scan.nextInt();
				if (id == EmployeeOrEmployeer.EMPLOYEER.getId()) {
					System.out.println("Mire se erdhet ne app tone! Per cfare interesoheni?");
					System.out.println("1. Per te pare punet qe jane publikuar");
					System.out.println("2. Remote/ Office");
					System.out.println("3. Pozicionet sipas Pagave");
					System.out.println("Kompanite qe kane publikuar");
					System.out.println("Pozicionet vakante nga dt 10 - dt 20 shtator");
					
					int key = scan.nextInt();
					switch (key) {
					case 1: {
						
						emporifyApp.getAllJobs();
						System.out.println("A jeni e interesuar per ndonjeren prej tyre? (Po / Jo)");
						String pergj = scan.nextLine();
						if (pergj == "Po") {
							emporifyApp.getJobById(null);
						}
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + key);
					}
				}
				System.out.println();
				System.out.println("vendosni name");
				String name = scan.next();
				System.out.println("vendosni mbiemrin");
				String mbiemri = scan.next();
				System.out.println("vendosni email");
				String email = scan.next();

				break;
			}
			case 3: {
				System.out.println("Ju lutem vendosni te dhenat per librin: titull, autor, isbn, vit prodhimi, zhaner");
				String title;
				System.out.println("Vendosni titullin e librit: ");
				title = scan.next();

				if (title.length() < 2) {
				}
				System.out.println("Sa autore ka libri? ");
				int numb = scan.nextInt();
				String name;
				String surname;
				for (int i = 0; i < numb; i++) {// 3
					System.out.println("Vendosni emrin dhe mbiemrin e  autorit: " + (1 + i));
					name = scan.nextLine();
					surname = scan.nextLine();

					System.out.println("Vendosni daten e lindjes se tij:");
					String date = scan.next();
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
					LocalDate datelindja = LocalDate.parse(date, dtf);

				}
			}
			default:
				System.out.println("Zgidhni nje tjeter numer");
			}
		}
	}
}
