package org.sharesquare.sanity;

import org.sharesquare.IShareSquareObject;

import java.util.UUID;

public abstract class AbstractSanitizer<T extends IShareSquareObject> implements IShareSquareSanitizer<T> {

    @Override
    public boolean isIdValid(String id) {
        try {
            if (id == null) return false;
            UUID.fromString(id);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    @Override
    public boolean isIdValid(UUID id) {
        return id != null;
    }
}
