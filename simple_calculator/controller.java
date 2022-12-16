package simple_calculator;
import java.util.logging.*;
import java.io.IOException;

public class controller {
    public static void main(String[] args) throws IOException{
        Logger logger = Logger.getLogger(controller.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler consolLogger = new FileHandler("calculator_log.xml");
        logger.addHandler(consolLogger);
        XMLFormatter xml = new XMLFormatter();
        consolLogger.setFormatter(xml);

        String newInput = inputModule.inputExpression();    
        int conclusion = treatmentModule.processing(newInput);
        


        logger.info(createLog(newInput, conclusion));
        System.out.println(conclusion);
        }

    public static String createLog(String input, int conclusion) {
        StringBuilder log = new StringBuilder("Expression: ");
        log.append(input);
        log.append("=");
        log.append(conclusion);
        return log.toString();
    }
}

