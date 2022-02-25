package base;

import java.util.Date;

public class Note {
	private Date date;
	private String title;
	
	public Note(String title) {
		this.title=title;
		date = new Date();
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj == null)return false;
		if(obj instanceof Note) {
			Note that = (Note) obj;
			if(title==that.getTitle()) return true;
		}
		return false;
	}
}
