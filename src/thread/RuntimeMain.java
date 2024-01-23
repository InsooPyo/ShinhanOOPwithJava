package thread;

import java.io.IOException;

public class RuntimeMain {
    public static void main(String... args) throws IOException {
        var runtime = Runtime.getRuntime();
        runtime.exec("open https://daum.net/"); //Mac
        //runtime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe https://daum.net/"); //Window
        System.out.printf("End of %s ",Thread.currentThread().getName());
    }
}
