package com.example.cis4900.spring.template.controllers;

import com.example.cis4900.spring.template.notes.NotesService;
import com.example.cis4900.spring.template.notes.models.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/notes")
public class NotesController {
    private NotesService notesService;

    @Autowired
    NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping("/add")
    private @ResponseBody String addNote(@RequestBody Note newNote) {
        return notesService.addNote(newNote);
    }

    @GetMapping("/get/{id}")
    private @ResponseBody Note getNote(@RequestParam Integer id) {
        return notesService.getNote(id);
    }

    @PutMapping("/update")
    private @ResponseBody String updateNote(@RequestParam Integer id, @RequestParam String text) {
        return notesService.updateNote(id, text);
    }

    @DeleteMapping("/delete")
    private @ResponseBody String deleteNote(@RequestParam Integer id) {
        return notesService.deleteNote(id);
    }

    @GetMapping("/all")
    private @ResponseBody Iterable<Note> allNotes() {
        return notesService.allNotes();
    }
}
