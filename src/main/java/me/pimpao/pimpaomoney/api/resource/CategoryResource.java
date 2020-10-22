package me.pimpao.pimpaomoney.api.resource;

import me.pimpao.pimpaomoney.api.event.ResourceCreatedEvent;
import me.pimpao.pimpaomoney.api.model.Category;
import me.pimpao.pimpaomoney.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody Category category, HttpServletResponse response) {
        Category newCategory = categoryRepository.save(category);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, newCategory.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }
}
