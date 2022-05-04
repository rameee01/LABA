package EmotionalSongs;
import java.io.*;
import java.util.*;

public class Utente {
	private String nome;
	private String cognome;
	private String codFisc;
	private String ind;
	private String mail;
	private String username;
	private String passwd;
	
	
	public String[] loggedUser = {"",""};
	
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
	
	public void Registrazione() {
		Scanner sc = new Scanner(System.in);
		//creazioneFileUtente();
		System.out.print("Nome:"); this.nome = sc.next();
		System.out.print("Cognome:"); this.cognome = sc.next();
		System.out.print("Codice fiscale:"); this.codFisc = sc.next();
		System.out.print("Indirizzo fisico:"); this.ind = sc.next();
		System.out.print("Mail:"); this.mail = sc.next();
		System.out.print("Username:"); this.username = sc.next();
		System.out.print("Password:"); this.passwd = sc.next();
		try {
			FileWriter fw = new FileWriter("UtentiRegistrati.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(nome+","+cognome+","+codFisc+","+ind+","+mail+","+username+","+passwd);
			pw.flush();
			pw.close();
			sc.close();
			//CIAO COME VA
		}catch(IOException e) {
			System.out.println("Errore di scrittura");
			e.printStackTrace();
			
		}
		
		
		
	}
	
	public void Login() {
		String user;
		String passwd;
		
		String r_user = "", r_pass = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: "); user = sc.next();
		System.out.print("Password: "); passwd = sc.next();
		
		try {
			
			FileReader fr = new FileReader(new File("UtentiRegistrati.csv"));
			BufferedReader br = new BufferedReader(fr);
			String line;
			String[] users;
			boolean check = false;
			while((line = br.readLine())!= null&&!check) {
				users = line.split(",");
				r_user = users[5].toLowerCase();
				r_pass = users[6].toLowerCase();
				if(user.equals(r_user)&&passwd.equals(r_pass)) {
					check = true;
				}
				
			}
			if(check) {
				loggedUser[0] = user;
				loggedUser[1] = passwd;
				System.out.println("Loggato correttamente");
			}	
			else {
				System.out.println("Username o password non corretti");
				return;
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
			
			
		
		
	}
}
