package by.liudchyk.xml.runner;

import by.liudchyk.xml.builder.AbstractCandyBuilder;
import by.liudchyk.xml.creator.CandyBuilderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Admin on 20.11.2016.
 */
public class Parser {
    private static final Logger LOG = LogManager.getLogger();
    private static final String INPUT_XML = "data/candies.xml";
    private static final String PARSER = "stax";

    public static void main(String[] args) {
        CandyBuilderFactory sFactory = new CandyBuilderFactory();
        AbstractCandyBuilder builder = sFactory.createStudentBuilder(PARSER);
        builder.buildSetCandies(INPUT_XML);
        LOG.info(PARSER + " parser: " + builder.getCandySet());
    }
}
