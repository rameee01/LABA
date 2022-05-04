package Registro_Canzoni;

import java.io.*;
import java.util.*;

// classe database
public class Database {
	public File songs;
	public FileWriter fin; 
	public BufferedWriter bfin;
	public PrintWriter pbfin;
	
	//costruttore della classe(creazione file)
	Database(){
		
		try{
			songs = new File("Canzoni.csv");
		}
		catch(Exception E){
			
			System.out.println("errore nella creazione del file \"Songs.csv\"");
		}
			
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
		//il While vincola l'admin a inserire le info sulla canzone
		//NB --> i parametri genere,durata e album non sono vincolati perchè da traccia non sono obbligatori
		//l'if genera un messaggio di errore
			
			
			System.out.println("Nome?");
			do {
				name = in.next();
				if(name == null)
					System.out.println("dato vuoto non valido");
			}while(name == "");
		
			System.out.println("Autore?");
			do {
				writer = in.next();
				if(writer == null)
					System.out.println("dato vuoto non valido");
			}while(writer == "");
			
			System.out.println("Anno di pubblicazione?");
			do {
				year = in.next();
				
				if(year == null)
					System.out.println("dato vuoto non valido");
			
			}while(year == null);
			
			System.out.println("album?");
				album = in.next();
			
			System.out.println("Durata?");
				length = in.next();
			
			
			System.out.println("genere?");
				genre = in.next();
				
					try {
						FileWriter fw = new FileWriter("Canzoni"
								+ ".csv", true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						pw.println(name+","+writer+","+year+","+album+","+length+","+genre);
						pw.flush();
						pw.close();
					
				}catch(IOException e) {
					System.out.println("Errore di scrittura");
					e.printStackTrace();
					
				}
		
			
		
		}
	}

		
	
	


