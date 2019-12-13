import java.util.Arrays;

public class Okul {
	
	public String okulAdi="Atatürk Ýlkokulu";
	private Sinif[] siniflar=new Sinif[100];
	private Ogretmen[] ogretmenler=new Ogretmen[100];
	int sinifSayisi=0;
	int ogretmenSayisi=0;
	
	public void sinifEkle(Sinif sinif) {
		
		siniflar[sinifSayisi++]=sinif;

	}
	
	public void ogretmenEkle(Ogretmen ogretmen) {
		ogretmenler[ogretmenSayisi++]=ogretmen;
	}
	
	public void OgretmenAta(Sinif s,Ogretmen o) {
		s.setOgretmen(o);
		o.setSinif(s);
		
	}

	public String getOkulAdi() {
		return okulAdi;
	}

	public void setOkulAdi(String okulAdi) {
		this.okulAdi = okulAdi;
	}

	public Sinif[] getSinif() {
		return siniflar;
	}

	public void setSinif(Sinif[] sinif) {
		this.siniflar = sinif;
	}

	public Ogretmen[] getOgretmen() {
		return ogretmenler;
	}

	public void setOgretmen(Ogretmen[] ogretmen) {
		this.ogretmenler = ogretmen;
	}
	
	public void printOgretmenler() {
		System.out.println("--OGRETMENLER--");
		for (Ogretmen ogretmen : ogretmenler) {
			if (ogretmen!=null)
			  System.out.println(ogretmen);
		}
	}
	
	public void printSiniflar() {
		System.out.println("--SINIFLAR--");
		for (Sinif sinif : siniflar) {
			if (sinif!=null)
				System.out.println(sinif);
		}
	}

	public Okul(String okulAdi) {
		super();
		this.okulAdi = okulAdi;
	}


	

	
	public Okul() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Okul Adý:" + okulAdi;
	}

	
	/*
	 public static void listele()
	    {
	        System.out.println("\nMevcut Liste :");
	      
	      
			for(int i = 0; i<Okul.class.length; i++)
	        {
	            if(persons[i] != null)
	                System.out.println((i+1) + " - " + persons[i].getName() + " " + persons[i].getSurname()); 
	        }
	    }*/
	
	

	
	
	

}
