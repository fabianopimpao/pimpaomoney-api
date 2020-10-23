package me.pimpao.pimpaomoney.api.resource;

import me.pimpao.pimpaomoney.api.model.Accounting;
import me.pimpao.pimpaomoney.api.repository.AccountingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/accounting")
public class AccountingResource {

    @Autowired
    private AccountingRepository accountingRepository;

    @GetMapping
    public List<Accounting> listAll() {
        return accountingRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Accounting> findById(@PathVariable Long id) {
        Accounting accounting = accountingRepository.findById(id).orElse(null);
        return accounting != null ? ResponseEntity.ok(accounting) : ResponseEntity.notFound().build();
    }
}
