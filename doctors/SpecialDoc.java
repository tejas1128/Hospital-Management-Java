package doctors;

import java.util.Scanner;

public class SpecialDoc extends doctors.Doctors{
	
	public String specialization;
	private String[] patients_name = new String[11*4];
	private int[] patients_condition = new int[11*4];
	
	Scanner sc = new Scanner(System.in);
	
	public SpecialDoc(String name, int age, int experience, int gender, int num_patients, int max_patients, String specialization) {
		super(name, age, experience, gender, num_patients, max_patients);
		this.specialization = specialization;
	}
	
	public boolean incrementPatientsdocs(String problem, doctors.SpecialDoc[] doctors, String name, int count, int condition) {
		for(int i=0;i<count;i++) {
			if(doctors[i].specialization.equalsIgnoreCase(problem)) {
				if(doctors[i].num_patients > 44) {
					System.out.println("Appointment for " + doctors[i].specialization + " Specialist has been over\nTry tommorrow :) ");
					return false;
				}
				else {
					doctors[i].patients_name[doctors[i].num_patients] = name;
					doctors[i].patients_condition[doctors[i].num_patients] = condition;
					doctors[i].num_patients += 1;
				}
			}
		}
		return true;
	}
	
	public void seeMyPatients(int count, doctors.SpecialDoc[] sDocs) {
		System.out.println("Who are you?");
		for(int i=0;i<count;i++) {
			System.out.println((i+1) + ". " + sDocs[i].name);
		}
		int docId = sc.nextInt()-1;
		
		if(sDocs[docId].num_patients == 0) {
			System.out.println("No patients Assigned for you :)");
			return;
		}
		
		for(int i=0 ; i < sDocs[docId].num_patients ; i++) {
			System.out.println((i+1) + ". " + "Name = " + sDocs[docId].patients_name[i]);
			int conditionNumber = sDocs[docId].patients_condition[i];
			if(conditionNumber == 0) {
				System.out.println(" . Condition = " + "Normal");
			}
			else if(conditionNumber == 1) {
				System.out.println(" . Condition = " + "Fine");
			}
			else if(conditionNumber == 2) {
				System.out.println(" . Condition = " + "Critical");
			}
			System.out.println("========================================\n");
		}
		
	}
	
	public int patient_for_doctor(doctors.SpecialDoc[] doctors, int count, String problem) {
		int number = 0;
		for(int i=0;i<count;i++) {
			if(doctors[i].specialization.equalsIgnoreCase(problem)) {
				number = doctors[i].num_patients;
			}
		}
		return number;
	}
	
	public String doctor_for_patient(doctors.SpecialDoc[] doctor, String problem, int count) {
		String doctorName = "";
		for(int i=0;i<count;i++) {
			if(doctor[i].specialization.equalsIgnoreCase(problem)) {
				doctorName = doctor[i].name;
			}
		}
		return doctorName;
	}
	
	public void editPatientCondition(int count, patients.Patients[] pat, int current, doctors.SpecialDoc[] doc) {
		System.out.println("Who are you? ");
		for(int i=0;i<count;i++) {
			System.out.println((i+1) + ". " + doc[i].name);
		}
		int docId = sc.nextInt()-1;
		
		if(current == 0) {
			System.out.println("No patients available :(");
			return;
		}
		
		System.out.println("\nWhich patient condition do you want to edit? ");
		
		for(int i=0;i<doc[docId].num_patients;i++) { //sDocs[docId].patients_name[i]
			System.out.println((i+1) + ". " + doc[docId].patients_name[i]);
		}
		
		
		int patientNumber = sc.nextInt()-1;
		
		int beforeEditting = patients_condition[patientNumber];
		System.out.println("The current condition is " + (beforeEditting+1));
		
		System.out.println("Enter the condition to which you want to modify: ");
		System.out.println("1.Normal\n2.Not a Emergency but some what serious\n3.Critical/Highly Emergency");
		System.out.println("====== Enter your choice: ======");
		int conditionOfPat = sc.nextInt()-1;
		
		patients_condition[patientNumber] = conditionOfPat;
		
		String patientName = patients_name[patientNumber];
		
		for(int i=0;i<current;i++) {
			if(pat[i].name.equalsIgnoreCase(patientName) && pat[i].condition == beforeEditting) {
				pat[i].condition = conditionOfPat;
				try {
					Thread.sleep(1000);
					System.out.println("Successfully eddited condition of " + pat[i].name + " from " + (beforeEditting+1) + " to " + (conditionOfPat+1));
				}
				catch(Exception e) {
					System.out.println("Error in updating the content:(");
				}
				
			}
		}

		return;
	}
	
}

























