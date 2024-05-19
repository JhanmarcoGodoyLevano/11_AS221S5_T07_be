package pe.edu.vallegrande.metamatrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.metamatrix.entity.Metadata;
import pe.edu.vallegrande.metamatrix.service.MetaMatrixService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/metadata")
public class MetadataController {

    private final MetaMatrixService metaMatrixService;

    @Autowired
    public MetadataController(MetaMatrixService metaMatrixService) {
        this.metaMatrixService = metaMatrixService;
    }

    @GetMapping
    public Flux<Metadata> getAllMetadata() {
        return metaMatrixService.getAllMetadata();
    }

    @GetMapping("/active")
    public Flux<Metadata> getActiveMetadata() {
        return metaMatrixService.getActiveMetadata();
    }

    @GetMapping("/inactive")
    public Flux<Metadata> getInactiveMetadata() {
        return metaMatrixService.getInactiveMetadata();
    }

    @GetMapping("/{id}")
    public Mono<Metadata> getMetadataById(@PathVariable Integer id) {
        return metaMatrixService.getMetadataById(id);
    }

    @PostMapping(value = "/analyze")
    public Mono<Metadata> analyzeTextAndSaveMetadata(@RequestBody String requestBody) {
        return metaMatrixService.analyzeTextAndSaveMetadata(requestBody);
    }
}
