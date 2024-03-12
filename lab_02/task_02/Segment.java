package lab_02.task_02;
import java.util.Scanner;

public class Segment {
	private Point start;
    private Point end;
    
  
    public Segment(Point start, Point end) {
    	if (start.x == end.x && start.y == end.y) {
    		System.err.println("Початкова та кінцева точки відрізка не можуть співпадати");
            return;
    	}
        this.start = start;
        this.end = end;
    }
    
    public double length() {
        return Math.sqrt(Math.pow(end.x - start.x, 2) + Math.pow(end.y - start.y, 2));
    }

    public Point middle() {
        double midX = (start.x + end.x) / 2;
        double midY = (start.y + end.y) / 2;
        return new Point(midX, midY);
    }

    public Point intersection(Segment another) {
        double x1 = start.x;
        double y1 = start.y;
        double x2 = end.x;
        double y2 = end.y;
        
        double x3 = another.start.x;
        double y3 = another.start.y;
        double x4 = another.end.x;
        double y4 = another.end.y;
        
        double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        
        if (d == 0) {
            return null;
        }
        
        double xi = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
        double yi = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;
        
        Point intersectionPoint = new Point(xi, yi);

        if (xi < Math.min(x1, x2) || xi > Math.max(x1, x2) ||
            xi < Math.min(x3, x4) || xi > Math.max(x3, x4) ||
            yi < Math.min(y1, y2) || yi > Math.max(y1, y2) ||
            yi < Math.min(y3, y4) || yi > Math.max(y3, y4)) {
            return null;
        }
        
        return intersectionPoint;
    }
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        System.out.println("Введіть координати початкової точки першого відрізка:");
        double x1 = console.nextDouble();
        double y1 = console.nextDouble();
        
        System.out.println("Введіть координати кінцевої точки першого відрізка:");
        double x2 = console.nextDouble();
        double y2 = console.nextDouble();
        
        System.out.println("Введіть координати  точки другого відрізка:");
        double x3 = console.nextDouble();
        double y3 = console.nextDouble();
        
        System.out.println("Введіть координати кінцевої точки другого відрізка:");
        double x4 = console.nextDouble();
        double y4 = console.nextDouble();

        Segment segment1 = new Segment(new Point(x1, y1), new Point(x2, y2));
        Segment segment2 = new Segment(new Point(x3, y3), new Point(x4, y4));

        System.out.printf("Довжина першого відрізка: %.2f\n", segment1.length());
        
        Point middlePoint = segment1.middle();
        System.out.println("Середня точка першого відрізка: " + middlePoint);
        
        Point intersectionPoint = segment1.intersection(segment2);
        if (intersectionPoint != null) {
            System.out.println("Точка перетину відрізків: " + intersectionPoint);
        } else {
            System.out.println("Відрізки не перетинаються або паралельні.");
        }
        
        console.close();
    }
}
