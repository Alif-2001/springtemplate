package com.example.cis4900.spring.template.notes.dao;

import com.example.cis4900.spring.template.notes.models.Note;

import org.springframework.data.repository.CrudRepository;

public interface NotesDao extends CrudRepository<Note, Integer> {

}
