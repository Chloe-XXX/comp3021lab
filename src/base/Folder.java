package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Date;

public class Folder implements Comparable<Folder> {
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
	
	public int compareTo(Folder o) {
		return name.compareTo(o.name);
	}
	
	public void sortNotes() {
		Collections.sort(notes);
	}
	
	public List<Note> searchNotes(String keywords){
		keywords = keywords.toLowerCase();
		ArrayList<Note> Notesatisfy = new ArrayList<Note>();
		String[] keyword = keywords.split(" ");
		boolean flag;
		for(Note n: notes) {
			flag = true;
			for(int i=0; i<keyword.length; i++) {
				if(keyword[i]=="or") continue;
				if(n instanceof ImageNote) {
					if(n.getTitle().toLowerCase().contains(keyword[i])) {
						if(i<keyword.length-1 && keyword[i+1]=="or") i+=2;
						continue;
					}
					flag = false;
				}
				else {
					TextNote t = (TextNote) n;
					if(t.getTitle().toLowerCase().contains(keyword[i]) || t.content.toLowerCase().contains(keyword[i])) {
						if(i<keyword.length-1 && keyword[i+1]=="or") i+=2;
						continue;
					}
					flag = false;
				}
				if(flag==true) Notesatisfy.add(n);
			}
		}
		return Notesatisfy;
	}
}
