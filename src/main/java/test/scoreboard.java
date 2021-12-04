package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class scoreboard  extends JComponent implements MouseListener, MouseMotionListener {

    private static final Color BG_COLOR = Color.pink.brighter();
    private static final Color BORDER_COLOR = new Color(200, 8, 21); //Venetian Red
    private static final Color DASH_BORDER_COLOR = new Color(255, 216, 0);//school bus yellow
    private static final Color TEXT_COLOR = new Color(100, 52, 166);//egyptian blue
    private static final Color CLICKED_BUTTON_COLOR = BG_COLOR.darker();
    private static final Color CLICKED_TEXT = Color.BLACK;
    private static final int BORDER_SIZE = 5;
    private static final float[] DASHES = {12, 6};
    private static final String B2MENU_TEXT = "Back";

    private GameFrame owner;

    private boolean startClicked;
    private boolean menuClicked;

    private BasicStroke borderStoke;
    private BasicStroke borderStoke_noDashes;


    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;

    private Rectangle scoreboardFace;
    private Rectangle backButton;

    private Font TitleFont;
    private Font buttonFont;
    //private Rectangle menuButton;

    public scoreboard(JFrame owner) {


        this.initialize();

        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        //this.owner = owner;
        scoreboardFace = new Rectangle(new Point(0, 0),new Dimension(400,300));
        this.setPreferredSize(new Dimension(400,300));


        borderStoke = new BasicStroke(BORDER_SIZE, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, DASHES, 0);
        borderStoke_noDashes = new BasicStroke(BORDER_SIZE, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        repaint();
    }


    public void paint(Graphics g) {
        drawScoreboard((Graphics2D) g);
    }



    public void drawScoreboard(Graphics2D g2d) {
        g2d.setColor(new Color(180,240,180)); // background color
        Rectangle ScoreboardFace = new Rectangle(new Point(0, 0), new Dimension(600,450));
        g2d.fill(ScoreboardFace);
    }

    private void drawContainer(Graphics2D g2d) {
        g2d.setColor(new Color(255,255,255));
        Rectangle ScoreboardFace = new Rectangle(new Point(0,0));
        g2d.fill(ScoreboardFace);
//        Color prev = g2d.getColor();
//
//        g2d.setColor(BG_COLOR);
//        g2d.fill(scoreboardFace);
//
//        Stroke tmp = g2d.getStroke();
//
//        g2d.setStroke(borderStoke_noDashes);
//        g2d.setColor(DASH_BORDER_COLOR);
//        g2d.draw(scoreboardFace);
//
//        g2d.setStroke(borderStoke);
//        g2d.setColor(BORDER_COLOR);
//        g2d.draw(scoreboardFace);
//
//        g2d.setStroke(tmp);
//
//        g2d.setColor(prev);
    }

    private void drawText(Graphics2D g2d) {   // draw scoreboard
//
//        g2d.setColor(TEXT_COLOR);
//
//        FontRenderContext frc = g2d.getFontRenderContext();
//
//        Rectangle2D titleRect = TitleFont.getStringBounds("LEADERBOARD", frc);
//
//        int sX, sY;
//
//        sX = (int) (scoreboardFace.getWidth() - titleRect.getWidth()) / 2;
//        sY = (int) (scoreboardFace.getHeight() / 4);
//
//        g2d.setFont(TitleFont);
//        g2d.drawString("LEADERBOARD", sX, sY);

// draw here the table
    }


    private void initialize(){
        this.setPreferredSize(new Dimension(DEF_WIDTH,DEF_HEIGHT));
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        if(backButton.contains(p)){
            // owner.enableGameBoard();  // go back to homemenu
        }

    }


    public void mousePressed(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if (backButton.contains(p)) {
            startClicked = true;
            repaint(backButton.x, backButton.y, backButton.width + 1, backButton.height + 1);

        }

    }

    public void mouseReleased(MouseEvent mouseEvent) {
        if (startClicked) {
            startClicked = false;
            repaint(backButton.x, backButton.y, backButton.width + 1, backButton.height + 1);
        }

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }


    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        Point p = mouseEvent.getPoint();
        if(backButton.contains(p))
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        else
            this.setCursor(Cursor.getDefaultCursor());

    }


}
