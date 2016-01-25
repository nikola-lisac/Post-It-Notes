package app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.model.Note;
import app.service.NoteService;

@Controller
public class HomeController {
	
	@Autowired
	private NoteService noteService;
	
	@RequestMapping("/")
	public String showHome(Model model,Principal principal){
		if(principal != null){
			List<Note> notes  = noteService.getNotes(principal.getName());
			model.addAttribute("notes", notes);
		}
		return "index";
	}
}
