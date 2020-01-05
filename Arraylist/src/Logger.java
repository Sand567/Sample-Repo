/**
 * Created by Sharath Nagendra on 7/28/2017.
 */
public class Logger implements  Runnable {
    private StringBuilder contents = new StringBuilder();

    public void log(String message) {
        contents.append(System.currentTimeMillis());
        contents.append(": ");
        contents.append(Thread.currentThread().getName());
        contents.append(message);
        contents.append("\n");
        System.out.println(contents.toString());
    }

    public String getContents() {
        return contents.toString();
    }

    public static void main(String[] args) {

        Logger logger = new Logger();
        logger.log("This is a test message");
        //logger.getContents();



    }


    @Override
    public void run() {

    }
}

