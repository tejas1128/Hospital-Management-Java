package working;
import java.util.Scanner;

import patients.Patients;

class ThreadClass
{
	synchronized void printMsg(String msg)
	{
		System.out.println(msg);
		try {
			Thread.sleep(1500);
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
		System.out.println(".");
	}
}
	
class CreateAndExecute implements Runnable{
	String message;
	ThreadClass target;
	Thread t;
	
	public CreateAndExecute(ThreadClass tar, String msg) {
		message = msg;
		target = tar;
		t = new Thread(this );
		t.start();
	}
	
	public void run() {
		target.printMsg(message);
	}
}


public class Execute {
	
	static Scanner sc = new Scanner(System.in);
	
	// 0 for doctors , 1 for ndoctors , 2 for sdoctors.   
	static int cur_doc=0, cur_sdoc=0, cur_ndoc=0;						 //  ---
	static String doctorsNames[][] = new String[3][100];    			 //	   |	
	static int docAges[][] = new int[3][100];							 //    |
	static int docGenders[][] = new int[3][100];						 //    |           ---->>> use count array to insert something here
	static int docWorkExperience[][] = new int[3][100]; 				 //	   |
	public static String specialization[] = new String[100];			 //    |
																		 //  ---
	
	static int count[] = {0,0,0};
	
	static void displayAdminPower(doctors.Doctors[] docs , doctors.NurseDoc[] ndocs , doctors.SpecialDoc[] sdocs, int[] count, patients.Patients[] patient, int current_patients) {
		
		while(true) {
			cur_doc=count[0]; cur_sdoc=count[2]; cur_ndoc=count[1];
			System.out.println("\n1.Add a doctor\n2.Remove a doctor\n3.Show all Doctors\n4.See all patients\n5.Quit\nEnter your choice...");
			int ch = sc.nextInt();
			if(ch==1) {
				System.out.println("\n1.Add a MBBS Doctor\n2.Add a nurse\n3.Add a Specialist\n4.Quit");
				int ch1 = sc.nextInt();
				switch(ch1) {
				case 1:{
					admins.Admin administrator = new admins.Admin();
					administrator.addDocs(docs, count, doctorsNames, docAges, docGenders, docWorkExperience);
	//				System.out.print(count[0] + "    " + doctorsNames[0][count[0] - 1] + "\n");
					break;
				}
				
				case 2:{
					admins.Admin administrator = new admins.Admin();
					administrator.addnDoc(ndocs, count, doctorsNames, docAges, docGenders, docWorkExperience);
	//				System.out.print(count[1] + "    " + doctorsNames[1][count[1] - 1] + "\n");
					break;
				}
				
				case 3:{
					admins.Admin administrator = new admins.Admin();
					administrator.addsDoc(sdocs, count, doctorsNames, docAges, docGenders, docWorkExperience, specialization);
	//				System.out.print(count[2] + "    " + doctorsNames[2][count[2] - 1]);
					break;
				}
				case 4:
					return;
				}

			}
			
			else if (ch == 2) {
				System.out.println("\n1.Remove a MBBS doctor\n2.Remove a nurse\n3.Remove a Specialist\nQuit");
				int ch1 = sc.nextInt();
				switch(ch1) {
				// 0 for doctors , 1 for ndoctors , 2 for sdoctors.     
					case 1:{
						admins.Admin administrator = new admins.Admin();
						administrator.removeDocs(docs, count, doctorsNames, docAges, docGenders, docWorkExperience);
//						System.out.print(count[0] + "    " + doctorsNames[0][count[0] - 1] + "\n");
						break;
					}
					
					case 2:{
						admins.Admin administrator = new admins.Admin();
						administrator.removenDocs(ndocs, count, doctorsNames, docAges, docGenders, docWorkExperience);
//						System.out.print(count[1] + "    " + doctorsNames[1][count[1] - 1] + "\n");
						break;
					}
					
					case 3:{
						admins.Admin administrator = new admins.Admin();
						administrator.removesDocs(sdocs, count, doctorsNames, docAges, docGenders, docWorkExperience);
//						System.out.print(count[2] + "    " + doctorsNames[2][count[2] - 1]);
						break;
					}
					case 4:
						return;
				}
				
//				for (int i=0;i<3;i++) {
//					for (int j=0;j<count[i];j++) {
//						System.out.println("name : " + doctorsNames[i][j] + "   ");
//					}
//					System.out.println();
//				}
			}
			
			else if (ch == 3) {
				admins.Admin administrator = new admins.Admin();
				administrator.showAllDoc(docs, ndocs, sdocs, count);
			}
			else if(ch==5) {
				System.out.println("\n\nAdmin LogedOut Successfully\n\n");
				return;
			}
			else if(ch == 4) {
				admins.Admin administrator = new admins.Admin();
				administrator.showAllPatients(patient, current_patients);
			}
		}
	}
	
//	displayDocPower(docs, ndocs, sdocs, patients, count);
	static void displayDocPower(doctors.Doctors[] mDocs, doctors.NurseDoc[] nDocs, doctors.SpecialDoc[] sDocs, patients.Patients[] patient, int[] count) {
		while(true) {
		System.out.println("\nAre you a?\n1.Specialist Doctor\n2.MBBS Doctor\n3.Nurse Doctor\n4.Exit\nEnter your choice: ");
		int ch = sc.nextInt();
		System.out.println("\n1.See All Patients\n2.See your Patients Name");
		switch(ch) {
			case 1:{
				System.out.println("3.Edit the patient condition\n4.Exit\n");
				int innerCh = sc.nextInt();
				switch(innerCh) {
					case 1:{
						sDocs[0].showAllPatients(patient, cur_patients);
						break;
					}
					case 2:{
						sDocs[0].seeMyPatients(count[2], sDocs);
						break;
					}
					case 3:{
						sDocs[0].editPatientCondition(count[2], patient, cur_patients, sDocs);
						break;
					}
					case 4:{
						return;
					}
				}
//				System.out.println("\n1.See All Patients\n2.See your Patients Name\n3.See your Patients Details\n4.Exit\n");
				break;
			}
			
			case 2:{
				System.out.println("3.Exit\n");
				int innerCh = sc.nextInt();
				switch(innerCh) {
					case 1:{
						mDocs[0].showAllPatients(patient, cur_patients);
						break;
					}
					case 2:{
						mDocs[0].seeMyPatients(count[0], mDocs);
						break;
					}
					case 3:{
						return;
					}
				}	
//				System.out.println("\n1.See All Patients\n2.See your Patients Name\n3.See your Patients Details\n4.Exit\n");
				break;
			}
			
			case 3:{
				System.out.println("3.Exit\n");
				int innerCh = sc.nextInt();
				switch(innerCh) {
					case 1:{
						nDocs[0].showAllPatients(patient, cur_patients);
						break;
					}
					case 2:{
						nDocs[0].seeMyPatients(count[1], nDocs);
						break;
					}
					case 3:{
						return;
					}
				}
//				System.out.println("\n1.See All Patients\n2.See your Patients Name\n3.See your Patients Details\n4.Exit\n");
				break;
			}
			
			case 4:{
				return;
			}
			
		}
		}
	}
	
