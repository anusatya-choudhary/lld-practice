// Open/Closed Principle (OCP)
// Software entities should be open for extension but closed for modification

//BAD EXAMPLE: Violating OCP
class ShapeBad {
    private String type;

    public ShapeBad(String type) {
        this.type = type;
    }

    // If I want to add a new shape, I have to add in the if else block in this
    // class

    public double calculateArea() {
        if (type.equals("circle")) {
            return Math.PI * 5 * 5;
        } else if (type.equals("rectangle")) {
            return 10 * 20;
        } else if (type.equals("triangle")) {
            return 0.5 * 10 * 20;
        } else {
            throw new IllegalArgumentException("Invalid shape type");
        }
    }
}

// GOOD example : Following OCP
abstract class Shape {
    abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return height * width;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

class AreaCalculator {
    public double calculateArea(Shape[] shapes) {
        double totalArea = 0;
        for(Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}

class OCPExample {
    public static void main(String[] args) {
        //Individual shapes
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(10, 20);
        Triangle triangle = new Triangle(10, 20);

        System.out.println("Area of circle: " + circle.calculateArea());
        System.out.println("Area of rectangle: " + rectangle.calculateArea());
        System.out.println("Area of triangle: " + triangle.calculateArea());

        //Array of shapes
        Shape[] shapes = {circle, rectangle, triangle};
        AreaCalculator areaCalculator = new AreaCalculator();
        System.out.println("Total area: " + areaCalculator.calculateArea(shapes));
    }
}