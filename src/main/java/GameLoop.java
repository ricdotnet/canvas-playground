import Util.*;

public class GameLoop {

    Util util = new Util();
    Window window;

    private Boolean RUNNING = true;

    private final double TARGET_FPS = 60.0;
    private final double OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    private long actualTime = util.nsNow();
    private long timer = util.msNow(); //ms value for 1 second interval count
    private double delta = 0;
    private int ticks = 0;
    private int fps = 0;

    public GameLoop(Window window) {
        this.window = window;
    }

    public void loop() {

//        System.out.println(actualTime);

        while (RUNNING) {
            long timeNow = util.nsNow();
            delta += (timeNow - actualTime) / OPTIMAL_TIME;
            actualTime = timeNow;

            while (delta >= 1) {
                window.tick();
                ticks++;
                delta--;
            }

            window.render();
            fps++;

            if(util.msNow() - timer > 1000) {
                System.out.println("FPS: " + fps + ", Ticks: " + ticks);
                fps = 0;
                ticks = 0;
                timer = util.msNow();
            }
        }
    }

}
