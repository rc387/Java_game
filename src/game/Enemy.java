package game;
import city.cs.engine.*;

public abstract class Enemy extends DynamicBody implements CollisionListener {
    private static final Shape CharacterShape = new BoxShape(1f, 2.5f);
    private static final BodyImage image = new BodyImage("data/Gangsters_2/Idle(1).png", 5.5f);
    protected float leftBound;
    protected float rightBound;
    protected int lives;

    public Enemy(World world, float leftBound, float rightBound, int lives) {
        super(world,CharacterShape );
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.lives = lives;
        addCollisionListener(this);
        removeAllImages();
        addImage(image);
        setFixedRotation();
        setAngle(0f);
    }

    public void lose_Life(){
        lives--;
        if(lives <= 0){
            lose_enemy();
            destroy();

        }
    }

    protected void lose_enemy(){}

    @Override
        public void collide(CollisionEvent e) {
            if (e.getOtherBody() instanceof Enemy_attack enemy) {
                lose_Life();
                enemy.destroyed();
            } else if (e.getOtherBody() instanceof Character_attack character) {
                lose_Life();
                character.destroyed();
            }
    }

    private void setFixedRotation() {}
}
