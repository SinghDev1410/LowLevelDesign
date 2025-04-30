package WopiHostApplication.File.Structure_Dp.FlyWeight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeight {
    public static void main(String[] args) {
        IRobot humanRobot = RoboticFactory.createRobot("HUMANOID");
        humanRobot.display(1, 3);

        IRobot dogRobot = RoboticFactory.createRobot("ROBOTIDOG");
        dogRobot.display(4, 5);
    }
}

interface IRobot {
    void display(int x, int y);
}

class HumanRobot implements IRobot {

    private String type;
    private Sprites body;

    public String getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }

    public HumanRobot(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Displaying " + type + " at position (" + x + ", " + y + ")");
    }
}

class DogRobot implements IRobot {

    private String type;
    private Sprites body;

    public String getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }

    public DogRobot(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Displaying " + type + " at position (" + x + ", " + y + ")");
    }
}

class Sprites {
    // Placeholder class for robot body sprite details
    public void render() {
        // Render sprite logic
    }
}

class RoboticFactory {
    private static Map<String, IRobot> robotObjectCache = new HashMap<>();

    public static IRobot createRobot(String robotType) {
        if (robotObjectCache.containsKey(robotType)) {
            return robotObjectCache.get(robotType);
        } else {
            IRobot robot = null;

            if (robotType.equals("HUMANOID")) {
                Sprites humanoidSprites = new Sprites();
                robot = new HumanRobot(robotType, humanoidSprites);
            } else if (robotType.equals("ROBOTIDOG")) {
                Sprites roboticDogSprites = new Sprites();
                robot = new DogRobot(robotType, roboticDogSprites);
            }

            if (robot != null) {
                robotObjectCache.put(robotType, robot);
            }

            return robot;
        }
    }
}
