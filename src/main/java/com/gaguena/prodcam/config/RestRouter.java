package com.gaguena.prodcam.config;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
class RestRouter extends RouteBuilder {

    @Override
    public void configure() {
        final CamelContext  context = new DefaultCamelContext();

        restConfiguration()
          .contextPath("/prodcam")
          .port(8080)
          //.enableCORS(true)
          .apiContextPath("/api")
          .apiProperty("api.title", "Test REST API")
          .apiProperty("api.version", "v1")
          .apiContextRouteId("route-api")
          .component("servlet")
          .bindingMode(RestBindingMode.json)
          .dataFormatProperty("prettyPrint", "true");

        rest("/products")
          .id("api-route-products")
          .consumes("application/json")
          .get("/")
            .bindingMode(RestBindingMode.json)
            .to("direct:get-products-service")
          .post("/")
            .to("direct:post-products-service");
    }
}