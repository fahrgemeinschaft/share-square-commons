package org.sharesquare.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

import io.swagger.v3.oas.annotations.media.Schema;

import java.net.URL;
@Data
@EqualsAndHashCode(callSuper=false)
public class Connector extends AbstractShareSquareObject {

	@Schema(example = "http://pendlernetz.de/api/offers")
    private URL offerUpdateWebhook;

	@Schema(example = "http://pendlernetz.de/api/alivecheck")
    private URL aliveCheckWebhook;

}
