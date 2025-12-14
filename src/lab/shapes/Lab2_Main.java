/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.shapes;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author vrund
 */

public class Lab2_Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<>();

        System.out.println("Enter shapes as: <circle|square> <red|green|blue> <size>");
        System.out.println("Example: circle red 2.5");
        System.out.println("Type 'done' to finish, or start with a number (count) then provide that many shapes.\n");

        // Support both input styles:
        // Style A: first token is an integer N (number of shapes)
        // Style B: read triples until "done" or EOF
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if (!sc.hasNext()) break;
                readOneShape(sc, shapes);
            }
        } else {
            while (sc.hasNext()) {
                String token = sc.next();
                if (token.equalsIgnoreCase("done")) break;
                // token is shape type; we need color + size next
                readOneShapeWithFirstToken(sc, shapes, token);
            }
        }

        double redTotal = 0.0, greenTotal = 0.0, blueTotal = 0.0;

        for (Shape s : shapes) {
            String c = s.getColor();
            double area = s.getArea();

            switch (c) {
                case "red" -> redTotal += area;
                case "green" -> greenTotal += area;
                case "blue" -> blueTotal += area;
                default -> System.out.println("Ignored shape with invalid color: " + c);
            }
        }

        System.out.printf("%nTotal area of RED shapes:   %.2f%n", redTotal);
        System.out.printf("Total area of GREEN shapes: %.2f%n", greenTotal);
        System.out.printf("Total area of BLUE shapes:  %.2f%n", blueTotal);
    }

    private static void readOneShape(Scanner sc, ArrayList<Shape> shapes) {
        String type = sc.next();
        if (!sc.hasNext()) return;
        String color = sc.next();
        if (!sc.hasNextDouble()) return;
        double size = sc.nextDouble();

        addShape(type, color, size, shapes);
    }

    private static void readOneShapeWithFirstToken(Scanner sc, ArrayList<Shape> shapes, String type) {
        if (!sc.hasNext()) return;
        String color = sc.next();
        if (!sc.hasNextDouble()) return;
        double size = sc.nextDouble();

        addShape(type, color, size, shapes);
    }

    private static void addShape(String type, String color, double size, ArrayList<Shape> shapes) {
        if (size < 0) {
            System.out.println("Ignored: size cannot be negative (" + size + ")");
            return;
        }

        if (type.equalsIgnoreCase("circle")) {
            shapes.add(new Circle(color, size)); // size = radius
        } else if (type.equalsIgnoreCase("square")) {
            shapes.add(new Square(color, size)); // size = side length
        } else {
            System.out.println("Ignored: unknown shape type: " + type);
        }
    }
}
