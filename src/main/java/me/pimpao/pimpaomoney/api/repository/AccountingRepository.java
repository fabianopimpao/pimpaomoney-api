package me.pimpao.pimpaomoney.api.repository;

import me.pimpao.pimpaomoney.api.model.Accounting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRepository extends JpaRepository<Accounting, Long> {
}
