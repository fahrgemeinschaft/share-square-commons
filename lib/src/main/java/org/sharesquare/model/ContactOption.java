package org.sharesquare.model;

import lombok.Data;

@Data
public class ContactOption {

    public enum ContactType{
        //TODO
    }

    private String contactType;
    private String contactIdentifier;

}
