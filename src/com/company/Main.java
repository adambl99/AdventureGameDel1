package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output;
        GameMap game = new GameMap();
        in = new BufferedReader(new InputStreamReader(System.in));
        game.showIntro();
        do {
            System.out.println("> ");
            input = in.readLine();
            output = game.RunCommand(input);
            System.out.println(output);
        }while(!"exit".equals(input));
    }}
