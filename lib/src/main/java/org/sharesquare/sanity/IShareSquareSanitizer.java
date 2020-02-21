package org.sharesquare.sanity;

import org.sharesquare.IShareSquareObject;

public interface IShareSquareSanitizer<T extends IShareSquareObject> {

    boolean isSane(T data);

}
