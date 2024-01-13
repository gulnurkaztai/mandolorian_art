import java.awt.Color;

public class Art {

    public static void branch(int n, double x1, double y1, double angle, double len) {
        if (n == 0) return;
        else {
            double x2 = x1 + Math.cos(angle) * len;
            double y2 = y1 + Math.sin(angle) * len;
            if (len < 0.06) {
                StdDraw.setPenColor(Color.PINK);
            }
            else StdDraw.setPenColor(Color.GRAY);
            StdDraw.line(x1, y1, x2, y2);
            // length gets smaller by a third
            // start drawing where the prev line ended
            // rotate 30 degrees left and right
            branch(n - 1, x2, y2, angle - Math.PI / 5, len * 0.67);
            branch(n - 1, x2, y2, angle + Math.PI / 5, len * 0.67);
            // branch(n - 1, x2, y2, angle, len * 0.67);
        }
    }

    public static void tieFighter(double x, double y) {
        // picture(double x, double y, String filename, double scaledWidth, double scaledHeight)
        StdDraw.picture(x, y, "tie_fighter.png", 0.06, 0.03);
    }

    public static void gideons546Cruiser() {
        StdDraw.picture(0.3, 0.9, "SWBII-ImperialCruiser.png", 0.6, 0.2);
    }

    public static void army(int n, double x, double y) {
        if (n == 0) return;
        else tieFighter(x, y);
        // OR, they can be randomly dispersed
        double rx = 0.05; // Math.random() / 10 + 0.02;
        double ry = 0.05; // Math.random() / 10 + 0.02;
        army(n - 1, x + rx, y + ry);
        army(n - 1, x - rx, y + ry);
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(460, 980);
        StdDraw.picture(0.5, 0.5, "Mandalorian.jpg");
        // To show at once
        // warning! takes FOREVER
        // StdDraw.enableDoubleBuffering();
        int n1 = 10; // number of recursion for the branch()
        double x1 = 0.3;
        double y1 = 0.02;
        double len = 0.15;
        branch(n1, x1, y1, Math.PI / 2, len);
        // StdDraw.show();
        gideons546Cruiser();
        int n = 7; // number of tie fighters
        double x = 0.5;
        double y = 0.5;
        army(n, x, y);
        // StdDraw.show();
    }
}
