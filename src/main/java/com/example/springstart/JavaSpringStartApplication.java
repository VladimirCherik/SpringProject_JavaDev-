package com.example.springstart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class JavaSpringStartApplication {


	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JavaSpringStartApplication.class, args);
		NoteService noteService = context.getBean(NoteService.class);


		//To check NoteService
		Note note1 = new Note();
		note1.setTitle("1Title");
		note1.setContent("1Context");

		System.out.println("add() = " + noteService.add(note1));
		System.out.println("listAll() = " + noteService.listAll());
		System.out.println("getById() = " + noteService.getById(note1.getId()));

		note1.setContent("1Context After Update");
		note1.setTitle("1Title After Update");
		noteService.update(note1);

		System.out.println("getById() after update = " + noteService.getById(note1.getId()));

		noteService.deleteById(note1.getId());
		System.out.println("listAll() after delete = " + noteService.listAll());

	}
}
