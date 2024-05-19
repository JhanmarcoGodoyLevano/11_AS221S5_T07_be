package pe.edu.vallegrande.metamatrix.dto;

import lombok.Data;

@Data
public class AnalysisResultDTO {
    private UsageDTO usage;
    private String retrieved_url;
    private MetadataDTO metadata;
    private String language;
}
