package me.pimpao.pimpaomoney.api.repository;

import me.pimpao.pimpaomoney.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
