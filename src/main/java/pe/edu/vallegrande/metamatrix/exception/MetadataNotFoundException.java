package pe.edu.vallegrande.metamatrix.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MetadataNotFoundException extends RuntimeException {
    public MetadataNotFoundException(String message) {
        super(message);
    }
}
