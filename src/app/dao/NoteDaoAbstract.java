package app.dao;

import java.util.List;

import app.model.Note;

public interface NoteDaoAbstract {

	public List<Note> getNotes(String username);
	
	public Note getNote(int id);
	
	public void addNote(Note note);
	
	public void updateNote(Note note);
	
	public void deleteNote(int id);
	
}
