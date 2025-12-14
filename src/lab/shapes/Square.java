/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.shapes;

/**
 *
 * @author vrund
 */
public class Square implements Shape {
    private final String color;
    private final double sideLength;

    public Square(String color, double sideLength) {
        this.color = normalizeColor(color);
        this.sideLength = sideLength;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    private String normalizeColor(String c) {
        if (c == null) return "";
        return c.trim().toLowerCase();
    }
}
