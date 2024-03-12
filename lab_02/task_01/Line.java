package lab_02.task_01;
import java.util.Scanner;

public class Line {
	double k;
    double b;
    
    public Line(double k, double b) {
        this.k = k;
        this.b = b;
    }
    
    public Point intersection(Line other) {
        if (this.k == other.k) {
            return null;
        }
        
        double x = (other.b - this.b) / (this.k - other.k);
        double y = this.k * x + this.b;
        
        return new Point(x, y);
    }
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        System.out.println("Введіть значення k та b для першої прямої:");
        double k1 = console.nextDouble();
        double b1 = console.nextDouble();
        
        System.out.println("Введіть значення k та b для другої прямої:");
        double k2 = console.nextDouble();
        double b2 = console.nextDouble();
        
        Line line1 = new Line(k1, b1);
        Line line2 = new Line(k2, b2);
        
        if (line1.intersection(line2) != null) {
            System.out.println("Точка перетину: " + line1.intersection(line2));
        } else {
            System.out.println("Прямі збігаються або паралельні, немає точки перетину.");
        }
        
        console.close();
    }
}
