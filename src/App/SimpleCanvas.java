package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

enum Shapes {
    NULL,
    RECTANGLE,
    ELLIPSE,
    CIRCLE
}

public class SimpleCanvas extends JFrame {

    public JPanel contentPane;
    public Shapes shape = Shapes.NULL;


    public static void main(String[] args) {
        SimpleCanvas application = new SimpleCanvas();
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(application::startApp);
    }

    private void startApp() {
        contentPane = new JPanel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        contentPane.setLayout(null);
        contentPane.setBounds(0,0,500,500);
        setLayout(null);

        // Position and dimensions of the main window
        setBounds(100, 100, 480, 520);

        // Buttons creation
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(340, 440, 100, 20);

        JButton shapeButton = new JButton("Shapes");
        shapeButton.setBounds(10, 440, 100, 20);

        JButton drawButton = new JButton("Draw");
        drawButton.setBounds(130, 440, 100, 20);

        // Drawing space definition
        Canvas panel = new Canvas();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, true));
        panel.setBounds(10,10,400,400);


        // Sliders creation
        JSlider verticalSlider = new JSlider(JSlider.VERTICAL, 0, 340, 200);
        JSlider horizontalSlider = new JSlider(JSlider.HORIZONTAL, 0, 340, 200);
        horizontalSlider.setBounds(10, 410, 400, 30);
        horizontalSlider.addChangeListener(e -> {
            Point p = new Point(horizontalSlider.getValue()+5,verticalSlider.getValue()+5);
            panel.preview(p,shape);
        });

        verticalSlider.setBounds(410, 10, 30, 400);
        verticalSlider.setInverted(true);
        verticalSlider.addChangeListener(e -> {
            Point p = new Point(horizontalSlider.getValue()+5,verticalSlider.getValue()+5);
            panel.preview(p,shape);
        });

        // Shape menu creation

        JPopupMenu shapeMenu = new JPopupMenu();
        JMenuItem rectangle = shapeMenu.add("Rectangle");
        rectangle.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = Shapes.RECTANGLE;
                Point p = new Point(horizontalSlider.getValue()+5,verticalSlider.getValue()+5);
                panel.preview(p, Shapes.RECTANGLE);
            }
        });
        rectangle.setMnemonic('R');
        JMenuItem ellipse = shapeMenu.add("Ellipse");
        ellipse.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = Shapes.ELLIPSE;
                Point p = new Point(horizontalSlider.getValue()+5,verticalSlider.getValue()+5);
                panel.preview(p, Shapes.ELLIPSE);
            }
        });
        ellipse.setMnemonic('e');
        JMenuItem circle = shapeMenu.add("Circle");
        circle.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = Shapes.CIRCLE;
                Point p = new Point(horizontalSlider.getValue()+5,verticalSlider.getValue()+5);
                panel.preview(p, Shapes.CIRCLE);
            }
        });
        circle.setMnemonic('c');
        JMenuItem rubber = shapeMenu.add("Rubber");
        rubber.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = Shapes.NULL;
                Point p = new Point(horizontalSlider.getValue()+5,verticalSlider.getValue()+5);
                panel.preview(p, Shapes.NULL);
            }
        });
        shapeMenu.setInvoker(contentPane);

        // Put everything together

        add(contentPane);
        contentPane.add(exitButton);
        contentPane.add(drawButton);
        contentPane.add(shapeButton);
        contentPane.add(panel);
        contentPane.add(horizontalSlider);
        contentPane.add(verticalSlider);

        //Actions handling
        // Program exit handling
        exitButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitButton.setMnemonic('e');

        shapeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeMenu.show(shapeButton, 50,20);
            }
        });
        shapeButton.setMnemonic('s');

        drawButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = new Point(horizontalSlider.getValue()+5,verticalSlider.getValue()+5);
                panel.commit(p, shape);
            }
        });
        drawButton.setMnemonic('d');
    }

}