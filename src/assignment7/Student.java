package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
		private String firstName;
		private String lastName;
		private int iDNumber;
		private int attemptedCredits;
		private int passingCredits;
		private double totalGradeQualityPoints;
		private double bearBucks;

		public Student(String firstName, String lastName, int iDNumber) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.iDNumber = iDNumber;
			// this.attemptedCredits = attemptedCredits;
			// this.passingCredits = passingCredits;
			// this.totalGradeQualityPoints = totalGradeQualityPoints;
			// this.bearBucks = bearBucks;
		}

		
		
		//gets full name
		public String getFullName() {
			return this.firstName + " " + this.lastName;
		}

		//gets id number
		public int getId() {
			return iDNumber;
		}

		//gets attempted credits
		public int getTotalAttemptedCredits() {
			return this.attemptedCredits;
		}

		//gets grade
		public void submitGrade(double grade, int credits) {
			this.attemptedCredits += credits;

			if (grade >= 1.7) {
				this.passingCredits = this.passingCredits + credits;
			}
			this.totalGradeQualityPoints += grade * credits;

		}

		//calculates gpa
		public double calculateGradePointAverage() {
			return this.totalGradeQualityPoints / this.attemptedCredits;
		}

		//gets passing credits
		public int getTotalPassingCredits() {
			return this.passingCredits;
		}

		//returns grade
		public String getClassStanding() {
			if (this.passingCredits < 30) {
				return "First Year";
			} else if ((30 <= this.passingCredits) && (this.passingCredits < 60)) {
				return "Sophomore";
			} else if ((60 <= this.passingCredits) && (this.passingCredits < 90)) {
				return "Junior";
			} else {
				return "Senior";
			}
		}

		//returns eligiblity to frat based on gpa and attempted credits
		public boolean isEligibleForPhiBetaKappa() {
			if ((attemptedCredits >= 98 && calculateGradePointAverage() >= 3.60)
					|| (attemptedCredits >= 75 && calculateGradePointAverage() >= 3.80)) {
				return true;
			} else {
				return false;
			}
		}

		//deposits bear bucks
		public void depositBearBucks(double amount) {
			bearBucks = bearBucks + amount;
			return;
		}

		//deducts bear bucks
		public void deductBearBucks(double amount) {
			bearBucks = bearBucks - amount;
			return;
		}

		//gets current bear bucks balance
		public double getBearBucksBalance() {
			return bearBucks;
		}

		public double returnValue;

		
		//gives you cash for bear bucks
		public double cashOutBearBucks() {
			if (bearBucks > 10) {
				returnValue = bearBucks - 10;
				bearBucks = 0;
			} else {
				bearBucks = 0;
			}
			return returnValue;
		}
		
	//returns name and id
		public String toString() {
			return getFullName() + iDNumber;
		}

		//gives legacy student bear bucks and name and id
		public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) { 
		double cashOutLegacy = cashOutBearBucks()+otherParent.cashOutBearBucks();
			if(isHyphenated == true) {
			Student legacy = new Student(firstName, this.lastName + "-" + otherParent.getterMethod(), id);
			legacy.depositBearBucks(cashOutLegacy);
			return legacy;
		}
		else {
			Student legacy = new Student(firstName, this.lastName, id);
			legacy.depositBearBucks(cashOutLegacy);
			return legacy;
		}
			}
		
		public String getterMethod() {
			return lastName;
		}
		
	}
