package edu.school21.game;

public abstract class Character {

    protected Position characterPos;

    protected Position characterGoal;

    public Position getCharacterPos() {
        return characterPos;
    }

    public Position getCharacterGoal() {
        return characterGoal;
    }

    public void setCharacterPos(Position characterPos) {
        this.characterPos = characterPos;
    }

    public void setCharacterGoal(Position characterGoal) {
        this.characterGoal = characterGoal;
    }

    public Position doStep(Signal direction) {
        characterPos = getPotentialPos(direction);
        return characterPos;
    }

    public Position doStep(Position position) {
        characterPos = position;
        return characterPos;
    }

    public boolean isAbleMakeMove(Position position) {
        return position.equals(characterGoal) ||
                position.getType() == Type.EMPTY;
    }

    public Position getPotentialPos(Signal direction) {

        Position nextPos = new Position(characterPos);

        if (direction != null && direction.equals(Signal.UP)) {
            nextPos.decY();
        }
        if (direction != null && direction.equals(Signal.DOWN)) {
            nextPos.incY();
        }
        if (direction != null && direction.equals(Signal.RIGHT)) {
            nextPos.decX();
        }
        if (direction != null && direction.equals(Signal.LEFT)) {
            nextPos.incX();
        }
        return nextPos;
    }

    public void getMessageFinish(String message) {
        System.out.println(message);
        System.exit(0);
    }
}
