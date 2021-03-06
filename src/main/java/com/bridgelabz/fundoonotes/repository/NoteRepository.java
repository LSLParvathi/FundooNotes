package com.bridgelabz.fundoonotes.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.DTO.TrashTable;
import com.bridgelabz.fundoonotes.model.Note;
import com.bridgelabz.fundoonotes.model.User;

@Component
@Repository
public class NoteRepository {

	@Autowired
	private EntityManager entitymanager;

	public void saveNote(Note note) {
		Session currentsession = entitymanager.unwrap(Session.class);
		currentsession.save(note);
	}

	public  List<Note> getAllNotes() {
		Session currentsession = entitymanager.unwrap(Session.class);
		 Query query =  currentsession.createQuery("from Note");
		 List<Note> note = query.getResultList(); 
		 return note;
	}

	public Optional<Note> getbyId(Long note_id) {
		Session currentsession = entitymanager.unwrap(Session.class);
		return currentsession.createQuery("from Note where  note_id=:note_id").setParameter("note_id", note_id)
				.uniqueResultOptional();
	}

	public Optional<Note> getNoteByTitle(String title) {
		Session currentsession = entitymanager.unwrap(Session.class);
		return currentsession.createQuery("from Note where  title=:title").setParameter("title", title)
				.uniqueResultOptional();
	}

	public void deletenote(Note note) {
		Session currentsession = entitymanager.unwrap(Session.class); 
		currentsession.delete(note);

	}

	public Optional<List<Note>> getAllNotesDelete() {
		Session currentsession = entitymanager.unwrap(Session.class);
		return currentsession.createQuery("from TrashTable").uniqueResultOptional();
	}

	public Note getnotebyId(Long note_id) { 
		Session currentsession = entitymanager.unwrap(Session.class);
		Query query =  currentsession.createQuery("from Note where  note_id=:note_id");
		query.setParameter("note_id", note_id);
		  Note note = (Note) query.getResultList();
		 return note; 
	}
	 
}
