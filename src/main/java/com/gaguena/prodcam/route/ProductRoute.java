package com.gaguena.prodcam.route;

import com.gaguena.prodcam.data.ProductData;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ProductRoute extends RouteBuilder {
    public void configure() {
        from("direct:get-products-service")
          .routeId("get-products-service")
          .removeHeaders("CamelHttp*")
          .setHeader(Exchange.HTTP_METHOD, constant("GET"))
          .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
           .setBody(constant("Username: ABC, Password: ABC, Country: UK"))
          .to("http://localhost:3000/products")
          .unmarshal(new ListJacksonDataFormat(ProductData.class))
          .process(exchange -> System.out.println("*******________________________________"))
          .process(exchange -> log.info("HTTP GET response is: {}", exchange.getIn().getBody(String.class)))
          .end();

        from("direct:post-products-service")
          .routeId("post-products-service")
          .removeHeaders("CamelHttp*")
          .setHeader(Exchange.HTTP_METHOD, constant("POST"))
          .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
          .marshal(new ListJacksonDataFormat(ProductData.class))
          .to("http://localhost:3000/products")
          .process(exchange -> System.out.println("*******________________________________"))
          .process(exchange -> log.info("HTTP GET response is: {}", exchange.getIn().getBody(String.class)))
          .end();
    }
}
