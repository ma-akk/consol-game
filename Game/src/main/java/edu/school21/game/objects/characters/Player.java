package edu.school21.game.objects.characters;

import edu.school21.game.objects.card.Position;
import edu.school21.game.objects.enums.Signal;

import java.util.Scanner;

public class Player extends Character {

    Scanner scanner = new Scanner(System.in);

    public Player(Position characterPos, Position characterGoal) {
        this.characterPos = characterPos;
        this.characterGoal = characterGoal;
    }

    public Signal getValueSignal() {

        String signalInput = scanner.next();

        Signal result = null;

        if (signalInput.toLowerCase().charAt(0) == 'a') {
            result = Signal.LEFT;
        }
        if (signalInput.toLowerCase().charAt(0) == 'w') {
            result = Signal.UP;
        }
        if (signalInput.toLowerCase().charAt(0) == 'd') {
            result = Signal.RIGHT;
        }
        if (signalInput.toLowerCase().charAt(0) == 's') {
            result = Signal.DOWN;
        }
        if (signalInput.toLowerCase().charAt(0) == '9') {
            result = Signal.GIVEUP;
        }
        scanner.nextLine();
        return result;
    }
    public Signal getStepSignal() {

        Signal valueSignal = getValueSignal();

        Position potentialPos = this.getPotentialPos(valueSignal);

        if (valueSignal == Signal.GIVEUP) {
            scanner.close();
            getMessageFinish("YOU GAVE UP! FAIL!");
        }
        while (characterPos.equals(potentialPos) &&
                !isAbleMakeMove(potentialPos)) {
            valueSignal = getValueSignal();
            potentialPos = this.getPotentialPos(valueSignal);
        }
//        if (valueSignal == Signal.CONFIRM &&
//                profile.equals("dev")) {
//            method confirmStepEnemy();
//        }
        return valueSignal;
    }
}
