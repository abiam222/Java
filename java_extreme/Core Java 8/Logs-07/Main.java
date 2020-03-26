import java.util.*;
import java.util.logging.*;

public class Main {
    static Logger logger = 
    LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    public static void main(String[] args) {
        logger.setLevel(Level.FINE);
        logger.log(Level.INFO, "My first log message");
        logger.log(Level.SEVERE, "Another message");
    }
}