package me.pimpao.pimpaomoney.api.resource;

import me.pimpao.pimpaomoney.api.model.Person;
import me.pimpao.pimpaomoney.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/peoples")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> listAll() {
        return personRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody Person person) {
        Person newPerson = personRepository.save(person);
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequestUri()
                    .path("/{id}")
                    .buildAndExpand(newPerson.getId())
                    .toUri();
        return ResponseEntity.created(uri).body(newPerson);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }
}
