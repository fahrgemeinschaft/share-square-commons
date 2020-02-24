package org.sharesquare.model;

import lombok.Data;
import org.sharesquare.AbstractShareSquareObject;

@Data
public class ContactOption extends AbstractShareSquareObject {

    public enum ContactType{
        //TODO
    }

    private String contactType;
    private String contactIdentifier;

}
