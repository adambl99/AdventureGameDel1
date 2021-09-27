package com.company;

public class Actor extends Thing {
    private Room room; //Rummet spilleren er i

    public Actor(String aName, String aDescription, Room aRoom){
        super(aName, aDescription);
        this.room = aRoom;
    }
    public void setRoom(Room aRoom){
        this.room = aRoom;
    }
    public Room getRoom(){
        return  this.room;
    }
}
