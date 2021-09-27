package com.company;

import java.util.*;

public class GameMap {
    private ArrayList<Room>map; //vores map layout
    private Actor player;
    List<String> commands = new ArrayList<>(Arrays.asList("n", "go north", "go south", "s", "go west", "w", " go east", "e"));


    public GameMap(){
        this.map = new ArrayList<Room>();
        //tekst til rum kan ændres, laver korte tekster for at teste
        //Rum numrene er lavet med udgangspunkt i tal værdierne givet i vores opgaveformulering på fronter

                                               //N           //S       //W        //E
        map.add(new Room("Room 1 TEST", "Rum1", Direction.NOEXIT, 1, Direction.NOEXIT, 8));
        map.add(new Room("Room 4 TEST", "Rum4", 1, 2, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("Room 7 TEST", "Rum7", 1, Direction.NOEXIT, Direction.NOEXIT, 3));
        map.add(new Room("Room 8 TEST", "Rum8", 4, Direction.NOEXIT, 2, 5));
        map.add(new Room("Room 5 TEST", "Rum5", Direction.NOEXIT, 3, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("Room 9 TEST", "Rum9", 6, Direction.NOEXIT, 3, Direction.NOEXIT));
        map.add(new Room("Room 6 TEST", "Rum6", 7, 5, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("Room 3 TEST", "Rum3", Direction.NOEXIT, 6, 8, Direction.NOEXIT));
        map.add(new Room("Room 2 TEST", "Rum2", Direction.NOEXIT, Direction.NOEXIT, 0, 7));

        player = new Actor("player1","spiller1", map.get(0));
    }
    ArrayList getMap(){
        return map;
    }
    void setMap(ArrayList aMap){
        map = aMap;
    }
    public Actor getPlayer(){
        return player;
    }
    public void setPlayer(Actor aPlayer){
        player = aPlayer;
    }

    void moveActorTo(Actor p, Room aRoom){
        p.setRoom(aRoom);
    }

    int moveTo(Actor anActor, Direction dir){
        Room r = anActor.getRoom();
        int exit;
        switch (dir){
            case NORTH:
                exit = r.getN();
                break;
            case SOUTH:
                exit = r.getS();
                break;
            case EAST:
                exit = r.getE();
                break;
            case WEST:
                exit = r.getW();
                break;
            default:
                exit = Direction.NOEXIT;
                break;
        }
        if (exit != Direction.NOEXIT){
            moveActorTo(anActor, map.get(exit));
        }
        return exit;
    }

    public int movePlayerTo(Direction dir){
        return moveTo(player, dir);
    }
    private void goN(){
        updateOutput(movePlayerTo(Direction.NORTH));
    }
    private void goS(){
        updateOutput(movePlayerTo(Direction.SOUTH));
    }
    private void goW(){
        updateOutput(movePlayerTo(Direction.WEST));
    }
    private void goE(){
        updateOutput(movePlayerTo(Direction.EAST));
    }
    void updateOutput(int roomNumber){
        String s;
        if(roomNumber == Direction.NOEXIT){
            s = "You can't go this way as the pathway is blocked, try a different direction!";
        }else {
            Room r = getPlayer().getRoom();
            s = "You are in " + r.getName() + ". " + r.getDescription();
        }
        System.out.println(s);
    }
    public String ProcessVerb(String wordList){
        String verb;
        String msg = "";
        verb = wordList;
            switch (verb){
                case "n":
                case "go north":
                case "north":
                    goN();
                    break;
                case "s":
                case "go south":
                case "south":
                    goS();
                    break;
                case "w":
                case "go west":
                case "west":
                    goW();
                    break;
                case "e":
                case "go east":
                case "east":
                    goE();
                    break;
                default:
                   msg = "The command is invalid";
                   break;
                case "Exit":
                case "exit":
                    System.out.println("You have quit the game, thanks for playing!");
                    System.exit(0);
                    break;
            }
        return msg;
    }
    public String ParseCommand(String wordlist){
        String msg;
            msg = ProcessVerb(wordlist);
       return msg;
    }
   public void showIntro(){
        String s;
        s = "Welcome to the Dark Tomb Chronicles.\n" + "You are about to embark on a journey into the dark halls of the Pharaoh's burial ground.\n"
                + "There are 9 rooms in this burial ground. Room number 5 holds the treasure you seeks, and it's your job to find it\n" +
                "Where do you want to go? Enter: go + the direction you want to go, or simply use n, s, w, e\n" + "You can always type in Exit to quit the game";

       System.out.println(s);
   }
   public String RunCommand(String inputstr){
        String s = "You have quit the game thanks for playing";
        String lowstr = inputstr.trim().toLowerCase();
        if (!lowstr.equals("")){
            if (lowstr.equals("")){
                s = "You must enter a command";
            }else {
                s = ParseCommand(lowstr);
            }
        }
        return s;
   }
}

