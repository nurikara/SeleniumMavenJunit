package day22_Log4JNT;
import day22_Log4J.C01_Log4J;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class C01_Log4j {
    @Test
    public void test01() {
        Logger logger = LogManager.getLogger(C01_Log4J.class.getName());
        logger.debug("Debug logger");
        logger.info("Info logger");
        logger.error("Error logger");
        logger.fatal("Fatal logger");
    }
}
