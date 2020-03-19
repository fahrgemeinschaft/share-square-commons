package org.sharesquare.model.connector;

import lombok.Data;
import org.sharesquare.AbstractShareSquareObject;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class ConnectorOfferState extends AbstractShareSquareObject {

    UUID connectorId;
    UUID hubId;
    UUID offerIdHub;
    UUID offerIdTarget;
    ZonedDateTime lastUpdateHub;
    ZonedDateTime lastUpdateTarget;

}
