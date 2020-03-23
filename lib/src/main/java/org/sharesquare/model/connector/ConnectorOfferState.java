package org.sharesquare.model.connector;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper=false)
public class ConnectorOfferState extends AbstractShareSquareObject {

    UUID connectorId;
    UUID hubId;
    UUID offerIdHub;
    UUID offerIdTarget;
    ZonedDateTime lastUpdateHub;
    ZonedDateTime lastUpdateTarget;

}
