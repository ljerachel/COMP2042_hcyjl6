package test;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Created by filippo on 04/09/16.
 *
 */
abstract public class Brick  {

    public static final int MIN_CRACK = 1;
    public static final int DEF_CRACK_DEPTH = 1;
    public static final int DEF_STEPS = 35;


    public static final int UP_IMPACT = 100;
    public static final int DOWN_IMPACT = 200;
    public static final int LEFT_IMPACT = 300;
    public static final int RIGHT_IMPACT = 400;




    private static Random rnd;


    private String name;
    Shape brickFace;

    private Color border;
    private Color inner;

    private int fullStrength;
    private int strength;

    private boolean broken;


    /**
     * @param name type of brick
     * @param pos position of brick
     * @param size size of brick
     * @param border border colour of brick
     * @param inner the inner brick colour
     * @param strength how hard it is to break the brick
     */
    public Brick(String name, Point pos,Dimension size,Color border,Color inner,int strength){
        rnd = new Random();
        broken = false;   //the brick broken or not
        this.name = name;
        brickFace = makeBrickFace(pos,size);
        this.border = border;
        this.inner = inner;
        this.fullStrength = this.strength = strength;

    }

    public static Random getRnd() {
        return rnd;
    }

    /**
     * @param pos position of the brick
     * @param size size of the brick
     * @return
     */
    protected abstract Shape makeBrickFace(Point pos,Dimension size);

    /**
     * @param point point of impact on the ball
     * @param dir direction of the impact!!!!!
     * @return false if broken ,true if not broken and has impact
     */
    public  boolean setImpact(Point2D point , int dir){
        if(broken)    // true
            return false;
        impact();
        return  broken;
    }

    public abstract Shape getBrick();



    public Color getBorderColor(){
        return  border;
    }

    public Color getInnerColor(){
        return inner;
    }


    /**
     * @param b the ball
     * @return the side of impact on the brick
     */
    public final int findImpact(Ball b){
        if(broken)
            return 0;
        int out  = 0;
        if(brickFace.contains(b.right))
            out = LEFT_IMPACT;
        else if(brickFace.contains(b.left))
            out = RIGHT_IMPACT;
        else if(brickFace.contains(b.up))
            out = DOWN_IMPACT;
        else if(brickFace.contains(b.down))
            out = UP_IMPACT;

        return out;
    }

    /**
     * @return true if broken false if not broken
     */
    public final boolean isBroken()
    {
        return broken;
    }

    /**
     * reset the strength of bricks
     */
    public void repair() {
        broken = false;
        strength = fullStrength;
    }

    /**
     * the strength of the brick decreases when hit on impact , broken when strength = 0
     */
    public void impact(){
        strength--;
        broken = (strength == 0); // broken = true (when broken)
    }


}





