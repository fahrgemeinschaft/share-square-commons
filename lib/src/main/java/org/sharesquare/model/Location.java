package org.sharesquare.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sharesquare.AbstractShareSquareObject;

@Data
@EqualsAndHashCode(callSuper=false)
public class Location extends AbstractShareSquareObject {

    public enum type {
        Address,
        City
    }

    private long latitude;
    private long longitude;
    private String name;
    private type type;

}
