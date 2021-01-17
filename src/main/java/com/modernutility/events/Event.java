package com.modernutility.events;

public class Event<T> {

    public boolean cancelled;

    public EventType type;

    public EventDirection direction;

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public EventDirection getDirection() {
        return direction;
    }

    public void setDirection(EventDirection direction) {
        this.direction = direction;
    }

    public boolean isPre()
    {
        // check if event is pre
        if(type == null)
        {
            return false; // if there is no event, it's not pre
        }
        return type == EventType.PRE;
    }
    public boolean isPost()
    {
        // check if event is post
        if(type == null)
        {
            return false; // if there is no event, it's not post
        }
        return type == EventType.POST;
    }
    public boolean isIncoming()
    {
        if(direction == null)
        {
            return false; // not incoming
        }
        return direction == EventDirection.INCOMING; // return that direction is INCOMING
    }
    public boolean isOutgoing()
    {
        if(direction == null)
        {
            return false; // not incoming
        }
        return direction == EventDirection.OUTGOING; // return that direction is OUTGOING
    }
}
