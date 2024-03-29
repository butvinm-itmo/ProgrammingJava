package desktop.pages.main.viz;

import java.util.Optional;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

public class HumanSprite {
    @Getter
    private long id;

    @Getter
    private float x;

    @Getter
    private float y;

    @Getter
    private final float radius;

    @Getter @Setter
    private double speed;

    @Getter
    private double angle;


    public HumanSprite(long id, float x, float y, float radius, double speed) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speed = speed;
        this.angle = new Random().nextDouble() * 2 * Math.PI;
    }

    public void move() {
        x += speed * Math.cos(angle);
        y += speed * Math.sin(angle);
    }

    public void bounceWalls(int width, int height) {
        if (x < radius) {
            x = radius;
            angle = Math.PI - angle;
        } else if (x > width - radius) {
            x = width - radius;
            angle = Math.PI - angle;
        }
        if (y < radius) {
            y = radius;
            angle = -angle;
        } else if (y > height - radius) {
            y = height - radius;
            angle = -angle;
        }
    }

    public void bounceSprite(HumanSprite other) {
        var collisionAngle = getCollisionAngel(other);
        if (collisionAngle.isPresent()) {
            angle = collisionAngle.get();
        }
    }

    public Optional<Double> getCollisionAngel(HumanSprite other) {
        float dx = x - other.x;
        float dy = y - other.y;
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        if (distance < radius + other.radius) {
            return Optional.of(Math.atan2(dy, dx));
        }
        return Optional.empty();
    }
}
