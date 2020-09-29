package me.pimpao.pimpaomoney.api.resource;

import me.pimpao.pimpaomoney.api.model.Category;
import me.pimpao.pimpaomoney.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        Category newCategory = categoryRepository.save(category);
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequestUri()
                    .path("/{id}")
                    .buildAndExpand(newCategory.getId())
                    .toUri();
        return ResponseEntity.created(uri).body(newCategory);
    }

    @GetMapping(value = "/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
