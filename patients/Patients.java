
package patients;
import java.util.Scanner;

public class Patients {
	
	public String name;             // ----|
	public String age;              //     |
	public String gender;           //     |
	public String ph_no;            //     |---> should be initialized through constructor
	public String problem;          //     |
	public int condition;           //     |
	public int tokenNum;            // ----|   
	
	
	public String toMainDoc;        // ----|
	public String toMBBSDoc;        //     |
	public String toNurseDoc;		//     |---> should be allocated by computer... 
	public int appointHr;           //     |
	public int appointMin;          // ----|
	
	Scanner sc = new Scanner(System.in);
	
	public Patients(){
		
	}
	
	Patients(String name, String age, String ph_no, int gender, int condition, String problem, int tokenNum){
		this.name = name;
		this.age = age;
		this.ph_no = ph_no;
		if(gender == 0) {
			this.gender = "Female".toUpperCase();
		}
		else {
			this.gender = "Male".toUpperCase();
		}
//		this.gender = gender;
		this.problem = problem;
		this.condition = condition;
		this.tokenNum = tokenNum;
	}
	

	public void assignTime(int number, String name) {
		int hour = 9 + (number/4);
		if(hour >= 13) {
			hour += 1;
		}
		this.appointHr = hour;
		
		this.appointMin = 15 * (number % 4);
		
		System.out.println(this.name + "\'s appointment have been sheduled at " + this.appointHr + " : " + this.appointMin + " upto 15 minutes to Dr." + name);
	}
	
	public boolean checkMyName(patients.Patients[] pat, int numPat) {
		
		boolean res = false;
		
			System.out.println("Enter your name : ");
			String namePat = sc.nextLine();
			
			for(int i=0;i<numPat;i++) {
				if ((pat[i].name.toLowerCase()).equals(namePat.toLowerCase())) {
					res = true;
				}
			}
			
			if (res == false) System.out.println("No names as such\nCheck Spelling or Make an Appintment\nTo make an appointment enter 6");
			else System.out.println("Your name is in the list");
		
		return false;
	}
	
	public boolean makeAppointment(patients.Patients pat[], int cur_patients, String[] specialization, int count) {
		System.out.println("Press Enter to continue : "); sc.nextLine();
		String name_of_patient = "xxx";
		System.out.println("Enter Your Name : ");
		try {
			name_of_patient = sc.nextLine();
		}
		catch(Exception e) {
			System.out.println("You have entered a wrong data:(\nTry Again\n");
			return false;
		}
		finally {
			if(name_of_patient.equals("xxx")) {
				System.out.println("You have entered a bad data:(\nTry Again\n");
				return false;
			}
		}
		
		
		String age_of_patient = "-1";
		System.out.println("Enter your age : ");
		try {
			age_of_patient = sc.nextLine();
		}
		catch(Exception e) {
			System.out.println("You have entered a wrong data:(\nTry Again\n");
			return false;
		}
		finally {
			if (age_of_patient.equals("-1")) {
				System.out.println("You have entered a bad data:(\nTry Again\n");
				return false;
			}
		}
		
		
		int gender_of_patient = -1;
		System.out.println("Enter your gender(0 for female:-) : ");
		try {
			gender_of_patient = sc.nextInt();
		}
		catch(Exception e) {
			System.out.println("You have entered a wrong data:(\nTry Again\n");
			return false;
		}
		finally {
			if (gender_of_patient == -1) {
				System.out.println("You have entered a bad data:(\nTry Again\n");
				return false;
			}
		}
		sc.nextLine();
		
		String phoneNumber_of_patient = "0";
		System.out.println("Enter your \"10 digit\" Phone number : ");
		try {
			phoneNumber_of_patient = sc.nextLine();
		}
		catch(Exception e) {
			System.out.println("You have entered a wrong data:(\nTry Again\n");
			return false;
		}
		finally {
			if (phoneNumber_of_patient.length() != 10) {
				System.out.println("You have entered a bad data:(\nTry Again\n");
				return false;
			}
		}
		
		
		int problem_of_patients = -1;
		System.out.println("\nDo you have problem in(If your problem is not here, click \"General Body\" option) :");
		for(int i=0;i<count;i++) {
			System.out.println(i+1 + ". " + specialization[i]);
		}
		
		System.out.println("====== Enter your choice: ======");
		try {
			problem_of_patients = sc.nextInt();
		}
		catch(Exception e) {
			System.out.println("You have entered a wrong data:(\nTry Again\n");
			return false;
		}
		finally {
			if(problem_of_patients < 0 || problem_of_patients >= count + 1) {
				System.out.println("You have entered a bad data:(\nTry Again\n");
				return false;
			}
			if (problem_of_patients == -1) {
				System.out.println("You have entered a bad data:(\nTry Again\n");
				return false;
			}
		}
		
		String problem_name = specialization[problem_of_patients-1];
		
		System.out.println("\nConditions: ");
		System.out.println("1.Normal\n2.Not a Emergency but some what serious\n3.Critical/Highly Emergency");
		System.out.println("Caution: This can be editted by the doctor and YOU WILL BE FINED IF THERE IS ANY CHANGE OF CONDITION done by the doctor");
		
		System.out.println("====== Enter your choice: ======");
		
		int condition_of_patients = sc.nextInt()-1;
		
		if(condition_of_patients < 0 || condition_of_patients > 2) {
			System.out.println("You have entered a bad data:(\nTry Again\n");
			return false;
		}
		
		pat[cur_patients] = new patients.Patients(name_of_patient, age_of_patient, phoneNumber_of_patient, gender_of_patient, condition_of_patients, problem_name, cur_patients+1);

		return true;
	}
	
