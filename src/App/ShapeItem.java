package App;

import java.awt.*;

public class ShapeItem {
    private final Point point;
    private final Shapes shape;

    public ShapeItem(Point p, Shapes s){
        point = p;
        shape = s;
    }

    public Shapes getShape(){
        return shape;
    }

    public Point getPoint(){
        return point;
    }
}
