package com.apex.engine.animation;

import com.apex.engine.ecs.Component;
import java.util.HashMap;
import java.util.Map;

public class Animator extends Component {
    private Map<String, Animation> animations;
    private Animation currentAnimation;
    private String currentAnimationName;

    public Animator() {
        this.animations = new HashMap<>();
    }

    @Override
    public void update(float deltaTime) {
        if (currentAnimation != null) {
            currentAnimation.update(deltaTime);
        }
    }

    @Override
    public void render() {}

    public void addAnimation(Animation animation) {
        animations.put(animation.name, animation);
    }

    public void playAnimation(String name) {
        Animation animation = animations.get(name);
        if (animation != null) {
            if (currentAnimation != null) {
                currentAnimation.stop();
            }
            currentAnimation = animation;
            currentAnimationName = name;
            animation.play();
        }
    }

    public void stopAnimation() {
        if (currentAnimation != null) {
            currentAnimation.stop();
        }
    }

    public Animation getCurrentAnimation() {
        return currentAnimation;
    }

    public String getCurrentAnimationName() {
        return currentAnimationName;
    }
}
