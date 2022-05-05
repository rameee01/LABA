package emotionalsongs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {
	public FileManager() {
		
	}
	public PrintWriter openToWrite(String file, boolean append) {
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
	
	public BufferedReader openToRead(String file) {
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(new File(file));
			br = new BufferedReader(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return br;
	}
	
}
