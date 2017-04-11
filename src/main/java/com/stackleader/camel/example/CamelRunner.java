package com.stackleader.camel.example;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

/**
 *
 * @author dcnorris
 */
@ApplicationScoped
@Startup
@ContextName("mycamelContext")
public class CamelRunner extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer://foo?period=5000")
                .setBody()
                .simple("Camel")
                .log("Hello ${body}");
    }

}
