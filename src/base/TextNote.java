package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TextNote extends Note {
	String content;
	
	public TextNote(String title) {
		super(title);
	}

	public TextNote(String title, String content) {
		super(title);
		this.content = content;
	}
	
	public TextNote(File f) {
		super(f.getName());
		this.content = getTextFromFile(f.getAbsolutePath());
	}
	
	private String getTextFromFile(String absolutePath) {
		String result = "";
		try {
				FileInputStream fis = new FileInputStream(absolutePath);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				String line;
				while ((line=br.readLine()) != null) result += line;
				br.close();
		}catch(Exception e) {
				e.printStackTrace();
		}
		return result;
	}
	
	public void exportTextToFile(String pathFolder) {
		if(pathFolder=="") {
			pathFolder=".";
		}
		File file = new File(pathFolder + File.separator + this.getTitle().replaceAll(" ", "_")+".txt");
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw  = new BufferedWriter(fw);
			bw.write(this.content);
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}