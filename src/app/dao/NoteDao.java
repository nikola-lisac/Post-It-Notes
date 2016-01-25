package app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.model.Note;

@Service
@Transactional
public class NoteDao implements NoteDaoAbstract {


	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getNotes(String username) {

		Criteria crit = session().createCriteria(Note.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.username", username));
		crit.add(Restrictions.eq("u.enabled", true));
		return crit.list();

	}

	@Override
	public void addNote(Note note) {
		session().save(note);
	}

	@Override
	public void updateNote(Note note) {
		session().update(note);

	}

	@Override
	public void deleteNote(int id) {
		Query query = session().createQuery("delete from Note where id=:id");
		query.setLong("id", id);
		query.executeUpdate();

	}

	@Override
	public Note getNote(int id) {
		Criteria crit = session().createCriteria(Note.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.idEq(id));
		return (Note) crit.uniqueResult();
	}

}
