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
			System.out.println("Se�ilen okul: "+secilmisokul.okulAdi);

		} else {
			System.out.println("Se�ilen okul: Se�ilmemi�");
		}

	}

	public static void sinifSecilmeKontrol() {
		if (secilmissinif != null) {
			System.out.println("Se�ilen s�n�f: " + secilmissinif.sinifNo + "/" + secilmissinif.sinifSube);
		} else {
			System.out.println("Se�ilen okul: Se�ilmemi�");
		}

	}
	
	public static void cikis() {
		System.out.println("G�le g�le");
	}

	public static void anaMenu() {
		System.out.println();
		System.out.println("MEN�");
		okulSecilmeKontrol();
		System.out.println("Okul ��lemleri     -> 1\n" + "S�n�f ��lemleri    -> 2\n"
				+ "��retmen ��lemleri -> 3\n" + "��renci ��lemleri  -> 4\n" + "��k��              -> 5\n");
		System.out.print("Se�iminiz: ");
		
		
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
		System.out.println("Se�ilen Okul: ");
		System.out.println("(Okul ��lemleri Men�s�)" + "\n" + "Ekleme      -> 1\n" + "Listeleme   -> 2\n"
				+ "Okul se�imi -> 3\n" + "Ana men�    -> 4\n");
		System.out.print("Se�iminiz: ");
	}

	public static void printSinifMenu() {
		System.out.println();
		System.out.println("(S�n�f ��lemleri Men�s�)");
		sinifSecilmeKontrol();
		System.out.println("Ekleme         -> 1\n" + "Listeleme      -> 2\n"
				+ "S�n�f se�imi   -> 3\n" + "��retmen Atama -> 4\n" + "��renci Kay�t  -> 5\n"
				+ "Ana men�       -> 6\n");
		System.out.print("Se�iminiz: ");
	}

	public static void printOgretmenMenu() {
		System.out.println();
		System.out.println(
				"(��retmen ��lemleri Men�s�)" + "\n" + "Ekleme    -> 1\n" + "Listeleme -> 2\n" + "Ana men�  -> 3\n");
		System.out.print("Se�iminiz: ");
	}

	public static void printOgrenciMenu() {
		System.out.println();
		System.out.println("(��renci ��lemleri Men�s�)" + "\n" + "Listeleme -> 1\n" + "Ana men�  -> 2\n");
		System.out.print("Se�iminiz: ");
	}

	public static void OkulIslemleri() {
		int secim = input.nextInt();
		if (secim == 1) {
			System.out.print("Okul ad� giriniz: ");
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
	        System.out.println("\nSe�ilecek okulun indeksi: ");
	        index = input.nextInt();
	        if(index-1 < okullar.length && okullar[index-1] != null)
	        {
	        	secilmisokul = okullar[index-1];
	        }
	        System.out.println("Se�ilen okullar: ");
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
			System.out.print("S�n�f� giriniz: ");
			int sinifNo=input.nextInt();
			System.out.print("�ubeyi giriniz: ");
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
			System.out.println("Listelenecek s�n�flar: ");
			for (int i = 0; i < secilmisokul.getSinif().length; i++) {
				if (!(secilmisokul.getSinif()[i] == null)) {
					System.out.println((i + 1) + " - " + secilmisokul.getSinif()[i]);
				}

			}
			//printSiniflar() 

		}
		
		else if(secim==3) {
			int index = -1;
	        System.out.println("\nSe�ilecek s�n�f�n indeksi: ");
	        index = input.nextInt();
	        if(index-1 < secilmisokul.getSinif().length && secilmisokul.getSinif()[index-1] != null)
	        {
	        	secilmissinif = secilmisokul.getSinif()[index-1];
	        }
	        System.out.println("Se�ilen s�n�flar: ");
			System.out.println(secilmissinif.getSinifNo()+" / "+secilmissinif.getSinifSube());
			
		}
		else if(secim==4 && secilmissinif!=null) {
			Ogretmen o1=new Ogretmen("Kemal U�ar",1982,Kisi.genders.E,123456, okul);
			okul.OgretmenAta(secilmissinif, o1);
			okul.printOgretmenler();
			
		}
		//dipnot: alanlar fazla oldu�u i�in kendim giri� yapt�rd�m
		else if(secim==5 && secilmissinif!=null) {
			Ogrenci ogr1=new Ogrenci("Kemal U�ar",1982,Kisi.genders.E,123456,sinif);
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
			
			System.out.print("��retmen ad�n� giriniz: ");
			String adi=input.next();
			System.out.println("��retmen do�um y�l�n� giriniz:");
			int dogumYili=input.nextInt();
			System.out.println("��retmen cinsiyetini giriniz(E/K): ");
			char cinsiyet=input.next().charAt(0);
			System.out.println("��retmen sicil numaras�n� giriniz: ");
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
			System.out.println("Listelenecek ��retmenler: ");
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
							System.out.println("Dosya okunamad�..");
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
			System.out.println("Listelenecek ��renciler: ");
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
