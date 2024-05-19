package pe.edu.vallegrande.metamatrix.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.vallegrande.metamatrix.dto.AuthorDTO;
import pe.edu.vallegrande.metamatrix.dto.FeedDTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Data @NoArgsConstructor @Table("metadata")
public class Metadata {
    @Id private Integer id;
    private String title;
    private LocalDateTime publicationDate;
    private String imageUrl;
    private String feeds;
    private String authors;
    private char active;

    public void setPublicationDate(String publicationDate) {
        if (!Objects.isNull(publicationDate) && !publicationDate.isEmpty()) {
            this.publicationDate = LocalDateTime.parse(publicationDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }

    public void setFeeds(List<FeedDTO> feeds) {
        try {
            this.feeds = new ObjectMapper().writeValueAsString(feeds);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing feeds", e);
        }
    }

    public void setAuthors(List<AuthorDTO> authors) {
        try {
            this.authors = new ObjectMapper().writeValueAsString(authors);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing authors", e);
        }
    }

    public void updateTitle(String title) { this.title = title; }

    public void updatePublicationDate(LocalDateTime publicationDate) { this.publicationDate = publicationDate; }

    public void updateImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public void updateFeeds(String feeds) { this.feeds = feeds; }

    public void updateAuthors(String authors) { this.authors = authors; }
}
