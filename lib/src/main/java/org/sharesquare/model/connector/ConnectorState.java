package org.sharesquare.model.connector;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

import java.time.ZonedDateTime;

@Data
@EqualsAndHashCode(callSuper=false)
public class ConnectorState extends AbstractShareSquareObject {

    /**
     * Current State of Connector.
     */
    ConnectorStateValues state;
    /**
     * The last time this connector had the state "ALIVE"
     */
    ZonedDateTime lastAlive;
    /**
     * the last time this connector was pinged on aliveCheck Endpoint.
     */
    ZonedDateTime lastChecked;


}
