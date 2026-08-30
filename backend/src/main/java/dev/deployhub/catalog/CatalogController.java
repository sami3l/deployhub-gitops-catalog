package dev.deployhub.catalog;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applications")
public class CatalogController {
    private final CatalogRepository repository;

    public CatalogController(CatalogRepository repository) { this.repository = repository; }

    @GetMapping
    public List<CatalogApplication> findAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogApplication> findById(@PathVariable Long id) {
        return ResponseEntity.of(repository.findById(id));
    }
}

