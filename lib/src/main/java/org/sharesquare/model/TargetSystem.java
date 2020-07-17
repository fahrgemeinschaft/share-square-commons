package org.sharesquare.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

import io.swagger.v3.oas.annotations.media.Schema;

import java.net.URL;

@Data
@EqualsAndHashCode(callSuper=false)
public class TargetSystem extends AbstractShareSquareObject {

    String name;
    String description;
    @Schema(example = "http://pendlernetz.de")
    URL vanityUrl;
    // ISO-639-1 conform
    String contentLanguage;
    String dataProtectionRegulations;
    Connector connector;
}
