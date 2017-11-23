package gestionTerritorial.config;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerOauth2Config extends GlobalMethodSecurityConfiguration {

  private static String OAUTH2_SERVER_CHECK = "http://des-yauth.yachay.gob.ec:8080/oauth/check_token";
  private static String OAUTH2_SERVER_TOKEN = "http://des-yauth.yachay.gob.ec:8080/oauth/token";
  private static String OAUTH2_RESOURCE_ID = "YEP_CLIENTE_BASE";
  private static String OAUTH2_CLIENT = "cliente_base";
  private static String OAUTH2_CLIENT_SECRET = "secret_cliente_base";
  private static String OAUTH2_REDIRECT_SERVER = "http://localhost:8080/oauth/autentication";
  private static String OAUTH2_REDIRECT_CLIENT = "http://localhost:4200/#/auth/login";
  private static String OAUTH2_REDIRECT_ERROR = "http://localhost:4200/#/auth/error";

  private static String encodeBasicAuth(String username, String pass) {
    String authString = username + ":" + pass;
    byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
    String authStringEnc = new String(authEncBytes);
    System.out.println("Base64 encoded auth string: " + authStringEnc);
    return authStringEnc;
  }

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    return new OAuth2MethodSecurityExpressionHandler();
  }

  @Primary
  @Bean
  public RemoteTokenServices tokenService() {
    System.out.println("REVISIÓN DE TOKEN EN: " + OAUTH2_SERVER_CHECK);
    RemoteTokenServices tokenService = new RemoteTokenServices();
    tokenService.setCheckTokenEndpointUrl(OAUTH2_SERVER_CHECK);
    tokenService.setClientId(OAUTH2_CLIENT);
    tokenService.setClientSecret(OAUTH2_CLIENT_SECRET);
    return tokenService;
  }

  @Configuration
  protected static class ResourceServer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
      System.out.println("APLICACIÓN LEVANTADA CON IDENTIFCADOR DE RECURSO: " + OAUTH2_RESOURCE_ID);
      resources.resourceId(OAUTH2_RESOURCE_ID);
    }

    // Permitir OPTIONS para CORS de todas las peticions cambiar en caso de
    // peticiones OPTIONS.
    @Override
    public void configure(HttpSecurity http) throws Exception {

      http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
    }

  }

  @RestController
  @CrossOrigin
  @RequestMapping(value = "oauth/autentication")
  protected static class OauthManager {

    @RequestMapping(method = RequestMethod.GET)
    public void autenticate(@RequestParam("code") String code, HttpServletResponse http) {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
      headers.add("Authorization", "Basic " + ResourceServerOauth2Config
          .encodeBasicAuth(ResourceServerOauth2Config.OAUTH2_CLIENT, ResourceServerOauth2Config.OAUTH2_CLIENT_SECRET));
      MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
      map.add("grant_type", "authorization_code");
      map.add("code", code);
      map.add("redirect_uri", ResourceServerOauth2Config.OAUTH2_REDIRECT_SERVER);


      HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
      RestTemplate client = new RestTemplate();
      ResponseEntity<ObjectNode> response = client.postForEntity(OAUTH2_SERVER_TOKEN, request, ObjectNode.class);
      System.out.println(response.getBody());
      try {
        //TODO: ERROR REDIRECT 
        if(response.getBody().get("error") != null){
          http.sendRedirect(ResourceServerOauth2Config.OAUTH2_REDIRECT_ERROR + "?error="
              + response.getBody().get("error").asText());
        }else if(response.getBody().get("scope") != null){
          http.sendRedirect(ResourceServerOauth2Config.OAUTH2_REDIRECT_CLIENT + "/"
              + response.getBody().get("access_token").asText() + "/" + response.getBody().get("refresh_token").asText()
              + "/" + response.getBody().get("expires_in").asText() + "/"
              + response.getBody().get("scope").asText().replaceAll(" ", ","));
        }else{
          http.sendRedirect(ResourceServerOauth2Config.OAUTH2_REDIRECT_ERROR 
              + "?error=Actualmente%20no%20tienes%20ningun%20permiso%20para%20acceder%20a%20esta%20apliaci%C3%B3n");
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      // return response.getBody();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ObjectNode refreshAutentication(@RequestBody HashMap<String, String> data) {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
      headers.add("Authorization", "Basic " + ResourceServerOauth2Config
          .encodeBasicAuth(ResourceServerOauth2Config.OAUTH2_CLIENT, ResourceServerOauth2Config.OAUTH2_CLIENT_SECRET));
      MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
      map.add("grant_type", "refresh_token");
      map.add("refresh_token", data.get("uuid_refresh_session"));

      
      HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
      RestTemplate client = new RestTemplate();
      ResponseEntity<ObjectNode> response = client.postForEntity(OAUTH2_SERVER_TOKEN, request, ObjectNode.class);
      
      return response.getBody();
    }

  }
  // {"access_token":"650f880b-e6d5-47db-bb57-08ed2d7e77c6","token_type":"bearer","refresh_token":"1618f5e8-8d05-4786-a798-193194a8f4d3","expires_in":43199,"scope":"ALL
  // Per"}

}
