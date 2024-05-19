package pe.edu.vallegrande.metamatrix.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.metamatrix.entity.Metadata;
import pe.edu.vallegrande.metamatrix.service.MetaMatrixService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/metadata")
public class MetadataRestController {

    private final MetaMatrixService metaMatrixService;

    @Autowired
    public MetadataRestController(MetaMatrixService metaMatrixService) {
        this.metaMatrixService = metaMatrixService;
    }

    @PutMapping("/active/{id}")
    public Mono<Metadata> activateMetadata(@PathVariable Integer id) {
        return metaMatrixService.activateMetadata(id);
    }

    @PutMapping("/{id}")
    public Mono<Metadata> updateMetadata(@PathVariable Integer id, @RequestBody Metadata metadata) {
        return metaMatrixService.updateMetadata(id, metadata);
    }

    @DeleteMapping("/inactive/{id}")
    public Mono<Metadata> deactivateMetadata(@PathVariable Integer id) {
        return metaMatrixService.deactivateMetadata(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteMetadata(@PathVariable Integer id) {
        return metaMatrixService.deleteMetadata(id);
    }
}
