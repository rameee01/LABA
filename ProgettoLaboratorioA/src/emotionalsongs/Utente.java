package emotionalsongs;
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
	
	public Utente() {
		PrintWriter pw = fileManager("session.txt", false);
		pw.print("");
	}
	
	public Utente(String nome, String cognome, String codFisc, String ind, String mail, String username, String passwd) {
		this.nome = nome;
		this.cognome = cognome;
		this.codFisc = codFisc;
		this.ind = ind;
		this.mail = mail;
		this.username = username;
		this.passwd = passwd;
	}
	
	
	public PrintWriter fileManager(String file, boolean append) {
		PrintWriter pw = null;
		try {
			FileWriter fw = new FileWriter(file, append);
			BufferedWriter bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return pw;
	}
	
	public void sessionManager(String[] loggeduser) {
		
		String file = "session.txt"; 
		PrintWriter pw = fileManager(file, false);
		pw.print(loggeduser[0]+"\n"+loggeduser[1]);
		pw.close();
	}
	
	public boolean checkMail(String mail) {
		boolean check_at = false;
		boolean check_dot = false;
		String[] parti;
		for(int i=0;i<mail.length();i++) {
			if(mail.charAt(i)=='@'||check_at) {
				check_at = true;
			}
		}
		if(check_at) {
			parti = mail.split("@");
			for(int i=0;i<parti[1].length();i++) {
				if(parti[1].charAt(i)=='.'||check_dot) {
					check_dot = true;
				}
			}
		}
			
		
		
		return check_at&&check_dot;
	}
	public void Registrazione() {
		Scanner sc = new Scanner(System.in);
		//creazioneFileUtente();
		System.out.print("Nome:"); this.nome = sc.next();
		System.out.print("Cognome:"); this.cognome = sc.next();
		System.out.print("Codice fiscale:"); this.codFisc = sc.next();
		System.out.print("Indirizzo fisico:"); this.ind = sc.next();
		System.out.print("Mail:"); this.mail = sc.next();
		while(!checkMail(mail)) {
			System.out.print("Inserire una mail valida:");
			this.mail = sc.next();
		}
		
		System.out.print("Username:"); this.username = sc.next();
		System.out.print("Password:"); this.passwd = sc.next();
		
		String file = "UtentiRegistrati.csv";	
		PrintWriter pw = fileManager(file, true);
		pw.println(nome+","+cognome+","+codFisc+","+ind+","+mail+","+username+","+passwd);
		pw.flush();
		pw.close();
		sc.close();
			

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
				sessionManager(loggedUser);
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
