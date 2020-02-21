package org.sharesquare.events;

public interface IShareSquareEventConsumer<T> {

    public void consume(ShareSquareEvent<T> event);
}
