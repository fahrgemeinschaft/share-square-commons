package org.sharesquare.events;

public interface IShareSquareEventProducer<T> {


    void produce(ShareSquareEvent<T> shareSquareEvent);
}
