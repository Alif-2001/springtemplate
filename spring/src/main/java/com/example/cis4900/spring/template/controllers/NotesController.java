package com.example.cis4900.spring.template.controllers;

import com.example.cis4900.spring.template.notes.NotesService;
import com.example.cis4900.spring.template.notes.models.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/notes")
public class NotesController {
    @Autowired
    private NotesService notesService;

    @PostMapping("/add")
    private @ResponseBody String addNote(@RequestParam String text) {
        try {
            Note note = new Note();
            note.setText(text);
            notesService.save(note);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Saved";
    }

    @GetMapping("/all")
    private @ResponseBody Iterable<Note> allNotes() {
        return notesService.findAll();
    }

    @DeleteMapping("/delete")
    private @ResponseBody String deleteNote(@RequestParam Integer id) {
        try {
            Note note = new Note();
            note.setId(id);
            notesService.delete(note);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Deleted";
    }

    @PutMapping("/update")
    private @ResponseBody String updateNote(@RequestParam Integer id, @RequestParam String text) {
        try {
            Note note = new Note();
            note.setId(id);
            note.setText(text);
            notesService.save(note);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Updated";
    }
}
