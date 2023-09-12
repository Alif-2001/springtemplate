package com.example.cis4900.spring.template.notes;

import com.example.cis4900.spring.template.notes.models.Note;

import org.springframework.data.repository.CrudRepository;

public interface NotesService extends CrudRepository<Note, Integer> {

}
