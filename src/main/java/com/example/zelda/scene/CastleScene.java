package com.example.zelda.scene;


import com.example.zelda.enemy.BlueSoldier;
import com.example.zelda.enemy.WhiteSoldier;
import com.example.zelda.engine.Game;
import com.example.zelda.items.Guard;
import com.example.zelda.items.Heart;
import com.example.zelda.items.Rupee;
import com.example.zelda.karacter.Direction;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Collections;
import java.util.List;

import static com.example.zelda.scene.util.CoordinateConstantsCastleScene.*;

/**
 *
 * @author Christiaan
 */
public class CastleScene extends ZeldaScene {

    private final Rectangle exitUp	= new Rectangle(EXIT_UP_X, EXIT_UP_Y, 27, 20);
    private final Rectangle exitDown  = new Rectangle(EXIT_DOWN_X, EXIT_DOWN_Y, 27, 20);

    public CastleScene(Game game, String entrance) {
        super(game, "/static/images/castle.png", "CastleScene");

        exits.addAll(List.of(exitUp, exitDown));

        int[] centralUpperWallX = CENTRALUPPERWALL_X;
        int[] centralUpperWallY = CENTRALUPPERWALL_Y;

        var centralUpperWall = new Polygon(centralUpperWallX, centralUpperWallY, centralUpperWallY.length);

        int[] partOfWall1X = PARTOFWALL1_X;
        int[] partOfWall1Y = PARTOFWALL1_Y;

        var partOfWall1 = new Polygon(partOfWall1X, partOfWall1Y, partOfWall1Y.length);

        int[] partOfWall2X = PARTOFWALL2_X;
        int[] partOfWall2Y = PARTOFWALL2_Y;

        var partOfWall2 = new Polygon(partOfWall2X, partOfWall2Y, partOfWall2Y.length);

        int[] partOfWall3X = PARTOFWALL3_X;
        int[] partOfWall3Y = PARTOFWALL3_Y;

        var partOfWall3 = new Polygon(partOfWall3X, partOfWall3Y, partOfWall3Y.length);

        var bottomRight = getPolygon();

        int[] rightX = RIGHT_X;
        int[] rightY = RIGHT_Y;

        var right = new Polygon(rightX, rightY, rightY.length);

        int[] rightCenterX = RIGHTCENTER_X;
        int[] rightCenterY = RIGHTCENTER_Y;

        var rightCenter = new Polygon(rightCenterX, rightCenterY, rightCenterY.length);

        int[] bottomLeftX = BOTTOMLEFT_X;
        int[] bottomLeftY = BOTTOMLEFT_Y;

        var bottomLeft = new Polygon(bottomLeftX, bottomLeftY, bottomLeftY.length);

        int[] leftX = LEFT_X;
        int[] leftY = LEFT_Y;

        var left = new Polygon(leftX, leftY, leftY.length);

        int[] column1X = COLUMN1_X;
        int[] column1Y = COLUMN1_Y;

        var column1 = new Polygon(column1X, column1Y, column1Y.length);

        int[] column2X = COLUMN2_X;
        int[] column2Y = COLUMN2_Y;

        var column2 = new Polygon(column2X, column2Y, column2Y.length);

        int[] column3X = COLUMN3_X;
        int[] column3Y = COLUMN3_Y;

        var column3 = new Polygon(column3X, column3Y, column3Y.length);

        int[] column4X = COLUMN4_X;
        int[] column4Y = COLUMN4_Y;

        var column4 = new Polygon(column4X, column4Y, column4Y.length);

        int[] column5X = COLUMN5_X;
        int[] column5Y = COLUMN5_Y;

        var column5 = new Polygon(column5X, column5Y, column5Y.length);

        int[] column6X = COLUMN6_X;
        int[] column6Y = COLUMN6_Y;

        var column6 = new Polygon(column6X, column6Y, column6Y.length);

        int[] column7X = COLUMN7_X;
        int[] column7Y = COLUMN7_Y;

        var column7 = new Polygon(column7X, column7Y, column7Y.length);

        int[] column8X = COLUMN8_X;
        int[] column8Y = COLUMN8_Y;

        var column8 = new Polygon(column8X, column8Y, column8Y.length);

        int[] middle1X = MIDDLE1_X;
        int[] middle1Y = MIDDLE1_Y;

        var middle1 = new Polygon(middle1X, middle1Y, middle1Y.length);

        int[] middle2X = MIDDLE2_X;
        int[] middle2Y = MIDDLE2_Y;

        var middle2 = new Polygon(middle2X, middle2Y, middle2Y.length);

        int[] pot1X = POT1_X;
        int[] pot1Y = POT1_Y;

        var pot1 = new Polygon(pot1X, pot1Y, pot1Y.length);

        int[] thing1X = THING1_X;
        int[] thing1Y = THING1_Y;

        var thing1 = new Polygon(thing1X, thing1Y, thing1Y.length);

        int[] pot2X = POT2_X;
        int[] pot2Y =  POT2_Y;

        var pot2 = new Polygon(pot2X, pot2Y, pot2Y.length);

        int[] thing2X = THING2_X;
        int[] thing2Y = THING2_Y;

        var thing2 = new Polygon(thing2X, thing2Y, thing2Y.length);

        int[] thing3X = THING3_X;
        int[] thing3Y = THING3_Y;

        var thing3 = new Polygon(thing3X, thing3Y, thing3Y.length);

        int[] thing4X = THING4_X;
        int[] thing4Y = THING4_Y;

        var thing4 = new Polygon(thing4X, thing4Y, thing4Y.length);

        solids.addAll(List.of(centralUpperWall, partOfWall1, partOfWall2, partOfWall3, bottomRight, right, rightCenter,
                              bottomLeft, left, column2, column3, column4, column5, column6, column7, column8, column1, middle1,
                              middle2, pot1, thing1, pot2, thing2, thing3, thing4));


        Collections.addAll(
                gameObjects,
                new Rupee(game, 131, 96),
                new Rupee(game, 148, 96),
                new Rupee(game, 196, 577),
                new Rupee(game, 1092, 857),
                new Rupee(game, 1036, 425),
                new Heart(game, 812, 57),
                new Heart(game, 52, 577),
                game.getLink(),
                new Guard(game, 118, 971, Direction.UP),
                new Guard(game, 885, 968, Direction.UP),
                new Guard(game, 504, 564, Direction.DOWN),
                new BlueSoldier(game, 331, 762, Direction.RIGHT, 50),
                new BlueSoldier(game, 689, 762, Direction.LEFT, 50),
                new WhiteSoldier(game, 1038, 681, Direction.LEFT),
                new BlueSoldier(game, 883, 144, Direction.UP, 200),
                new BlueSoldier(game, 116, 144, Direction.UP, 200)
        );

        if (!game.getSong().equals("/static/sounds/castle.mp3")) {
            game.stopMusic();
            game.playMusic("/static/sounds/castle.mp3", true);
        }

        handleSwitchScene(entrance);
    }

    private static Polygon getPolygon() {
        int[] bottomRightX = BOTTOMRIGHT_X;
        int[] bottomRightY = BOTTOMRIGHT_Y;

        return new Polygon(bottomRightX, bottomRightY, bottomRightY.length);
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {
		if (exit == exitUp) {
			game.setScene(new CastleBasementScene(game, "CastleScene"));
        }
        if (exit == exitDown) {
			game.setScene(new HyruleScene(game, "CastleScene"));
        }
    }

    @Override
    public void handleSwitchScene(String entrance) {
        if (entrance.equals("HyruleScene")) {
            moveScene(252, 607);
            game.getLink().setXHardCore(250);
            game.getLink().setYHardCore(326);
        }
        if (entrance.equals("CastleBasementScene")) {
			moveScene(254, 1);
			game.getLink().setXHardCore(250);
            game.getLink().setYHardCore(119);
        }
    }
}
