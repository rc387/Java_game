package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Character extends DynamicBody {
    private static final Shape CharacterShape = new BoxShape(1,2);

    private static final BodyImage image =
            new BodyImage("data/student.png", 4);




    public Character(World world) {
        super(world, CharacterShape);

        addImage(image);


    }


}
