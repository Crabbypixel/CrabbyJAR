import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class PixelPaint extends Frame {
    private static final long serialVersionUID = 1L;

    Font f;
    int startX, startY;
    int endX, endY;
    int distance;
    // char key = 'b';
    
    public PixelPaint() {
        f = new Font("Monospaced", Font.ITALIC | Font.BOLD, 15);
        setFont(f);

        setBackground(new Color(0xf2f2f2));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addMouseListener(new HandleMouseEvents());
        addMouseMotionListener(new HandleMouseEvents());
    }

    class HandleMouseEvents extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();

            repaint();
        }

        public void mouseDragged(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();

            repaint();
        }

        public void mouseMoved(MouseEvent e) {
            startX = endX = e.getX();
            startY = endY = e.getY();
        }

        public void mouseExited(MouseEvent e) {
        }
    }

    /*class HandleKeyboardEvents extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            key = e.getKeyChar();
        }
    }*/

    public void paint(Graphics g) {
        g.drawString("Beta - 2.0", 12, 45);

        distance = (int)sqrt((pow(startX - endX, 2) + pow(startY - endY, 2)));
        g.drawString("Distance: " + distance + " pixels", 12, 60);

        g.drawLine(startX, startY, endX, endY);
    }

    public static void main(String[] args) {
        PixelPaint draw = new PixelPaint();
        draw.setSize(700, 500);
        draw.setTitle("PixelPaint");
        draw.setVisible(true);
    }
}