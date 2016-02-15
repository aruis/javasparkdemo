/**
 * Created by liurui on 16/2/13.
 */
import static spark.Spark.*;

public class Test {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
