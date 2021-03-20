package com.sparta.week01_assignment;

import com.sparta.week01_assignment.domain.Person;
import com.sparta.week01_assignment.domain.PersonRepository;
import com.sparta.week01_assignment.domain.PersonRequestDto;
import com.sparta.week01_assignment.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;


@EnableJpaAuditing
@SpringBootApplication
public class Week01AssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week01AssignmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
        return (args) -> {
            personRepository.save(new Person("이현", "백엔드"));
            System.out.println("save to repo");

            List<Person> personList = personRepository.findAll();

            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getPosition());
                // get one data.
            }

            PersonRequestDto requestDto = new PersonRequestDto("강이현", "서버 개발자");
            personService.update(1L, requestDto);
            personList = personRepository.findAll();
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getPosition());
            }
        };
    }

}
