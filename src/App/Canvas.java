package App;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JComponent {

    private Image image;
    private final ArrayList<ShapeItem> shapeList = new ArrayList<>();


    public void paint(Graphics g){
        g.drawImage(image,0,0,null);
    }

    private void recreateImage(Graphics g){
        for(ShapeItem shape: shapeList){
            Shapes s = shape.getShape();
            Point p = shape.getPoint();
            switch (s) {
                case RECTANGLE -> g.fillRect(p.x,p.y, 30,30);
                case ELLIPSE -> g.fillOval(p.x,p.y,30,15);
                case CIRCLE -> g.fillOval(p.x,p.y,30,30);
                case NULL -> g.clearRect(p.x,p.y, 30,30);
            }
        }
    }

    public void preview(Point point, Shapes shape){
        image = createImage(getWidth(),getHeight());
        Graphics g = image.getGraphics();
        recreateImage(g);

        switch (shape) {
            case RECTANGLE -> g.fillRect(point.x,point.y, 30,30);
            case ELLIPSE -> g.fillOval(point.x,point.y,30,15);
            case CIRCLE -> g.fillOval(point.x,point.y,30,30);
            case NULL -> g.clearRect(point.x,point.y, 30,30);
        }
        repaint();
    }

    public void commit(Point point, Shapes shape){
        shapeList.add(new ShapeItem(point, shape));
    }
}
