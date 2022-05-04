package EmotionalSongs;
import java.io.IOException;
import java.util.*;
public class EmotionalSongs {
	
	public static void main(String[] args) { //main del progetto
		
		Utente u = new Utente();
		
		int c = 0;
		Scanner sc = new Scanner(System.in);
		
		do { //Ciclo do while per lo switch (da rivedere)
			String[] utente = u.loggedUser; //prende le informazioni dell'utente loggato
			if(utente!=null&&!utente[0].equals("")&&!utente[1].equals("")) { //se la stringa non è vuota significa che qualcuno è loggato
				System.out.println("Loggato come: "+utente[0]); //e nel caso stampa il nome dell'utente
			}
			System.out.println("Cosa vuoi fare?\n1.Registrarti\n2.Login");
			int scelta = sc.nextInt();
			switch(scelta) {
			case 1:
				u.Registrazione(); //scelta di registrazione 
				break;
			case 2:
				u.Login(); //scelta di login
				break;
			}
			System.out.println("CONTINUARE?\n1.SI\n2.NO");
			c = sc.nextInt();
		
		}while(c!=0);
		
	}

}

//ciao -fede -- prova 2 3
