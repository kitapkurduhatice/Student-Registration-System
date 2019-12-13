
public class Ogrenci extends Kisi {
	
	int ogrenciNo;
	Sinif sinif;
	
	public Ogrenci(String name, int birthYear, genders gender) {
		super(name, birthYear, gender);
		// TODO Auto-generated constructor stub
	}

	public int getOgrenciNo() {
		return ogrenciNo;
	}

	public void setOgrenciNo(int ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}

	public Sinif getSinif() {
		return sinif;
	}

	public void setSinif(Sinif sinif) {
		this.sinif = sinif;
	}

	public Ogrenci(String name, int birthYear, genders gender, int ogrenciNo, Sinif sinif) {
		super(name, birthYear, gender);
		this.ogrenciNo = ogrenciNo;
		setSinif (sinif); //this.sinif=sinif; aynýsýdýr.
		sinif.ogrenciKayit(this);
	}

	@Override
	public String toString() {
		return "Ogrenci [ogrenciNo=" + ogrenciNo + ", sinif=" + sinif + ", name=" + name + ", birthYear=" + birthYear
				+ ", gender=" + gender + "]";
	}

	
	
	

	

}
