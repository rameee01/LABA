package emotionalsongs;
import java.util.*;
public class EmotionalSongs {
	
	public static void main(String[] args) {
		Utente u = new Utente();
		Scanner sc = new Scanner(System.in);
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
	}

}
