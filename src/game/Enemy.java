    package game;

    import city.cs.engine.*;

    import org.jbox2d.common.Vec2;


    public class Enemy extends Character {
        private static final Shape CharacterShape = new BoxShape(1,2.5f);
        private static final BodyImage image = new BodyImage("data/Gangsters_2/Idle(1).png", 5.5f);
        private int direction = 1;
        private int frameCounter = 0;
        private final float leftBound;
        private final float rightBound;
        private int lives = 1 ;

        public Enemy(World world, float leftBound, float rightBound) {
            super(world);
            this.leftBound = leftBound;
            this.rightBound = rightBound;
            removeAllImages();
            addImage(image);
            setFixedRotation(true);
            setAngle(0f);


        }


        public int getlives() {
            return lives;
        }

        public void loseLife(){
            lives--;
        }



        BodyImage[] walkFrames = new BodyImage[]{
                new BodyImage("data/Gangsters_2/Walk(1).png", 5.5f),
                new BodyImage("data/Gangsters_2/Walk(2).png", 5.5f),
                new BodyImage("data/Gangsters_2/Walk(3).png", 5.5f),
                new BodyImage("data/Gangsters_2/Walk(4).png", 5.5f),
                new BodyImage("data/Gangsters_2/Walk(5).png", 5.5f),
                new BodyImage("data/Gangsters_2/Walk(6).png", 5.5f),
                new BodyImage("data/Gangsters_2/Walk(7).png", 5.5f),
                new BodyImage("data/Gangsters_2/Walk(8).png", 5.5f),
                new BodyImage("data/Gangsters_2/Walk(9).png", 5.5f),
                new BodyImage("data/Gangsters_2/Walk(10).png", 5.5f),
        };
        BodyImage[] leftWalkFrames = new BodyImage[]{
                new BodyImage("data/Gangsters_2/LeftWalk(1).png", 5.5f),
                new BodyImage("data/Gangsters_2/LeftWalk(2).png", 5.5f),
                new BodyImage("data/Gangsters_2/LeftWalk(3).png", 5.5f),
                new BodyImage("data/Gangsters_2/LeftWalk(4).png", 5.5f),
                new BodyImage("data/Gangsters_2/LeftWalk(5).png", 5.5f),
                new BodyImage("data/Gangsters_2/LeftWalk(6).png", 5.5f),
                new BodyImage("data/Gangsters_2/LeftWalk(7).png", 5.5f),
                new BodyImage("data/Gangsters_2/LeftWalk(8).png", 5.5f),
                new BodyImage("data/Gangsters_2/LeftWalk(9).png", 5.5f),
                new BodyImage("data/Gangsters_2/LeftWalk(10).png", 5.5f),
        };
        private int animationTick = 0;

        public void update() {

            float x = getPosition().x;


            if (x > rightBound) direction = -1;
            if (x < leftBound) direction = 1;

            setLinearVelocity(new Vec2(3 * direction, 0));


            animationTick++;
            if (animationTick % 10 == 0) {
                animate();
            }
        }

        public void animate() {
            removeAllImages();
            if (direction == -1) {
                addImage(leftWalkFrames[frameCounter % leftWalkFrames.length]);
            } else {
                addImage(walkFrames[frameCounter % walkFrames.length]);
            }
            frameCounter = (frameCounter + 1) % walkFrames.length;
        }

        private void setFixedRotation(boolean b) {}

    }


