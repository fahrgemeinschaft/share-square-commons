package org.sharesquare.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

import io.swagger.v3.oas.annotations.media.Schema;

import java.net.URL;

@Data
@EqualsAndHashCode(callSuper=false)
public class TargetSystem extends AbstractShareSquareObject {

    private String name;

    private String description;

    @Schema(example = "http://pendlernetz.de")
    private URL vanityUrl;

    // ISO-639-1 conform
    private String contentLanguage;

    private String dataProtectionRegulations;

    private Connector connector;

    private boolean active;
}
