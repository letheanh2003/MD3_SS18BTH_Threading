package BTH3_XayDungUDDemSo;

public class Count implements Runnable {
    private final Thread myThread;

    public Count() {
        myThread = new Thread(this,"chủ đề có thể chạy được của tôi");
        System.out.println("chủ đề của tôi được tạo" + myThread);
        myThread.start();
    }


    public Thread getMyThread() {
        return myThread;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("In số lượng " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("chủ đề của tôi bị gián đoạn");
        }
        System.out.println("chủ đề của tôi chạy đã kết thúc");
    }
}