package emotionalsongs;
import java.io.*;
import java.util.Scanner;

public class Utente {
	private String nome;
	private String cognome;
	private String codFisc;
	private String ind;
	private String mail;
	private String username;
	private String passwd;
	
	public Utente() {}
	
	public Utente(String nome, String cognome, String codFisc, String ind, String mail, String username, String passwd) {
		this.nome = nome;
		this.cognome = cognome;
		this.codFisc = codFisc;
		this.ind = ind;
		this.mail = mail;
		this.username = username;
		this.passwd = passwd;
	}
	private static void creazioneFileUtente() {
		try {
			File fp = new File("UtentiRegistrati.txt");
			if(fp.createNewFile()) {
				System.out.println("File utenti creato.");
			}
			else {
				System.out.println("File utenti esistente");
			}
		}catch(IOException e) {
			System.out.println("Errore");
			e.printStackTrace();
		}
	}
	public void Registrazione() {
		Scanner sc = new Scanner(System.in);
		creazioneFileUtente();
		System.out.println("Nome:"); this.nome = sc.next();
		System.out.println("Cognome:"); this.cognome = sc.next();
		System.out.println("Codice fiscale:"); this.codFisc = sc.next();
		System.out.println("Indirizzo fisico:"); this.ind = sc.next();
		System.out.println("Mail:"); this.mail = sc.next();
		System.out.println("Username:"); this.username = sc.next();
		System.out.println("Password:"); this.passwd = sc.next();
		try {
			FileWriter fw = new FileWriter("UtentiRegistrati.txt");
			fw.write(nome+" "+cognome+" "+codFisc+" "+ind+" "+mail+" "+username+" "+passwd);
			fw.close();
		}catch(IOException e) {
			System.out.println("Errore di scrittura");
			e.printStackTrace();
			
		}
		
		// we bella
		// ciao - fede

		
		
	}
	
	public static void Login() {
		
	}
}
