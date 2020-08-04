package org.sharesquare.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

import io.swagger.v3.oas.annotations.media.Schema;

import java.net.URI;
import java.util.List;
@Data
@EqualsAndHashCode(callSuper=false)
public class Connector extends AbstractShareSquareObject {

    @Schema(example = "http://pendlernetz.de/api/offers")
    private URI offerUpdateWebhook;

    @Schema(example = "http://pendlernetz.de/api/alivecheck")
    private URI aliveCheckWebhook;

    private String apikey;

    private List<Client> clients;
}
