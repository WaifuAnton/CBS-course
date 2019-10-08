package task2_annot;

/**
 * @author Anton
 * @version 1 BETA
 */
public class Calculator {
    /**
     *
     * @param left is left side of equation
     * @param right is right side of equation
     * @return sum
     */
    @Math(left = 12, right = 12)
    public double add(double left, double right) {
        return left + right;
    }

    /**
     *
     * @param left is left side of equation
     * @param right is right side of equation
     * @return difference
     */
    @Math(left = 12, right = 12)
    public double distract(double left, double right) {
        return left - right;
    }

    /**
     *
     * @param left is left side of equation
     * @param right is right side of equation
     * @return multiplication
     */
    @Math(left = 12, right = 12)
    public double mult(double left, double right) {
        return left * right;
    }

    /**
     *
     * @param left is left side of equation
     * @param right is right side of equation
     * @return division
     */
    @Math(left = 12, right = 12)
    public double div(double left, double right) {
        return left / right;
    }
}
