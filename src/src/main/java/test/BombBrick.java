/*
package test;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;
public class BombBrick extends Brick {

        private static final String NAME = "Bomb Brick";
        private static final Color DEF_INNER = new Color(0, 200, 34).darker();
        private static final Color DEF_BORDER = Color.GRAY;
        private static final int CLAY_STRENGTH = 1;


        public boolean gameover = false ;
        private static final double BOMB_PROBABILITY = 0.4;

        private Random rnd;
        private Shape brickFace;

        */
/**
         * @param point position of the steel brick
         * @param size size of the brick
         *//*

        public BombBrick(Point point, Dimension size){
            super(NAME,point,size,DEF_BORDER,DEF_INNER,CLAY_STRENGTH);
            rnd = new Random();
            brickFace = super.brickFace;
        }


        @Override
        protected Shape makeBrickFace(Point pos, Dimension size) {
            return new Rectangle(pos,size);
        }

        @Override
        public Shape getBrick() {
            return brickFace;
        }

        */
/**
         * @param point point of impact on the ball
         * @param dir direction of the impact!!!!!
         * @return check if the brick is broken
         *//*


        public  boolean setImpact(Point2D point , int dir){
            if(super.isBroken())
                return false;
            impact();
            return  super.isBroken();
        }

        */
/**
         * if the random double generated is lower than 0.4, impact between ball and brick will occur
         *//*

        public void impact(){
            super.impact();
            gameover = true ; //  go to game over
            }

       }
*/




