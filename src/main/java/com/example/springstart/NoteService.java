package com.example.springstart;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NoteService {

    private List<Note> listNotes = new ArrayList<>();

    public List<Note> listAll(){

        return listNotes;
    }

    public Note add(Note note){

        Long id = Math.abs(new Random().nextLong());
        note.setId(id);
        listNotes.add(note);
        return note;
    }

    public void deleteById(long id){

        boolean isNote = false;
        for (int i = 0; i < listNotes.size(); i++) {
            if (listNotes.get(i).getId() == id){
                listNotes.remove(i);
                isNote = true;
            }
        }
        if(!isNote){
            throw new RuntimeException("There is already no element by this id");
        }
    }

    public void update(Note note){

        boolean isNote = false;
        for (int i = 0; i < listNotes.size(); i++) {
            if (listNotes.get(i).getId() == note.getId()){
                listNotes.get(i).setTitle(note.getTitle());
                listNotes.get(i).setContent(note.getContent());
                isNote = true;
            }
        }
        if(!isNote){
            throw new RuntimeException("The update is failed");
        }
    }

    public Note getById(long id){

        Note result = null;
        for (int i = 0; i < listNotes.size(); i++) {
            if (listNotes.get(i).getId() == id){
                result = listNotes.get(i);
            }
        }
        if(result == null){
            throw new RuntimeException("There is no element by this id");
        }
        return result;
    }
}
