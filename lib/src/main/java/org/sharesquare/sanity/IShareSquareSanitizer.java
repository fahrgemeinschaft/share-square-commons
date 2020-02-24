package org.sharesquare.sanity;

import org.sharesquare.IShareSquareObject;

import java.util.UUID;

public interface IShareSquareSanitizer<T extends IShareSquareObject> {

    boolean isSane(T data);

    boolean isIdValid(final String id);

    boolean isIdValid(final UUID id);
}
