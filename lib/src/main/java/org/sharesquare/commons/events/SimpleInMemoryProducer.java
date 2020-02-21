package org.sharesquare.commons.events;

import org.sharesquare.IShareSquareObject;
import org.sharesquare.events.IShareSquareEventProducer;
import org.sharesquare.events.ShareSquareEvent;

public class SimpleInMemoryProducer<T extends IShareSquareObject> implements IShareSquareEventProducer<T> {


    @Override
    public void produce(ShareSquareEvent<T> shareSquareEvent) {

    }
}
