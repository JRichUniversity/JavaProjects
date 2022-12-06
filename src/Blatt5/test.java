package Blatt5;
import java.util.Random;
import javax.vecmath.Tuple2d;

import java.util.Vector;

public class test {
    static Vector2D[] randomPoints(){
        Random random = new Random()
        int pointCount = random.nextInt(10, 20); //we'll have a total of 10 to 20 points
        Vector2[] points = new Vector2[pointCount * 2];
        for(int i = 0; i < pointCount; ++i)
        {
            float x = Random(0.0f, 250.0f) - 125f;  // we subtract 125 to keep the square centralized
            float y = Random(0.0f, 250.0f) - 125f;
            points[i] = new Vector2(x, y);
        }
    }
}
