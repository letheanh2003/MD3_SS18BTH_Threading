package BTH2_Racing_Cars;

import java.util.Random;

import static BTH2_Racing_Cars.Main.DISTANCE;
import static BTH2_Racing_Cars.Main.STEP;

public class Car implements Runnable {
    //khai báo Tên của xe đua
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //khởi tạo điểm start (Hay km ban đàu)
        int runDistance = 0;
        //khởi tạo time bắt đàu cuộc đua
        long startTime = System.currentTimeMillis();

        //kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua thid vẫn tiếp tục chạy
        while (runDistance < DISTANCE) {
            try {
                //Random Speed Km/h
                int speed = (new Random().nextInt(20));
                // Calculate traveled distance
                runDistance += speed;
                // Build result graphic
                String log = "|";
                int percentTravel = (runDistance * 100) / DISTANCE;
                for (int i = 0; i < DISTANCE; i += STEP) {
                    if (percentTravel >= i + STEP) {
                        log += "";
                    } else if (percentTravel >= i && percentTravel < i + STEP) {
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
