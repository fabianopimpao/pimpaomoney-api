package me.pimpao.pimpaomoney.api.resource;

import me.pimpao.pimpaomoney.api.event.ResourceCreatedEvent;
import me.pimpao.pimpaomoney.api.model.Person;
import me.pimpao.pimpaomoney.api.repository.PersonRepository;
import me.pimpao.pimpaomoney.api.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/peoples")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Person> listAll() {
        return personRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody Person person, HttpServletResponse response) {
        Person newPerson = personRepository.save(person);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, newPerson.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(newPerson);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @Valid @RequestBody Person person) {
        Person updatePerson = personService.update(id, person);
        return ResponseEntity.ok(updatePerson);
    }

    @PutMapping(value = "/{id}/active")
    public ResponseEntity<Void> updateActiveProperty(@PathVariable Long id, @RequestBody Boolean active) {
        personService.updateActiveProperty(id, active);
        return ResponseEntity.noContent().build();
    }
}
