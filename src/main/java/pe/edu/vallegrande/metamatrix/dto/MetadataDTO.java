package pe.edu.vallegrande.metamatrix.dto;

import lombok.Data;
import java.util.List;

@Data
public class MetadataDTO {
    private String title;
    private String publication_date;
    private String image;
    private List<FeedDTO> feeds;
    private List<AuthorDTO> authors;
}
