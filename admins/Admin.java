package admins;
import java.util.*;

public class Admin implements inter.Inter{
	Scanner sc = new Scanner(System.in);
	
	public void showAllPatients(patients.Patients[] patient, int cur_patients) {
		for(int i=0;i<cur_patients;i++) {
			System.out.println("1. Token Number = " + patient[i].tokenNum);
			System.out.println("2. Name = " + patient[i].name);
			System.out.println("3. Age = " + patient[i].age);
			System.out.println("4. Gender = " + patient[i].gender);
			System.out.println("5. Phone number = " + patient[i].ph_no);
			System.out.println("6. Problem = " + patient[i].problem);
			System.out.println("7. Main Doctor = " + patient[i].toMainDoc);
			System.out.println("8. Hour = " + patient[i].appointHr);
			System.out.println("9. Minutes = " + patient[i].appointMin);
			if(patient[i].condition >= 1) {
				System.out.println("10. MBBS Doctor = " + patient[i].toMBBSDoc);
				if(patient[i].condition == 2){
					System.out.println("11. Nurse Doctor = " + patient[i].toNurseDoc);
				}
			}
			
			System.out.println("=====================================================================\n");
		}
	}
	
	public void initializeDocs(String[][] D, int[][] A, int[][] G, int[][] E, doctors.Doctors[] docs, doctors.NurseDoc[] ndocs, doctors.SpecialDoc[] sdocs, int[] count, String[] specialization) {
		
		String docName[][] = {{"Raghav".toUpperCase(),"Rajini".toUpperCase(),"Darshit".toUpperCase(),"Prashanth".toUpperCase()},{"Kamala".toUpperCase(),"Vimala".toUpperCase(),"Charana".toUpperCase(),"Bhavana".toUpperCase(),"Anusha".toUpperCase(),"Pradyumna".toUpperCase(),"Prajwal".toUpperCase(),"Somiya".toUpperCase()},{"Sindhu".toUpperCase(), "DeviPrasaad".toUpperCase(), "Manjunath".toUpperCase(), "Chutki".toUpperCase(), "Tina".toUpperCase()}};
		int age[][] = {{41,23,57,63},{41,25,46,53,36,41,58,74},{25,35,45,55,65}};
		int[][] gender = {{1,0,1,1},{0,0,1,0,0,1,1,0},{0,1,1,0,0}};
		int[][] work = {{12,14,19,9},{24,19,25,14,5,32,17,20},{2,12,23,28,35}};
		int num_patients[][] = {{0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0}};
		int[][] max_patients = {{6,6,6,6},{2,2,2,2,2,2,2,2},{11*4, 11*4, 11*4, 11*4, 11*4}};
		specialization[0] = "Pediatric".toUpperCase(); specialization[1] = "Surgery".toUpperCase(); specialization[2] = "Genreal body".toUpperCase(); specialization[3] = "Opthamology".toUpperCase(); specialization[4] = "Dermatology".toUpperCase();
		
		for(int i=0;i<docName[0].length;i++) {
			docs[i] = new doctors.Doctors(docName[0][i].toUpperCase(), age[0][i], work[0][i], gender[0][i], num_patients[0][i], max_patients[0][i]);
			count[0]++;
		}
		
		for(int i=0;i<docName[1].length;i++) {
			ndocs[i] = new doctors.NurseDoc(docName[1][i].toUpperCase(), age[1][i], work[1][i], gender[1][i], num_patients[1][i], max_patients[1][i]);
			count[1]++;
		}
		
		for(int i=0;i<docName[2].length;i++) {
			sdocs[i] = new doctors.SpecialDoc(docName[2][i].toUpperCase(), age[2][i], work[2][i], gender[2][i], num_patients[2][i], max_patients[2][i], specialization[i].toUpperCase());
			count[2]++;
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<count[i];j++) {
				D[i][j] = docName[i][j];
				A[i][j] = age[i][j];
				G[i][j] = gender[i][j];
				E[i][j] = work[i][j];
			}
		}
		
	}
	
	public void addDocs(doctors.Doctors[] docs, int count[], String doctorsNames[][], int docAges[][], int docGenders[][], int docWorkExperience[][]) {
		int n = 0;
		System.out.print("Enter doctor name: ");
		String name = sc.nextLine().toUpperCase();
		System.out.print("Enter doctor age: ");
		int age = sc.nextInt();
		System.out.print("Enter doctor experience: ");
		int ex = sc.nextInt();
		System.out.print("Enter doctor gender: ");
		int gender = sc.nextInt();
		int max_patients = 6;
		int num_patients = 0;
		
		docs[count[n]] = new doctors.Doctors(name, age, ex, gender, num_patients, max_patients);
		
		doctorsNames[n][count[n]] = name;
		docWorkExperience[n][count[n]] = ex;
		docAges[n][count[n]] = age;
		docGenders[n][count[n]] = gender;
		count[n]++;
		
	}
	
	public void addnDoc(doctors.NurseDoc[] ndocs, int count[], String doctorsNames[][], int docAges[][], int docGenders[][], int docWorkExperience[][]) {
		System.out.print("Enter nurse name: ");
		String name = sc.nextLine().toUpperCase();
		System.out.print("Enter nurse age: ");
		int age = sc.nextInt();
		System.out.print("Enter nurse experience: ");
		int ex = sc.nextInt();
		System.out.print("Enter nurse gender: ");
		int gender = sc.nextInt();
		int max_patients = 2;
		int num_patients = 0;
		int n = 1;
		
		ndocs[count[n]] = new doctors.NurseDoc(name, age, ex, gender, num_patients, max_patients);
		doctorsNames[n][count[n]] = name;
		docWorkExperience[n][count[n]] = ex;
		docAges[n][count[n]] = age;
		docGenders[n][count[n]] = gender;
		count[n]++;
	}
	
	public void addsDoc(doctors.SpecialDoc[] sdocs, int count[], String doctorsNames[][], int docAges[][], int docGenders[][], int docWorkExperience[][], String specializationArr[]) {
		int n=2;
		System.out.print("Enter specialist's name: ");
		String name = sc.nextLine().toUpperCase();
		System.out.print("Enter specialist's specialization: ");
		String specialization = sc.nextLine().toUpperCase();
		System.out.print("Enter specialist's age: ");
		int age = sc.nextInt();
		System.out.print("Enter specialist's experience: ");
		int ex = sc.nextInt();
		System.out.print("Enter specialist's gender: ");
		int gender = sc.nextInt();
		
		int max_patients = 2;
		int num_patients = 0;
		
		sdocs[count[n]] = new doctors.SpecialDoc(name, age, ex, gender, num_patients, max_patients, specialization);
		doctorsNames[n][count[n]] = name;
		docWorkExperience[n][count[n]] = ex;
		docAges[n][count[n]] = age;
		docGenders[n][count[n]] = gender;
		specializationArr[count[n]] = specialization;
		count[n]++;
	}
	
	public void showAllDoc(doctors.Doctors[] docs, doctors.NurseDoc[] ndocs, doctors.SpecialDoc[] sdocs, int[] count) {
		
		if(count[0] == 0) {
			System.out.println("===================There are no MBBS Doctorss===================\n");
		}
		else {
			System.out.println("\n\nThee MBBS DOCTORS WORKING HERE ARE\n");
			
			for(int i=0;i<count[0];i++) {
				System.out.print(docs[i].name + " " + docs[i].age + " ");
				if(docs[i].gender == 0) System.out.print("Female ");
				else System.out.print("Male ");
				System.out.println(docs[i].experience + "\n");
			}
		}
		
		
		if(count[2] == 0) {
			System.out.println("=====================There are no Specialist Doctorss===================\n");
		}
		else {
			System.out.println("\n\nThee SPECIALIST DOCTORS WORKING HERE ARE\n");
			
			for(int i=0;i<count[2];i++) {
				System.out.print(sdocs[i].name + " " + sdocs[i].age + " ");
				if(sdocs[i].gender == 0) System.out.print("Female ");
				else System.out.print("Male ");
				System.out.println(sdocs[i].experience + " " + sdocs[i].specialization + "\n");
			}
		}

		if(count[1] == 0) {
			System.out.println("===================There are no Nurse Doctorss===================\n");
		}
		else {
			System.out.println("\n\nThee NURSE DOCTORS WORKING HERE ARE\n");
			
			for(int i=0;i<count[1];i++) {
				System.out.print(ndocs[i].name + " " + ndocs[i].age + " ");
				if(ndocs[i].gender == 0) System.out.print("Female ");
				else System.out.print("Male ");
				System.out.println(ndocs[i].experience + "\n");
			}
		}
		
	}
	
	public void removeDocs(doctors.Doctors[] docs, int[] count, String doctorsNames[][], int docAges[][], int docGenders[][], int docWorkExperience[][]) {
		
		int n = 0;
		if(count[n] == 0) {
			System.out.println("No MBBS Doctors available for you to delete :(");
		}
		
		else {
			
			
			for(int i = 0; i < count[n]; i++) {
				System.out.println((i+1) + ".  " + docs[i].name);
			}
			System.out.println("Which Doctor Do You Want To Delete from The Above List?");
			int delChoice = sc.nextInt() - 1;
			
			System.out.println("\nAre you sure to delete (0 to cancel Deleting)");
			System.out.print("Dr." + docs[delChoice].name + " of " + docs[delChoice].age + " years of age, with ");
			System.out.println(docs[delChoice].experience + " years of experience ??? \n");
			
			int confirm = sc.nextInt();
			
			if(confirm != 0) {
				try {
					
					System.out.println("Deleting the Doctor Record...");
					
					for (int i = delChoice; i<count[n]-1; i++) {
						
						doctorsNames[n][i] = doctorsNames[n][i+1];
						docAges[n][i] = docAges[n][i+1];
						docGenders[n][i] = docGenders[n][i+1];
						docWorkExperience[n][i] = docWorkExperience[n][i+1];
						
						docs[i] = docs[i+1];
						
					}
					
					count[n]--;
					Thread.sleep(1500);
					
					System.out.println("Successfully deleted the record :)");
					
				}
				catch(Exception e) {
					System.out.println("Unable to delete the Doctor Record\nTry again later");
				}
			}
			
			else {
				System.out.println("Deleting the Doctor has Successfully cancelled");
			}
		}
		
		System.out.println("Count = " + count[n]);
		
	}
	
	public void removenDocs(doctors.NurseDoc[] ndocs, int[] count, String doctorsNames[][], int docAges[][], int docGenders[][], int docWorkExperience[][]) {
		int n = 1;
		if(count[n] == 0) {
			System.out.println("No Nurse Doctors available for you to delete :(");
		}
		
		else {
			
			
			for(int i = 0; i < count[n]; i++) {
				System.out.println((i+1) + ".  " + ndocs[i].name);
			}
			System.out.println("Which Nurse Doctor Do You Want To Delete from The Above List?");
			int delChoice = sc.nextInt() - 1;
			
			System.out.println("\nAre you sure to delete (0 to cancel Deleting)");
			System.out.print("Dr." + ndocs[delChoice].name + " of " + ndocs[delChoice].age + " years of age, with ");
			System.out.println(ndocs[delChoice].experience + " years of experience ??? \n");
			
			int confirm = sc.nextInt();
			
			if(confirm != 0) {
				try {
					
					System.out.println("Deleting the Doctor Record...");
					
					for (int i = delChoice; i<count[n]-1; i++) {
						
						doctorsNames[n][i] = doctorsNames[n][i+1];
						docAges[n][i] = docAges[n][i+1];
						docGenders[n][i] = docGenders[n][i+1];
						docWorkExperience[n][i] = docWorkExperience[n][i+1];
						
						ndocs[i] = ndocs[i+1];
						
					}
					
					count[n]--;
					Thread.sleep(1500);
					
					System.out.println("Successfully deleted the record :)");
					
				}
				catch(Exception e) {
					System.out.println("Unable to delete the Doctor Record\nTry again later");
				}
			}
			
			else {
				System.out.println("Deleting the Doctor has Successfully cancelled");
			}
		}
		System.out.println("Count = " + count[n]);
	}
	
	public void removesDocs(doctors.SpecialDoc[] sdocs, int[] count, String doctorsNames[][], int docAges[][], int docGenders[][], int docWorkExperience[][]) {
		int n = 2;
		if(count[n] == 0) {
			System.out.println("No Specialist Doctors available for you to delete :(");
		}
		
		else {
			
			
			for(int i = 0; i < count[n]; i++) {
				System.out.println((i+1) + ".  " + sdocs[i].name);
			}
			System.out.println("Which Specialist Doctor Do You Want To Delete from The Above List?");
			int delChoice = sc.nextInt() - 1;
			
			System.out.println("\nAre you sure to delete (0 to cancel Deleting)");
			System.out.print("Dr." + sdocs[delChoice].name + " of " + sdocs[delChoice].age + " years of age, with ");
			System.out.println(sdocs[delChoice].experience + " years of experience ??? \n");
			
			int confirm = sc.nextInt();
			
			if(confirm != 0) {
				try {
					
					System.out.println("Deleting the Doctor Record...");
					
					for (int i = delChoice; i<count[n]-1; i++) {
						
						doctorsNames[n][i] = doctorsNames[n][i+1];
						docAges[n][i] = docAges[n][i+1];
						docGenders[n][i] = docGenders[n][i+1];
						docWorkExperience[n][i] = docWorkExperience[n][i+1];
						
						sdocs[i] = sdocs[i+1];
						
					}
					
					count[n]--;
					Thread.sleep(1500);
					
					System.out.println("Successfully deleted the record :)");
					
				}
				catch(Exception e) {
					System.out.println("Unable to delete the Doctor Record\nTry again later");
				}
			}
			
			else {
				System.out.println("Deleting the Doctor has Successfully cancelled");
			}
		}
		System.out.println("Count = " + count[n]);
	}

}
