package com.crud.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class TasksApplication {
	public static void main(String[] args) {
//		run(TasksApplication.class, args);
			SpringApplication.run(TasksApplication.class, args);

	// lombok test
/*				TaskDto taskDto = new TaskDto(

				(long)1,
				"Test title",
				"I want to be a ropper!"
		);

		Long id = taskDto.getId();
		String title = taskDto.getTitle();
		String content = taskDto.getContent();
		System.out.println(id + " " + title + " " +content);
*/

	}

}
