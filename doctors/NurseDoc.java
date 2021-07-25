package doctors;

public class NurseDoc extends doctors.Doctors{
	
	private String[] patients_name = new String[1];
	
	public NurseDoc(String name, int age, int experience, int gender, int num_patients, int max_patients) {
		super(name, age, experience, gender,num_patients, max_patients);
	}
	
	public boolean incrementPatientsdocs(String problem, doctors.SpecialDoc[] sDocs, doctors.Doctors[] mDocs, doctors.NurseDoc[] nDocs, String name, int mCount, int sCount, int nCount, String mDocName, String nDocName, int condition) {
		boolean proceed = mDocs[0].incrementPatientsdocs(problem, sDocs, mDocs, name, mCount, sCount, mDocName, condition);
		
		if(!proceed) {
			return false;
		}
		else {
			for(int i=0;i<nCount;i++) {
				if(nDocName.equalsIgnoreCase(nDocs[i].name)) {
					nDocs[i].patients_name[nDocs[i].num_patients] = name;
					nDocs[i].num_patients += 1;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String getNurseName(doctors.NurseDoc[] nDocs, int count) {
		String name = "";
		for(int i=0;i<count;i++) {
			if(nDocs[i].num_patients < 1) {
				name = nDocs[i].name;
				return name;
			}
		}
		return name;
	}
	
	public void seeMyPatients(int count, doctors.NurseDoc[] nDocs) {
		System.out.println("Who are you?");
		for(int i=0;i<count;i++) {
			System.out.println((i+1) + ". " + nDocs[i].name);
		}
		int docId = sc.nextInt()-1;
		
		if(nDocs[docId].num_patients == 0) {
			System.out.println("No patients Assigned for you :)");
			return;
		}
		
		for(int i=0;i<nDocs[docId].num_patients;i++) {
			System.out.println((i+1) + ". " + "Name = " + nDocs[docId].patients_name[i] + "\n");
		}
	}
	
}