	static void patientsSee(patients.Patients[] patinet, int current) {
		for(int i=0;i<current;i++) {
			System.out.println(patinet[i].name + "\n" + patinet[i].age + "\n" + patinet[i].gender + "\n" + patinet[i].tokenNum + "\n" + patinet[i].ph_no + "\n" + patinet[i].condition + "\n");
		}
	}
	
	static int cur_patients = 0;
//	displayPatPower(patients, sdocs, ndocs, docs, count[0], count[1], count[2]);
	static void displayPatPower(patients.Patients[] patient, doctors.SpecialDoc[] sDocs, doctors.NurseDoc[] nDocs, doctors.Doctors[] mDocs, int d0, int n1, int s2) {
		
		System.out.println("\n\n1.Check your Name in the list\n2.My Token Number Please\n3.Check Time\n4.Check Doc\n5.Get All Your Details\n6.Make a Appointment\n7.Exit\n\nEnter your Choice : ");
		int choice = sc.nextInt();
		sc.nextLine();
		
   		switch(choice) {
			case 1:{
				if(cur_patients == 0) {
					System.out.println("You are the first here\nSo Enter option 3 followed by 6 to make a appointment with a doctor");
				}
				else {
					patient[0].checkMyName(patient, cur_patients);
				}
				break;
				
			}
			
			case 2:{
				
				if(cur_patients == 0) {
					System.out.println("You are the first here\nSo Enter option 3 followed by 6 to make a appointment with a doctor");
				}
				else {
					patient[0].checkTokenNumber(patient, cur_patients);
				}
				break;
				
			}
			
			case 3:{
				
				if(cur_patients == 0) {
					System.out.println("You are the first here\nIf you make an appointment now, your entry time will be 9:00. SO HURRY UP\nEnter option 3 followed by 6 to make a appointment with a doctor");
				}
				else {
					patient[0].checkTime(patient, cur_patients);
				}
				break;
				
			}
			
			case 4:{
				
				if(cur_patients == 0) {
					System.out.println("You are the first here\nSo you are not assigned to any doctors\nEnter option 3 followed by 6 to make a appointment with a doctor");
				}
				else {
					patient[0].checkDoc(patient, cur_patients);
				}
				break;
				
			}
			
			case 6:{
				
				if(cur_patients == 0) {
					patient[0] = new Patients();
					patient[0].name = "xxx";
				}
				
				boolean done  = patient[0].makeAppointment(patient, cur_patients, specialization, count[2]);
				
				if(done) {
					
					int num_of_patients_for_that_doctor = sDocs[0].patient_for_doctor(sDocs, s2, patient[cur_patients].problem);
					if(num_of_patients_for_that_doctor > 44) {
						sDocs[0].incrementPatientsdocs(patient[cur_patients].problem, sDocs, patient[cur_patients].name, s2, patient[cur_patients].condition);
						System.out.println("Do come here early tomorrow :)");
						return;
					}
					
					cur_patients += 1;
					
					String mainDoctorName = sDocs[0].doctor_for_patient(sDocs, patient[cur_patients-1].problem, s2);
					patient[cur_patients-1].toMainDoc = mainDoctorName;
					
					patient[cur_patients-1].assignTime(num_of_patients_for_that_doctor, mainDoctorName);
					
					if(patient[cur_patients-1].condition == 0) {
						boolean okay = sDocs[0].incrementPatientsdocs(patient[cur_patients-1].problem, sDocs, patient[cur_patients-1].name, s2, patient[cur_patients-1].condition);
						if(!okay) {
							System.out.println("Do come here early tomorrow :)");
							return;
						}
						System.out.println("\n\n");
						
					}
					
					else if(patient[cur_patients-1].condition == 1) {
						String mbbsDoctorName = mDocs[0].getMBBSDoctorName(mDocs, d0);
						if(mbbsDoctorName.equalsIgnoreCase("")) {
							System.out.println("No MBBS doctors available for further treatment. Sorry for the inconvinience caused");
							return;
						}
						else {
							patient[cur_patients-1].toMBBSDoc = mbbsDoctorName;
							System.out.println("You have been appointed to Dr. " + mbbsDoctorName + " for this Half Day");
						}
						boolean okay = mDocs[0].incrementPatientsdocs(patient[cur_patients-1].problem, sDocs, mDocs, patient[cur_patients-1].name, d0, s2, mbbsDoctorName, patient[cur_patients-1].condition);
						if(!okay) {
							System.out.println("Do come here early tomorrow :)");
							return;
						}
						System.out.println("\n\n");
					}
					
					else if(patient[cur_patients-1].condition == 2) {
						String nurseName = nDocs[0].getNurseName(nDocs, n1);
						if(nurseName.equalsIgnoreCase("")) {
							System.out.println("No NURSE doctors available for further treatment. Sorry for the inconvinience caused");
						}
						else {
							patient[cur_patients-1].toNurseDoc = nurseName;
							System.out.println("You have been appointed to Dr. " + nurseName + " for this Entire Day");
						}
						
						String mbbsDoctorName = mDocs[0].getMBBSDoctorName(mDocs, d0);
						if(mbbsDoctorName.equalsIgnoreCase("")) {
							System.out.println("No MBBS doctors available for further treatment. Sorry for the inconvinience caused");
						}	
						else {
							patient[cur_patients-1].toMBBSDoc = mbbsDoctorName;
							System.out.println("You have been appointed to Dr. " + mbbsDoctorName + " for this Half Day");
						}
						
						boolean okay = nDocs[0].incrementPatientsdocs(patient[cur_patients-1].problem, sDocs, mDocs, nDocs, patient[cur_patients-1].name, d0, s2, n1, mbbsDoctorName, nurseName, patient[cur_patients-1].condition);
						if(!okay) {
							System.out.println("Do come here early tomorrow :)");
							return;
						}
						
						if(nurseName.equalsIgnoreCase("") && mbbsDoctorName.equalsIgnoreCase("")) {
							return;
						}
						
						System.out.println("\n\n");
					}
				}
				
				else {
					return;
				}
				
				break;
			}
			
			case 5:{
				if(cur_patients == 0) {
					System.out.println("You are the first here\nEnter option 3 followed by 6 to make a appointment with a doctor");
				}
				
				else {
					patient[0].getAllDetails(patient, cur_patients);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		admins.Admin administrator = new admins.Admin();
		
		int ch, max_doc = 100, max_sdoc = 100, max_ndoc=100, max_patients = 1000; 
		boolean adminLogin = false ,docLogin = false, isPatient = false;
		
		doctors.Doctors[] docs = new doctors.Doctors[max_doc];
		doctors.SpecialDoc[] sdocs = new doctors.SpecialDoc[max_sdoc];
		doctors.NurseDoc[] ndocs = new doctors.NurseDoc[max_ndoc];
		
		patients.Patients[] patients = new patients.Patients[max_patients];
		
		administrator.initializeDocs(doctorsNames, docAges, docGenders, docWorkExperience, docs, ndocs, sdocs, count, specialization);
		cur_doc=count[0]; cur_sdoc=count[2]; cur_ndoc=count[1];
		
		String msg1 = "This is Sri Gaytri Appointment Reservation System:)\nOpening Time = 9:00am\nClosing Time = 9:00pm";
		String msg2 = "Welcome to Patient Reservation system... This is the time after which you start living happily...";
		String msg3 = "Online reservation will be before the opening timings that is from 6am to 9am";
		
		ThreadClass obj = new ThreadClass();
		CreateAndExecute obj1 = new CreateAndExecute(obj,msg1);
		CreateAndExecute obj2 = new CreateAndExecute(obj,msg2);
		CreateAndExecute obj3 = new CreateAndExecute(obj,msg3);
		
		try {
			obj1.t.join(); obj2.t.join(); obj3.t.join();
		}
		catch(Exception e) {
			System.out.println("Error");
		}
		
		while(true) {
			
			isPatient = false;
			adminLogin = false ;
			docLogin = false;
		
			System.out.println("\n\nWho are you??\n\n1.Administrator\n2.Doctor\n3.Patient\n\nEnter your choice");
			try {
				ch = sc.nextInt();
			}
			catch(Exception e) {
				return;
			}
			sc.nextLine();
			
			switch(ch) {
			
				case 1:{
					System.out.println("Enter the admin password");
					String pass = "hello";
					try {
						pass = sc.nextLine();
					}
					catch(Exception e) {
//						return;
					}
					if(pass.equals("A")) System.out.println("Successfully Logged In");
					else {
						System.out.println("LOGIN FAILED");
						adminLogin = false;
						System.exit(0);
					}
					adminLogin = true;
					break;
				}
				
				case 2:{
					System.out.println("Enter the doctor password");
					String pass = "hello";
					try {
						pass = sc.nextLine();
					}
					catch(Exception e) {
//						return;
					}
					if(pass.equals("D")) System.out.println("Successfully Logged In");
					else {
						System.out.println("LOGIN FAILED");
						docLogin = false;
						System.exit(0);
					}
					docLogin = true;
					break;
				}
				
				case 3:{
					isPatient = true;
					break;
				}
				
				case 4:{
					System.exit(0);
				}
				
			}
			
			if(adminLogin) {
				System.out.println("You are a admin");
				displayAdminPower(docs , ndocs, sdocs, count, patients, cur_patients) ;
				System.out.println("docs num : " + cur_doc + " " + cur_ndoc + " " + cur_sdoc);
			}
			
			else if(docLogin) {
				System.out.println("You are a doc");
				displayDocPower(docs, ndocs, sdocs, patients, count);
			}
			
			else if(isPatient){
				displayPatPower(patients, sdocs, ndocs, docs, count[0], count[1], count[2]);
			}
			
		}
	}
}
