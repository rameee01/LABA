package codice;
import java.io.*;

public class Utente {
	private String nome;
	private String cognome;
	private String codFisc;
	private String ind;
	private String mail;
	private String username;
	private String passwd;
	
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
			File fp = new File("/File/UtentiRegistrati.txt");
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
		creazioneFileUtente();
		try {
			FileWriter fw = new FileWriter("/File/UtentiRegistrati.txt");
			fw.write(nome+" "+cognome+" "+codFisc+" "+ind+" "+mail+" "+username+" "+passwd);
			fw.close();
		}catch(IOException e) {
			System.out.println("Errore di scrittura");
			e.printStackTrace();
			
		}
		
		
		
	}
	
	public static void Login() {
		
	}
}

//ciao -fede;
