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
	
	
	public String[] loggedUser = {"",""}; //vettore dove salvare username e password dell'utente loggato
	
	public Utente() {}
	
	public Utente(String nome, String cognome, String codFisc, String ind, String mail, String username, String passwd) { //costruttore se serve
		this.nome = nome;
		this.cognome = cognome;
		this.codFisc = codFisc;
		this.ind = ind;
		this.mail = mail;
		this.username = username;
		this.passwd = passwd;
	}
	
	public void Registrazione() { //metodo per la registrazione
		Scanner sc = new Scanner(System.in);
		//creazioneFileUtente();
		
		//lettura dei vari campi
		System.out.print("Nome:"); this.nome = sc.next();
		System.out.print("Cognome:"); this.cognome = sc.next();
		System.out.print("Codice fiscale:"); this.codFisc = sc.next();
		System.out.print("Indirizzo fisico:"); this.ind = sc.next();
		System.out.print("Mail:"); this.mail = sc.next();
		System.out.print("Username:"); this.username = sc.next();
		System.out.print("Password:"); this.passwd = sc.next();
		try {//try catch per l'apertura del file
			FileWriter fw = new FileWriter("UtentiRegistrati.csv", true); //apre il file csv con l'opzione di accodare i nuovi inserimenti
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(nome+","+cognome+","+codFisc+","+ind+","+mail+","+username+","+passwd); //stampa nel file la riga con i vari campi
			pw.flush();
			pw.close();
			sc.close();
			//CIAO COME VA
		}catch(IOException e) { //eccezione nel caso di errore
			System.out.println("Errore di scrittura");
			e.printStackTrace();
			
		}
		
		
		
	}
	
	public void Login() { //metodo per il login
		String user;
		String passwd;
		
		String r_user = "", r_pass = "";
		Scanner sc = new Scanner(System.in);
		//lettura di username e password dell'utente
		System.out.print("Username: "); user = sc.next();
		System.out.print("Password: "); passwd = sc.next();
//N I C E
		try {//try catch per l'apertura del file
			
			FileReader fr = new FileReader(new File("UtentiRegistrati.csv"));
			BufferedReader br = new BufferedReader(fr);
			String line;
			String[] users; //stringa per splittare i campi delle linee del file
			boolean check = false; //booleano per verificare il login
			while((line = br.readLine())!= null&&!check) { 
				users = line.split(",");
				//r_user e r_pass prendono i valori presi dalla linea del file e li mette tutti in minuscolo (da sistemare ancora)
				//la posizione 5 e 6 del vettore users corrisponde al campo username e password della linea del file (quinto e sesto campo del file)
				r_user = users[5].toLowerCase();
				r_pass = users[6].toLowerCase();
				
				if(user.equals(r_user)&&passwd.equals(r_pass)) {//verifica che i valori immessi dall'utente e quelli letti dal file siano uguali
					check = true; //se è vero allora il login è stato eseguito correttamente
				}
				
			}
			if(check) {//se il login è stato eseguito correttamente i dati immessi vengono salvati nel vettore nelle prime due posizioni
				loggedUser[0] = user; 
				loggedUser[1] = passwd;
				System.out.println("Loggato correttamente");
			}	
			else { //altrimenti è da rifare  (da sistemare)
				System.out.println("Username o password non corretti");
				return;
			}
		} catch (FileNotFoundException e) { //vari catch
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
			
			
		
		
	}
}
