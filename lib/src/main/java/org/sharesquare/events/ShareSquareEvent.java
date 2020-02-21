package org.sharesquare.events;

import lombok.Data;
import org.sharesquare.IShareSquareObject;

import java.time.ZonedDateTime;

@Data
public class ShareSquareEvent<T extends IShareSquareObject> {

    public enum EventType {
        CREATE,
        UPDATE,
        DELETE
    }

    ZonedDateTime createdAt;

    T payload;

    EventType eventType;
}
