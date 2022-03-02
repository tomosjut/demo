package nl.svb.icc.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("MyProcessor")
public class MyProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        String input = exchange.getIn().getBody(String.class);

        int length = input.length();
        char firstChar = input.charAt(0);
        char lastChar = input.charAt(length - 1);

        String output = "Input has length " + length + ", starts with " + firstChar + ", ends with " + lastChar;

        exchange.getIn().setBody(output);
    }
}
