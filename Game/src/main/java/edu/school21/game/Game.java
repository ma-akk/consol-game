package edu.school21.game;

import java.io.IOException;

public class Game {

    public static void main(String[] args) throws InterruptedException, IOException {

        Logic logicGame = new Logic();
        logicGame.start(args);

//        System.out.print("\033[H\033[J");


        //вариант очистки экрана №1
//        ConsoleReader r = new ConsoleReader();
//        while (true)
//        {
//            r.println("Good morning");
//            r.flush();
//
//            String input = r.readLine("prompt>");
//
//            if ("clear".equals(input))
//                r.clearScreen();
//            else if ("exit".equals(input))
//                return;
//            else
//                System.out.println("You typed '" + input + "'.");
//    }

        //вариант очистки экрана №2
//        Runtime.getRuntime().exec("clear");
//        System.out.print("\b") ; - не удаляет предыдущую строчку

        //вариант №3
//        public static void clearScreen() {
//            System.out.print("\033[H\033[2J");
//            System.out.flush();
//        }
    }
}
