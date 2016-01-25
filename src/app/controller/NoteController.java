package app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.model.Note;
import app.model.User;
import app.service.NoteService;
import app.service.UserService;

@Controller
public class NoteController {

	@Autowired
	private NoteService noteService;
	@Autowired
	private UserService userService;

	@RequestMapping("/newnote")
	public String showAddUpdate(Model model) {
		model.addAttribute("note", new Note());
		return "newnote";
	}

	@RequestMapping(value = "/savenote", method = RequestMethod.POST)
	public String saveNote(Model model, Note note, Principal principal) {
		User user = userService.getUser(principal.getName());
		note.setUser(user);
		if (note.getId() != 0) {
			noteService.updateNote(note);
			model.addAttribute("message", "Note has been edited.");
			return "message";
		} else {
			noteService.addNote(note);
			model.addAttribute("message", "Note has been added.");
			return "message";
		}
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String showEdit(Model model, @RequestParam String id){
		model.addAttribute("note", noteService.getNote(Integer.parseInt(id)));
		return "newnote";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteNote(Model model, @RequestParam int id){
		noteService.deleteNote(id);
		model.addAttribute("message", "Note has been deleted");
		return "message";
	}
}
