package doctors;

import java.util.Scanner;

public class Doctors implements inter.Inter{
	
	public String name;
	public int age;
	public int experience;
	public int gender;
	public int num_patients = 0;
	public int max_patients;
	private String[] patientsToDoc = new String[6];
	
	Scanner sc = new Scanner(System.in);
	
	public Doctors(String name, int age, int experience, int gender, int num_patients, int max_patients) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.experience = experience;
		this.num_patients = num_patients;
		this.max_patients = num_patients;
	}
	
	public void showAllPatients(patients.Patients[] patient, int cur_patients) {
		
		if(cur_patients == 0) {
			System.out.println("No patients at this time :)");
			return;
		}
		
		for(int i=0;i<cur_patients;i++) {
			System.out.println("1.Token Number = " + patient[i].tokenNum);
			System.out.println("2.Name = " + patient[i].name);
			System.out.println("3.Age = " + patient[i].age);
			System.out.println("4.Gender = " + patient[i].gender);
			System.out.println("5.Phone number = " + patient[i].ph_no);
			System.out.println("6.Problem = " + patient[i].problem);
			System.out.println("=====================================================================\n");
		}
	}
	
	public void seeMyPatients(int count, doctors.Doctors[] mDocs) {
		System.out.println("Who are you?");
		for(int i=0;i<count;i++) {
			System.out.println((i+1) + ". " + mDocs[i].name);
		}
		
		int docId = sc.nextInt()-1;
		
		if(mDocs[docId].num_patients == 0) {
			System.out.println("No patients Assigned for you :)");
			return;
		}
		
		for(int i=0;i < mDocs[docId].num_patients ; i++) {
			System.out.println((i+1) + ". " + "Name = " + mDocs[docId].patientsToDoc[i] + "\n");
		}
	}
	
	public boolean incrementPatientsdocs(String problem, doctors.SpecialDoc[] sDocs, doctors.Doctors[] mDocs, String name, int mCount, int sCount, String docName, int condition) {
		
		boolean proceed = sDocs[0].incrementPatientsdocs(problem, sDocs, name, sCount, condition);
		if(!proceed) {
			return false;
		}
		else {
			for(int i=0;i<mCount;i++) {
				if(docName.equalsIgnoreCase(mDocs[i].name)) {
					mDocs[i].patientsToDoc[mDocs[i].num_patients] = name;
					mDocs[i].num_patients += 1;
					return true;
				}
			}
			return true;
		}
	}
	
	public String getMBBSDoctorName(doctors.Doctors[] docs, int count) {
		String name = "";
		for(int i=0;i<count;i++) {
			if(docs[i].num_patients < 2) {
				name = docs[i].name;
				return name;
			}
		}
		return name;
	}
	
}

