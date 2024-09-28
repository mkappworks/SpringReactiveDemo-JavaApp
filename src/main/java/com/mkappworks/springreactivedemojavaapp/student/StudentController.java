package com.mkappworks.springreactivedemojavaapp.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Mono<Student> createStudent(@RequestBody StudentRequest studentRequest) {
        var student = Student
                .builder()
                .firstName(studentRequest.getFirstname())
                .lastName(studentRequest.getLastname())
                .age(studentRequest.getAge())
                .build();
        return studentService.save(student);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    Mono<Student> getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/filter")
    public Flux<Student> findByAuthor(@RequestParam String name) {
        return studentService.findByFirstname(name);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
