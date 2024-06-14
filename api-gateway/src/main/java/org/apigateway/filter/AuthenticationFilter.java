package org.apigateway.filter;

import jakarta.ws.rs.core.HttpHeaders;
import org.apigateway.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;

    @Autowired
    private RestTemplate template;

    @Autowired
    private JwtUtils jwtUtils;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (validator.isSecure.test(exchange.getRequest())) {
                //Header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {//interface-jakarta
                    throw new RuntimeException("Missing authentication header");
                }
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    //need to remove 7 spaces which we get from postman "Bearer "
                    authHeader = authHeader.substring(7); //contains actual token
                }
                try {
                    //Rest call to Auth-service "/validate"
                    //template.getForEntity("http://AUTHENTICATION-SERVICE//auth/validate?token" + authHeader, String.class); //from security point of view this way can break application by hackers
                    //OR instead of rest call we can call jwtUtils - decryption secret
                    jwtUtils.validateToken(authHeader);
                } catch (Exception e) {
                    throw new RuntimeException("Unauthorized access : /validate call");
                }
            }
            return chain.filter(exchange);
        });

    }

    public static class Config {

    }
}
