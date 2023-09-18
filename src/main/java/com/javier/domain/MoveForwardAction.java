package com.javier.domain;

public class MoveForwardAction {
    private final Vector2 newPosition;

    public MoveForwardAction(Vector2 position, Heading heading) {
        switch (heading) {
            case N:
                newPosition = new Vector2(position.x(), position.y() + 1);
                break;
            case S:
                newPosition = new Vector2(position.x(), position.y() - 1);
                break;
            case E:
                newPosition = new Vector2(position.x() + 1, position.y());
                break;
            case W:
                newPosition = new Vector2(position.x() - 1, position.y());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + heading);
        }
    }

    public Vector2 getNewPosition() {
        return newPosition;
    }
}
