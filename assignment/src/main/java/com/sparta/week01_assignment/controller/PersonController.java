package com.sparta.week01_assignment.controller;


import com.sparta.week01_assignment.domain.Person;
import com.sparta.week01_assignment.domain.PersonRepository;
import com.sparta.week01_assignment.domain.PersonRequestDto;
import com.sparta.week01_assignment.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;

    private final PersonService personService;

    @PostMapping("api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        Person person = new Person(requestDto);

        return personRepository.save(person);
    }

    @GetMapping("api/persons")
    public List<Person> getpersons() {
        return personRepository.findAll();
    }

    @PutMapping("api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return personService.update(id, requestDto);
    }

    @DeleteMapping("api/persons/{id}")
    public Long deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return id;
    }
}


//    @GetMapping("myinfo")
//    public Person getPerson() {
//        Person person = new Person();
//        person.setName("강이현");
//        person.setNickName("매생이");
//        person.setPosition("서버 개발자");
//        person.setHobby("독서");
//        person.setPhone("010-1111-2222");
//
//        return person;
//    }
