package studio9;

import java.util.HashMap;

import assignment7.Student;

public class UniversityDatabase {
	private HashMap<String, Student> dataBase;

	public UniversityDatabase() {
		dataBase=new HashMap<String, Student>();
	}
	public UniversityDatabase(HashMap<String, Student> iNeededAName) {
		dataBase=iNeededAName;
	}

	public void addStudent(String accountName, Student student) {
		dataBase.put(accountName, student);
	}

	public int getStudentCount() {
		int studentCount = dataBase.size();
		return studentCount;
	}

	public String lookupFullName(String accountName) {
		Student studentHere = dataBase.get(accountName);
		String name = studentHere.getFullName();
		return name;
	}

	public double getTotalBearBucks() {
		double bearBucksCount = 0;
		for(int i=0; i<dataBase.size(); i++) {
		Student studentHere = dataBase.get(i);
		bearBucksCount += studentHere.getBearBucksBalance();

		}
		return bearBucksCount;
	}
}
