package base;

import java.util.ArrayList;

public class Folder {
	private ArrayList<Note> notes;
	private String name;
	
	public Folder(String name) {
		this.name=name;
		notes=new ArrayList<Note>();
	}
	
	public void addNote(Note note) {
		notes.add(note);
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Note> getNotes() {
		return notes;
	}
	
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null) return false;
		if(obj instanceof Folder) {
			Folder that = (Folder) obj;
			if(this.name==that.getName()) return true;
		}
		return false;
	}
	
	public String toString() {
		int nText = 0;
		int nImage = 0;
		for(Note note:notes) {
			if(note instanceof TextNote) nText++;
			else  nImage++;
		}
		return name + ":" + nText + ":" + nImage;
	}
}
