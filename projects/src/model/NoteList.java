package model;

import java.util.HashMap;
import note;

public class NoteList {
	private HashMap<String, Note> noteList = new HashMap<String, Note>();
	
	public HashMap<String, Note> setNoteList(String string, Note note) {
		//noteList.add(string, note);
		return noteList;
	}
	public HashMap<String, Note> getNoteList() {
		return noteList;
	}

}
