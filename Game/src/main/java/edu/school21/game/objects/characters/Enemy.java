package edu.school21.game;

public class Enemy extends Character {

    private StepDirection step = new StepDirection();

    public Enemy(Position position) {
        this.characterPos = new Position(position);
    }

    public Enemy(int x, int y, Design design, Type type) {
        this.characterPos = new Position(x, y, design, type);
    }

    public Enemy() {
    }

    public Position getStepDirection(char[][] cardByChar, char emptyChar) {
        step.getStepDirection(this.characterPos.getX(), this.characterPos.getY(),
                cardByChar, this.characterPos.getSymbol(),
                this.characterGoal.getSymbol(), emptyChar);
        int newX = step.getX();
        int newY = step.getY();
        if (newX > 0 && newY > 0) {
            this.characterPos.setX(newX);
            this.characterPos.setY(newY);
        }
        return characterPos;
    }

    @Override
    public Position doStep(Signal direction) {
        return super.doStep(direction);
    }
}
