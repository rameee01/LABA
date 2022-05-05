package Registro_Canzoni;

import java.io.*;
import java.util.*;

import emotionalsongs.FileManager;

// classe database
public class Database {

	
	public File songs;

	FileManager fm = new FileManager();


	//costruttore della classe(creazione file)


	public PrintWriter in;
	
	public Database(){}
	private boolean filecreation() {
		try{
				this.songs = new File("Canzoni.csv");
				System.out.println("File canzoni creato.");
				in = new PrintWriter(this.songs);
				in.write("Canzone"+','+"Autore"+','+"Anno"+','+"Album"+','+"durata"+','+"genere"+'\n'+"\n");
				in.flush();
				in.close();
				return true;
			
		}catch(Exception E){
			
			System.out.println("errore nella creazione del file \"Songs.csv\"");
			return false;
		}

	}
	
	public void Addsong() {
		
		//variabili necessarie per inserimento
		Scanner in = new Scanner(System.in);
		
		String name = "";
		String writer = "";
		String year = "";
		String album = "";
		String length = "";
		String genre = "";
		
		//Inserimento dati
		//il While vincola l'admin a inserire i parametri della canzone
		//NB --> i parametri genere,durata e album non sono vincolati perch� da traccia non sono obbligatori
		//l'if genera un messaggio di errore
			
			

		do {
			System.out.println("Nome?");
			name = in.nextLine();
			if(name.isBlank())
				System.out.println("dato vuoto non valido");
		}while(name.isBlank());
		
		do {
			System.out.println("Autore?");
			writer = in.nextLine();
			if(writer.isBlank())
				System.out.println("dato vuoto non valido");
		}while(writer.isBlank());


		do{
			System.out.println("Anno di pubblicazione?");
			year = in.nextLine();
	
			if(year.isBlank())
				System.out.println("dato vuoto non valido");
			
		}while(year.isBlank());
			
		System.out.println("album?");
		album = in.nextLine();
			
		System.out.println("Durata?");
		length = in.nextLine();
			
			
		System.out.println("genere?");
		genre = in.nextLine();
				

		try {
			PrintWriter pw = new PrintWriter("Canzoni.csv");
			pw.write(name+','+writer+','+year+','+album+','+length+','+genre);
			pw.flush();
			pw.close();

					
		}catch(IOException e) {
			System.out.println("Errore di scrittura");
			e.printStackTrace();
					

				}
		
			
			
				
				System.out.println("errore nella scrittura del file");
			

		}
	
	
	public void letturaCanzoni() {
		BufferedReader bw = fm.openToRead("Canzoni.csv");
		String line;
		try {
			while((line = bw.readLine())!=null) {
				System.out.println(line);
			}
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void cercaBranoMusicale() {
		System.out.println("Nome brano:");
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		String brano = sc.next();
		brano.toLowerCase();
		BufferedReader bw = fm.openToRead("Canzoni.csv");
		try {
			String line;
			while((line = bw.readLine())!=null&&!check) {
				String[] parti = line.split(",");
				String r_brano = parti[0].toLowerCase();
				if(brano.equals(r_brano)) {
					check = true;
				}
			
			}
			if(check) {
				System.out.println("Trovato");
			}
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

		
	
	


