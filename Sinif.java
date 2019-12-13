import java.util.Arrays;

public class Sinif {
	
	int sinifNo;
	char sinifSube;
	Okul okul;
	Ogretmen ogretmen;
	private Ogrenci[] ogrenciler=new Ogrenci[100];
	int ogrenciSayisi=0;

	
	public Ogrenci[] getOgrenciler() {
		return ogrenciler;
	}

	public void setOgrenciler(Ogrenci[] ogrenciler) {
		this.ogrenciler = ogrenciler;
	}

	public void ogrenciKayit(Ogrenci ogrenci) {
		ogrenciler[ogrenciSayisi++]=ogrenci;
		ogrenci.setSinif(this);
		
	}

	public int getSinifNo() {
		return sinifNo;
	}

	public void setSinifNo(int sinifNo) {
		this.sinifNo = sinifNo;
	}

	public char getSinifSube() {
		return sinifSube;
	}

	public void setSinifSube(char sinifSube) {
		this.sinifSube = sinifSube;
	}

	public Okul getOkul() {
		return okul;
	}

	public void setOkul(Okul okul) {
		this.okul = okul;
		okul.sinifEkle(this);
	}

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

	public void printOgrenciler() {
		System.out.println("--ÖĞRENCİLER--"+ this);
		
		for (Ogrenci ogrenci : ogrenciler) {
			if(ogrenci!=null)
				System.out.println(ogrenci);
		}
	}


	public void setOgrenci(Ogrenci[] ogrenci) {
		this.ogrenciler = ogrenci;
	}

	public Sinif() {
		super();
	}
	
	public Sinif(int sinifNo, char sinifSube) {
		super();
		this.sinifNo = sinifNo;
		this.sinifSube = sinifSube;
		okul.sinifEkle(this);

	}

	public Sinif(int sinifNo, char sinifSube, Okul okul) {
		super();
		this.sinifNo = sinifNo;
		this.sinifSube = sinifSube;
		this.okul = okul;
		okul.sinifEkle(this);
	}

	public Sinif(int sinifNo, char sinifSube, Okul okul, Ogretmen ogretmen) {
		super();
		this.sinifNo = sinifNo;
		this.sinifSube = sinifSube;
		this.okul = okul;
		this.ogretmen = ogretmen;
		okul.sinifEkle(this);
	}

	@Override
	public String toString() {
		return "Sinif [Sınıf No: " + sinifNo + " Sınıf Şubesi: " + sinifSube + " Okul: " + okul + " Öğretmen: " + ogretmen+"]";
	}



	

	
	
	

}
