public class Ogretmen extends Kisi {
	int sicilNo;
	Sinif sinif;
	Okul okul;
	
	
	public int getSicilNo() {
		return sicilNo;
	}
	public void setSicilNo(int sicilNo) {
		this.sicilNo = sicilNo;
	}
	public Sinif getSinif() {
		return sinif;
	}
	public void setSinif(Sinif sinif) {
		this.sinif = sinif;
		sinif.setOgretmen(this);
	}
	public Okul getOkul() {
		return okul;
	}
	public void setOkul(Okul okul) {
		this.okul = okul;
		okul.ogretmenEkle(this);
	}
	public Ogretmen(String name, int birthYear,int sicilNo, Okul okul,Sinif sinif) {
		super(name, birthYear);
		// TODO Auto-generated constructor stub
	}
	
	public Ogretmen(String name, int birthYear, genders gender, int sicilNo, Okul secilmisokul, Sinif secilmissinif) {
		super(name, birthYear, gender);
		this.sicilNo = sicilNo;
	}
	
	
	public Ogretmen(String name, int birthYear, genders gender, int sicilNo, Sinif sinif, Okul okul) {
		super(name, birthYear, gender);
		this.sicilNo = sicilNo;
		this.sinif = sinif;
		this.okul = okul;
		okul.ogretmenEkle(this);
		
	}
	public Ogretmen(String name, int birthYear, genders gender, int sicilNo, Okul okul) {
		super(name, birthYear, gender);
		this.sicilNo = sicilNo;
		this.okul = okul;
		okul.ogretmenEkle(this);
	}

	

	
	public Ogretmen() {
		super();
	}
	@Override
	public String toString() {
		return "Ogretmen [sicilNo=" + sicilNo + ", okul=" + okul + ", name=" + name
				+ ", birthYear=" + birthYear + ", gender=" + gender + "]";
	}
	

}
