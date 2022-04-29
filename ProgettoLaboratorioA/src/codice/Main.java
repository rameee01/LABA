package codice;
import java.util.*;

public class Main {
	static public String nome;
	static public String cognome;
	static public String codFisc;
	static public String ind;
	static public String mail;
	static public String username;
	static public String passwd;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nome: "); nome = sc.next();
		System.out.println("Cognome: "); cognome = sc.next();
		System.out.println("Codice fiscale: "); codFisc = sc.next();
		System.out.println("Indirizzo fisico: "); ind = sc.next();
		System.out.println("Mail: "); mail = sc.next();
		System.out.println("Username: "); username = sc.next();
		System.out.println("Password: "); passwd = sc.next();
		Utente u = new Utente(nome, cognome, codFisc, ind, mail, username, passwd);
		u.Registrazione();
	}

}
