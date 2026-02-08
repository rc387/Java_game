package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import java.awt.event.KeyEvent;
import city.cs.engine.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
public class Character extends DynamicBody {
    private static final Shape CharacterShape = new BoxShape(1,2.5f);
    private static final BodyImage image = new BodyImage("data/Fighter/Idle(1).png", 5.5f);


    public Character(World world) {
        super(world, CharacterShape);
        addImage(image);
    }}

