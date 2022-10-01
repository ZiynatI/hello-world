package codewars.oop;

public class Dih4 {
    //https://www.codewars.com/kata/591521e2d64db03a010000fe
    //There are exactly eight ways to map a square onto itself by rotation or reflection. We can take its mirror
    //image (reflection in horizontal, vertical, or either of two 45-degree diagonal lines); rotate it
    //(by 90 degrees clockwise, 90 degrees anti-clockwise, or 180 degrees); or just leave it alone.
    //These eight transformations together comprise the dihedral group Dih(4).
    //In this kata we're going to write a class Dih4 that represents this collection of rotations and reflections.
    //An object (instance) of this class will have one of eight possible values, corresponding to the eight transformations.
    //The Dih4 class will need to include at least the following features:
    //    Names or constants for the possible values:
    //    IDENTITY
    //    ROTATE_90_ANTICLOCKWISE
    //    ROTATE_180
    //    ROTATE_90_CLOCKWISE
    //    REFLECT_VERTICAL
    //    REFLECT_FORWARD_DIAGONAL
    //    REFLECT_HORIZONTAL
    //    REFLECT_REVERSE_DIAGONAL
    //    (these are in the same order as in the picture above).
    //    A function then() that works out the effect of performing transformations successively. For example, if r is the 90-degree clockwise rotation and f is the reflection with vertical mirror line, r.then(f) should equal the reflection with reverse-diagonal mirror line.
    //    A function inv() that gives the inverse (opposite) of a transformation. For example, if r is the 90-degree clockwise rotation, then r.inv() should equal the 90-degree anticlockwise rotation.
    //    Functions is_rotation() and is_reflection() that test whether a transformation is a rotation or a reflection. (The identity transformation is considered to be a rotation (by 0 degrees) but not a reflection.)
    //    Tests for equality and inequality: an equals() method (Java) or == and != operators (C++).
    //See the example tests for more examples of how the syntax of Dih4 objects should go.

//    public static String Dih4_to_String(Dih4 r) {
//        IDENTITY
//                ROTATE_90_ANTICLOCKWISE
//        ROTATE_180
//                ROTATE_90_CLOCKWISE
//        REFLECT_VERTICAL
//                REFLECT_FORWARD_DIAGONAL
//        REFLECT_HORIZONTAL
//                REFLECT_REVERSE_DIAGONAL
//        return r.equals(IDENTITY) ? "identity transformation"
//                : r.equals(ROTATE_90_ANTICLOCKWISE) ? "rotation 90 degrees anticlockwise"
//                : r.equals(ROTATE_180) ? "rotation 180 degrees"
//                : r.equals(ROTATE_90_CLOCKWISE) ? "rotation 90 degrees clockwise"
//                : r.equals(REFLECT_VERTICAL) ? "reflection in vertical line"
//                : r.equals(REFLECT_FORWARD_DIAGONAL) ? "reflection in forward-diagonal line"
//                : r.equals(REFLECT_HORIZONTAL) ? "reflection in horizontal line"
//                : r.equals(REFLECT_REVERSE_DIAGONAL) ? "reflection in reverse-diagonal line"
//                : "unknown Dih4 value";
//    }
}
