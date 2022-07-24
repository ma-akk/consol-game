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

    //одинаковый и у игрока, и у врага, по-разному получаем сигнал
    //если вернули 0 - шаг не сделан, ждем следующего сигнала
    public Position doStep(Signal direction) {
        characterPos = getPotentialPos(direction);
        return characterPos;
    }

    //здесь ' ' - это пустое место (будет заменено)
    // true - если ожидаемая позиция цель или пустое место
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
