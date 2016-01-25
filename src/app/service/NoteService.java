package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.model.Note;
import app.dao.NoteDao;
import app.dao.NoteDaoAbstract;

@Service("noteService")
public class NoteService {

	@Autowired
	private NoteDaoAbstract noteDao;
	
	public List<Note> getNotes(String username){
		return noteDao.getNotes(username);
	}
	
	public void addNote(Note note){
		noteDao.addNote(note);
	}
	
	public void updateNote(Note note){
		noteDao.updateNote(note);
	}
	
	public void deleteNote(int id) {
		noteDao.deleteNote(id);
	}
	
	public Note getNote(int id){
		return noteDao.getNote(id);
	}
}
