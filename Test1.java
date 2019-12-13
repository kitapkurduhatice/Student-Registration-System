import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Test1 {
	private static Okul secilmisokul = null;
	private static Sinif secilmissinif = null;
	//private static Ogretmen secilmisogretmen = null;
	static private Okul[] okullar = new Okul[100];
	static int okulSayisi = 0;
	static int sinifSayisi = 0;
	static Scanner input = new Scanner(System.in);
	public static Okul okul=new Okul();
	public static Sinif sinif=new Sinif();
	public static Ogretmen ogretmen=new Ogretmen();

	public static void dosyaOkuma() throws IOException {
		try {
			Scanner s = new Scanner(new File("siniflar.txt"));
			Scanner s1 = new Scanner(new File("ogretmen.txt"));
			while (s.hasNext()) {
				String satir = s.nextLine();
				System.out.println(satir);
			}
			s.close();
			while (s1.hasNext()) {
				String satir = s1.nextLine();
				System.out.println(satir);
			}
			s1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
		
	
	public void OkulEkle(Okul okul1) {

		okullar[okulSayisi++] = okul1;
	}

	public static void okulSecilmeKontrol() {
		if (secilmisokul != null) {
			System.out.println("Seçilen okul: "+secilmisokul.okulAdi);

		} else {
			System.out.println("Seçilen okul: Seçilmemiþ");
		}

	}

	public static void sinifSecilmeKontrol() {
		if (secilmissinif != null) {
			System.out.println("Seçilen sýnýf: " + secilmissinif.sinifNo + "/" + secilmissinif.sinifSube);
		} else {
			System.out.println("Seçilen okul: Seçilmemiþ");
		}

	}
	
	public static void cikis() {
		System.out.println("Güle güle");
	}

	public static void anaMenu() {
		System.out.println();
		System.out.println("MENÜ");
		okulSecilmeKontrol();
		System.out.println("Okul Ýþlemleri     -> 1\n" + "Sýnýf Ýþlemleri    -> 2\n"
				+ "Öðretmen Ýþlemleri -> 3\n" + "Öðrenci Ýþlemleri  -> 4\n" + "Çýkýþ              -> 5\n");
		System.out.print("Seçiminiz: ");
		
		
		int secim = input.nextInt();
		if(secim==1) {
			printOkulMenu();
			OkulIslemleri();
		}
		else if(secim==2 && secilmisokul!=null) {
			printSinifMenu();
			SinifIslemleri();
			
		}
		else if(secim==3 && secilmisokul!=null) {
			printOgretmenMenu();
			OgretmenIslemleri();
		}
		else if(secim==4 && secilmisokul!=null) {
			printOgrenciMenu();
			OgrenciIslemleri();
			
		}
		else if(secim==5)
		{
			cikis();
		}
		
				
	}

	public static void printOkulMenu() {
		System.out.println();
		System.out.println("Seçilen Okul: ");
		System.out.println("(Okul Ýþlemleri Menüsü)" + "\n" + "Ekleme      -> 1\n" + "Listeleme   -> 2\n"
				+ "Okul seçimi -> 3\n" + "Ana menü    -> 4\n");
		System.out.print("Seçiminiz: ");
	}

	public static void printSinifMenu() {
		System.out.println();
		System.out.println("(Sýnýf Ýþlemleri Menüsü)");
		sinifSecilmeKontrol();
		System.out.println("Ekleme         -> 1\n" + "Listeleme      -> 2\n"
				+ "Sýnýf seçimi   -> 3\n" + "Öðretmen Atama -> 4\n" + "Öðrenci Kayýt  -> 5\n"
				+ "Ana menü       -> 6\n");
		System.out.print("Seçiminiz: ");
	}

	public static void printOgretmenMenu() {
		System.out.println();
		System.out.println(
				"(Öðretmen Ýþlemleri Menüsü)" + "\n" + "Ekleme    -> 1\n" + "Listeleme -> 2\n" + "Ana menü  -> 3\n");
		System.out.print("Seçiminiz: ");
	}

	public static void printOgrenciMenu() {
		System.out.println();
		System.out.println("(Öðrenci Ýþlemleri Menüsü)" + "\n" + "Listeleme -> 1\n" + "Ana menü  -> 2\n");
		System.out.print("Seçiminiz: ");
	}

	public static void OkulIslemleri() {
		int secim = input.nextInt();
		if (secim == 1) {
			System.out.print("Okul adý giriniz: ");
			String okulAdi=input.next();
			Okul okul=new Okul(okulAdi);
			okullar[okulSayisi++]=okul;
			System.out.print(okul.okulAdi+" eklendi.");
		//	secilmisokul=new Okul(okul);
			System.out.println();
				

			

		} else if (secim == 2) {
			System.out.println("Listelenecek okullar: ");
			for (int i = 0; i < okullar.length; i++) {
				if (!(okullar[i] == null)) {
					System.out.println((i + 1) + " - " + okullar[i]);
				}

			}

		}
		
		else if(secim==3) {
			int index = -1;
	        System.out.println("\nSeçilecek okulun indeksi: ");
	        index = input.nextInt();
	        if(index-1 < okullar.length && okullar[index-1] != null)
	        {
	        	secilmisokul = okullar[index-1];
	        }
	        System.out.println("Seçilen okullar: ");
			System.out.println(secilmisokul.getOkulAdi());
			
		}
		else if(secim==4) {
			anaMenu();
		}
		printOkulMenu();
		OkulIslemleri();
		

	}
	
	
	
	public static void SinifIslemleri() {
		int secim = input.nextInt();
		if (secim == 1) {
			System.out.print("Sýnýfý giriniz: ");
			int sinifNo=input.nextInt();
			System.out.print("Þubeyi giriniz: ");
			char sinifSube=input.next().charAt(0);
			Sinif sinif=new Sinif(sinifNo,sinifSube,secilmisokul);
			secilmisokul.getSinif()[sinifSayisi++]=sinif;
			File file = new File("siniflar.txt");
			try {
				FileOutputStream input = new FileOutputStream(file, true);
				String data = (sinif.sinifNo + sinif.sinifSube + "-" + secilmisokul.getOkulAdi());
				input.write(data.getBytes());
				
				

				input.flush();
				System.out.println();
				input.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.print(sinif.sinifNo+" / "+sinif.sinifSube +" eklendi.");
			System.out.println();
				

			

		} else if (secim == 2) {
			System.out.println("Listelenecek sýnýflar: ");
			for (int i = 0; i < secilmisokul.getSinif().length; i++) {
				if (!(secilmisokul.getSinif()[i] == null)) {
					System.out.println((i + 1) + " - " + secilmisokul.getSinif()[i]);
				}

			}
			//printSiniflar() 

		}
		
		else if(secim==3) {
			int index = -1;
	        System.out.println("\nSeçilecek sýnýfýn indeksi: ");
	        index = input.nextInt();
	        if(index-1 < secilmisokul.getSinif().length && secilmisokul.getSinif()[index-1] != null)
	        {
	        	secilmissinif = secilmisokul.getSinif()[index-1];
	        }
	        System.out.println("Seçilen sýnýflar: ");
			System.out.println(secilmissinif.getSinifNo()+" / "+secilmissinif.getSinifSube());
			
		}
		else if(secim==4 && secilmissinif!=null) {
			Ogretmen o1=new Ogretmen("Kemal Uçar",1982,Kisi.genders.E,123456, okul);
			okul.OgretmenAta(secilmissinif, o1);
			okul.printOgretmenler();
			
		}
		//dipnot: alanlar fazla olduðu için kendim giriþ yaptýrdým
		else if(secim==5 && secilmissinif!=null) {
			Ogrenci ogr1=new Ogrenci("Kemal Uçar",1982,Kisi.genders.E,123456,sinif);
			sinif.ogrenciKayit(ogr1);
			System.out.println(ogr1);
		}
		else if(secim==6) {
			anaMenu();
		}
		printSinifMenu();
		SinifIslemleri();
	
	}
	
	public static void OgretmenIslemleri()  {
		int secim = input.nextInt();
		final  File file=new File("ogretmen.txt");
		if(secim==1)
		
		{Ogretmen ogretmen = null;
			
			System.out.print("Öðretmen adýný giriniz: ");
			String adi=input.next();
			System.out.println("Öðretmen doðum yýlýný giriniz:");
			int dogumYili=input.nextInt();
			System.out.println("Öðretmen cinsiyetini giriniz(E/K): ");
			char cinsiyet=input.next().charAt(0);
			System.out.println("Öðretmen sicil numarasýný giriniz: ");
			int sicilNo=input.nextInt(); 
			if(cinsiyet=='E')
			{
				//File file = new File("ogretmen.txt");
				try {
					FileOutputStream input = new FileOutputStream(file, true);
					ogretmen= new Ogretmen(adi,dogumYili,Kisi.genders.E, sicilNo,okul);
					String data = (ogretmen.name+" "+ogretmen.birthYear+" "+Kisi.genders.E+" "+ogretmen.sicilNo);
					input.write(data.getBytes());
					System.out.println();

					input.flush();
					input.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			else if(cinsiyet=='K')
			{
				try {
					FileOutputStream input = new FileOutputStream(file, true);
					ogretmen=new Ogretmen(adi,dogumYili,Kisi.genders.K, sicilNo,okul);
					String data = (ogretmen.name+" "+ogretmen.birthYear+" "+Kisi.genders.K+" "+ogretmen.sicilNo);
					input.write(data.getBytes());
					

					input.flush();
					System.out.println();
					input.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
				 
			}
		
			
			System.out.print(ogretmen +"  eklendi.");
			
			
			
		}
		else if (secim == 2) 
		{
			System.out.println("Listelenecek öðretmenler: ");
			//
			for (Ogretmen ogrt : okul.getOgretmen()) 
			{
				if (!(ogrt == null))
				{
					System.out.println(ogrt.getName());
					
					 File file1 = new File("ogretmen.txt");
				     BufferedReader reader = null;
				     try {
				    	 reader = new BufferedReader(new FileReader(file1));
				    	 System.out.println(reader);
						}
				     catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        String satir;
						try {
							satir = reader.readLine();

				            while (satir!=null) {
				                System.out.println(satir+"\n");
				            }
				            reader.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Dosya okunamadý..");
							//e.printStackTrace();
						}
				 
					/*try 
					{
						FileInputStream input=new FileInputStream(file);
						int size=(int) file.length();
						for(int i=0;i<size;i++)
						{
							
							System.out.print((char)input.read());
							System.out.println();
						}
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}*/
					
				}
			}
		}
		else if(secim==3)
		{
			anaMenu();
		}
		
		printOgretmenMenu();
		OgretmenIslemleri();
		
		
	}
	
	
	public static void OgrenciIslemleri() {
		int secim = input.nextInt();
		if(secim==1)
		{
			System.out.println("Listelenecek öðrenciler: ");
			for (Ogrenci ogrenci : sinif.getOgrenciler()) 
			{
				if (!(ogrenci == null))
				{
					//System.out.println(	readFile(););
					System.out.println(ogrenci.getName()+" "+ogrenci.birthYear+" " +ogrenci.ogrenciNo+" "+ogrenci.sinif);
					int i=0;
					Scanner reader=new Scanner("siniflar.txt");
					while(reader.hasNextLine()){
						//System.out.println(reader.hasNextLine());
						okul=new Okul(reader.nextLine());
						okullar[i]=okul;
						i++;
						
						
						
					}
				}
			}
		}
		else if(secim==2)
		{
			anaMenu();
		}
		
		
		printOgrenciMenu();
		OgrenciIslemleri();
	}
	

	public static void main(String[] args) throws IOException {
		dosyaOkuma();
		anaMenu();
	
		
	}
	
}
