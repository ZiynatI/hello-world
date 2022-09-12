package org.helloworld.task;

public class  KnightsPossibleMove {
    int source;
    KnightsPossibleMove rightRightDown;
    KnightsPossibleMove rightRightUp;
    KnightsPossibleMove leftLeftUp;
    KnightsPossibleMove leftLeftDown;
    KnightsPossibleMove upUpRight;
    KnightsPossibleMove upUpLeft;
    KnightsPossibleMove downDownRight;
    KnightsPossibleMove downDownLeft;

    public KnightsPossibleMove(int source) {
        this.source = source;
    }


    public int getRightRightUp(int src) {
        if (src % 8 == 6) {
            return -1;
        } else {
            return src + 2 - 8;
        }
    }

    public static int getRightRightDown(int src) {
        if (src % 8 == 6) {
            return -1;
        } else {
            return src + 2 + 8;
        }
    }

    public static int getLeftLeftUp(int src) {
        if (src % 8 == 1) {
            return -1;
        } else {
            return src - 1 - 8;
        }
    }

    public static int getLeftLeftDown(int src) {
        if (src % 8 == 1) {
            return -1;
        } else {
            return src - 1 + 8;
        }
    }

    public static int getUpUpRight(int src) {
        if (src < 16) {
            return -1;
        } else {
            return src - 2 * 8 + 1;
        }
    }

    public static int getUpUpLeft(int src) {
        if (src < 16) {
            return -1;
        } else {
            return src - 2 * 8 - 1;
        }
    }

    public static int getDownDownRight(int src) {
        if (src > 47) {
            return -1;
        } else {
            return src + 2 * 8 + 1;
        }
    }

    public static int getDownDownLeft(int src) {
        if (src > 47) {
            return -1;
        } else {
            return src + 2 * 8 - 1;
        }
    }

    public KnightsPossibleMove(int source, KnightsPossibleMove rightRightDown,
                               KnightsPossibleMove rightRightUp,
                               KnightsPossibleMove leftLeftUp,
                               KnightsPossibleMove leftLeftDown,
                               KnightsPossibleMove upUpRight,
                               KnightsPossibleMove upUpLeft,
                               KnightsPossibleMove downDownRight,
                               KnightsPossibleMove downDownLeft) {
        this.source = source;
        this.rightRightDown = rightRightDown;
        this.rightRightUp = rightRightUp;
        this.leftLeftUp = leftLeftUp;
        this.leftLeftDown = leftLeftDown;
        this.upUpRight = upUpRight;
        this.upUpLeft = upUpLeft;
        this.downDownLeft = downDownLeft;
        this.downDownRight = downDownRight;
    }
}
