
public class Kisi {
	String name;
	int birthYear;
	genders gender;
	
	public enum genders{
		K
	   ,E;
	   /*char value;
		genders(char val){
			value=val;
		}*/
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public genders getGender() {
		return gender;
	}

	public void setGender(genders gender) {
		this.gender = gender;
	}
	
	

	public Kisi() {
		super();
	}

	public Kisi(String name, int birthYear, genders gender) {
		super();
		this.name = name;
		this.birthYear = birthYear;
		this.gender = gender;
	}
	
	

	public Kisi(String name, int birthYear) {
		super();
		this.name = name;
		this.birthYear = birthYear;
	}

	@Override
	public String toString() {
		return "İsim: " + name + " Doğum Yılı: " + birthYear + " Cinsiyet: " + gender;
	}


	
	
	
	
	

}