	public void checkTokenNumber(patients.Patients[] pat, int numPat) {
		int tokNo = -1;
		
			System.out.println("Enter your name to check the Token Number: ");
			String namePat = sc.nextLine();
			
			for(int i=0;i<numPat;i++) {
				if((pat[i].name.toLowerCase()).equals(namePat.toLowerCase())) {
					tokNo = pat[i].tokenNum;
				}
			}
			
			if (tokNo == -1) System.out.println("No Token Number has been found for this given name\nCheck Spelling or Make an Appintment\nTo make an appointment enter 6");
			else System.out.println("Your token number is " + tokNo);

	}
	
	public void checkTime(patients.Patients[] pat, int countPat) {

			System.out.println("Enter your token number to check the Time of appintment: ");
			int tokNo = sc.nextInt();
			
			for(int i=0;i<countPat;i++) {
				if (pat[i].tokenNum == tokNo) {
					System.out.println("Your appointment is scheduled at time " + pat[i].appointHr + " : " + pat[i].appointMin);
					return;
				}
			}
			System.out.println("Your Appointment is not scheduled yet :(\nPress 6 to get appointment in the main menu\n");
			return ;

	}
	
	public boolean doThingsToPatients() {
		
		return true;
	}
	
	public void checkDoc(patients.Patients[] pat, int countPat) {
		
			System.out.println("Enter your token number to check the Doctor to whom you have been appointed: ");
			int tokNo = sc.nextInt();
			
			for(int i=0;i<countPat;i++) {
				if(pat[i].tokenNum == tokNo) {
					System.out.println("Your Main Doctor is Dr." + pat[i].toMainDoc);
					System.out.println("Your MBBS Doctor is Dr." + pat[i].toMBBSDoc);
					System.out.println("Your Nurse Doctors are Dr." + pat[i].toNurseDoc);
					return;
				}
			}

		System.out.println("Your Appointment is not scheduled yet :(\nPress 3 to get appointment in the main menu\n");
	}
	
	public void getAllDetails(patients.Patients[] patient, int number) {
		
		System.out.println("Enter the token Number: ");
		System.out.println("If you dont know your token number: Enter 1");
		int ch = sc.nextInt();
		sc.nextLine();
		
		if(ch == 1) {
			checkTokenNumber(patient, number);
		}
		 
		System.out.println("Enter the token Number: ");
		int tok = sc.nextInt();
		for(int i=0;i<number;i++) {
			if(patient[i].tokenNum == tok) {
				System.out.println("\n\n1.Name = " + patient[i].name + "\n2.Age = " + patient[i].age + "\n3.Gender = " + patient[i].gender + "\n4.Phone Number = " + patient[i].ph_no);
				System.out.println("5.Problem = " + patient[i].problem + "\n6.Main Doctor = " + patient[i].toMainDoc);
				if(patient[i].condition == 1) {
					System.out.println("7.MBBS Doctor = " + patient[i].toMBBSDoc);
				}
				else if(patient[i].condition == 2) {
					System.out.println("7.MBBS Doctor = " + patient[i].toMBBSDoc + "\n8.Nurse Doctor = " + patient[i].toNurseDoc);
				}
				return;
			}
		}
		System.out.println("Can't find your token number :(");
		

	}

}

	
	
	
	
	
	
	
