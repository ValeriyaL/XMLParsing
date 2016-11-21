package by.liudchyk.xml.creator;

import by.liudchyk.xml.builder.AbstractCandyBuilder;
import by.liudchyk.xml.builder.CandyDOMBuilder;
import by.liudchyk.xml.builder.CandySAXBuilder;
import by.liudchyk.xml.builder.CandyStAXBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Admin on 21.11.2016.
 */
public class CandyBuilderFactory {
    private static final Logger LOG = LogManager.getLogger();

    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractCandyBuilder createStudentBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new CandyDOMBuilder();
            case STAX:
                return new CandyStAXBuilder();
            case SAX:
                return new CandySAXBuilder();
            default:
                LOG.warn("No such type of parser, will be used SAX");
        }
        return new CandySAXBuilder();
    }
}

