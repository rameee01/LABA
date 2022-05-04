package EmotionalSongs;
import java.io.IOException;
import java.util.*;
public class EmotionalSongs {
	
	public static void main(String[] args) {
		
		Utente u = new Utente();
		
		int c = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
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
			}
			System.out.println("CONTINUARE?\n1.SI\n2.NO");
			c = sc.nextInt();
		
		}while(c!=0);
		
	}

}

//ciao -fede -- prova 2 3
