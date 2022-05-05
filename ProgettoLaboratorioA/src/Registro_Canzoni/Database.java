package Registro_Canzoni;

import java.io.*;
import java.util.*;

import emotionalsongs.FileManager;

// classe database
public class Database {
	FileManager fm = new FileManager();
	public File songs;	
	public PrintWriter in;
	//costruttore della classe(creazione file)
	public Database(){
		
		
			
	}
	
	
	public static void Addsong(){
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
		//NB --> i parametri genere,durata e album non sono vincolati perchè da traccia non sono obbligatori
		//l'if genera un messaggio di errore
			
			
		do {
			System.out.println("Nome?");
			name = in.nextLine();
			if(name == " ");
				System.out.println("dato vuoto non valido");
		}while(name != "");

		do {
			System.out.println("Autore?");
			writer = in.nextLine();
			if(writer == " ")
				System.out.println("dato vuoto non valido");
		}while(writer != " ");
			
		do{
			System.out.println("Anno di pubblicazione?");
			year = in.nextLine();
	
			if(year == " ")
				System.out.println("dato vuoto non valido");
			
		}while(year != " ");
			
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

		
	
	


