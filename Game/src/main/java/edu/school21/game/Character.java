package edu.school21.game;

public abstract class Character {

    private Position characterPos;

    private Position characterGoal;

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
    public int doStep(Signal direction) {

        Position nextPos = new Position(characterPos);

        if (direction.equals(Signal.UP)) {
            nextPos.decY();
        }
        if (direction.equals(Signal.DOWN)) {
            nextPos.incY();
        }
        if (direction.equals(Signal.RIGHT)) {
            nextPos.decX();
        }
        if (direction.equals(Signal.LEFT)) {
            nextPos.incX();
        }
        if (isAbleMakeMove(nextPos)) {
            characterPos = nextPos;
            return 1;
        }
        return 0;
    }

    //здесь ' ' - это пустое место (будет заменено)
    // true - если ожидаемая позиция цель или пустое место
    public boolean isAbleMakeMove(Position position) {
        return position.equals(characterGoal) ||
                position.getDesign() == ' ';
    }
}
