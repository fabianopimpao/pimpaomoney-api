package me.pimpao.pimpaomoney.api.service;

import me.pimpao.pimpaomoney.api.model.Person;
import me.pimpao.pimpaomoney.api.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person update(Long id, Person person) {
        Person updatePerson = getPersonById(id);
        BeanUtils.copyProperties(person, updatePerson, "id");
        return personRepository.save(updatePerson);
    }

    public void updateActiveProperty(Long id, Boolean active) {
        Person updatePerson = getPersonById(id);
        updatePerson.setActive(active);
        personRepository.save(updatePerson);
    }

    private Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

}
