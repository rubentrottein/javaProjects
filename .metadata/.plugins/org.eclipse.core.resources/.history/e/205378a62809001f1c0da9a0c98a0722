package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Note {
	private String title;
	private final LocalDate DATE;
	private String content;
	HashMap<String, Note> noteList = new HashMap<String, Note>();

	public Note(String title, String content) {
		this.title = title;
		//this.DATE = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/mm/yy/mm"));
		this.DATE = LocalDate.now();
		this.content = content;
		//Hashmap noteList.add(this.title, this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return DATE;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Note [title=" + title + ", DATE=" + DATE + ", content=" + content + "]";
	}
	
}
