package emotionalsongs;
import java.io.*;
import java.util.*;

import Registro_Canzoni.Database;
public class EmotionalSongs {
	
	public static void main(String[] args) throws IOException {
		
		Utente u = new Utente();
		System.out.println(System.in.available());
		int c;
		Scanner sc = new Scanner(System.in);
		
		
			String[] utente = u.loggedUser;
			if(utente!=null&&!utente[0].equals("")&&utente[1].equals("")) {
				System.out.println("Loggato come: "+utente[0]);
			}
			System.out.println("Cosa vuoi fare?\n1.Registrarti\n2.Login");
			int scelta = sc.nextInt();
			switch(scelta) {
			case 1:
				u.Registrazione();
				break;
			case 2:
				u.Login();
				break;
			case 3:
				Database db = new Database();
			}
			//System.out.println("CONTINUARE?\n1.SI\n2.NO");
			
		
	
	}

}

<<<<<<< HEAD
//ciao
=======
>>>>>>> refs/remotes/origin/rame
