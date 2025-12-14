/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.shapes;

/**
 *
 * @author vrund
 */

public class Circle implements Shape {
    private static final double PI = 3.14;

    private final String color;
    private final double radius;

    public Circle(String color, double radius) {
        this.color = normalizeColor(color);
        this.radius = radius;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    private String normalizeColor(String c) {
        if (c == null) return "";
        return c.trim().toLowerCase();
    }
}
