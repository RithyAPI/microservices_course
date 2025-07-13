package com.ut.utAttendance.controller;

import com.ut.utAttendance.base.UserAuthSession;
import com.ut.utAttendance.helper.GeneratePasswordPDF;
import com.ut.utAttendance.helper.ResponseMessageUtils;
import com.ut.utAttendance.mapper.primary.AuthMapper;
import com.ut.utAttendance.model.MessageService;
import com.ut.utAttendance.model.base.OauthToken;
import com.ut.utAttendance.model.base.ResponseMessage;
import com.ut.utAttendance.model.request.LoginRequest;
import com.ut.utAttendance.model.response.CaptchaResponse;
import com.ut.utAttendance.service.AuthService;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/auth")
@Api(tags = "01. Auth", description = "Auth Resource")
@Timed
public class AuthController {

    @Autowired
    Environment environment;

    @Autowired
    private AuthMapper authMapper;

    @Autowired
    private AuthService authService;

    @Autowired
    private MessageService messageService;


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

  @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "login", notes = "statusCode: 400: Bad Request (Invalid Parameter); 401: Unauthorized (Token Expired or Invalid); 200: Success")
    public ResponseMessage<OauthToken> login(@RequestBody LoginRequest loginRequest, HttpServletRequest httpServletRequest) throws IOException {

      String deviceIds = GeneratePasswordPDF.generatePasswordPDF(httpServletRequest);

      String username = loginRequest.getUsername();
      String password = loginRequest.getPassword();
      String deviceId = deviceIds;
      String deviceName = loginRequest.getDeviceName();

      if(authMapper.checkUserValid(username) == 0 ){
          return ResponseMessageUtils.makeResponse(true, messageService.message("User doesn't exist!", false));
      }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String clientSecret = "#UTATT092312MT";
        //int tokenValidate   = 10;
        int tokenValidate = 60 * 60 * 24 * 30; // 30 Days
        int refreshTokenValidate = 60 * 60 * 24 * 90; // 90 Days
        // Check User
        if (!username.isEmpty() && !password.isEmpty() && !deviceName.isEmpty() && !deviceId.isEmpty()) {
            Long checkUser = authMapper.checkUserValid(username);
            if (checkUser > 0) {
                // Check Device Insert
                if (authMapper.insertClientId(deviceId, deviceName, clientSecret, tokenValidate, refreshTokenValidate)) {
                    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
                    map.add("grant_type", "password");
                    map.add("client_id", deviceId);
                    map.add("client_secret", clientSecret);
                    map.add("username", username);
                    map.add("password", password);
                    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
                    String authUrl = environment.getProperty("api.authUrl");
                    System.out.println("Login");
                    return authService.responseToken(authMapper.checkStatusUserLogin(username), authUrl, restTemplate, request,httpServletRequest);
                } else {
                    return ResponseMessageUtils.makeResponse(false, 400, "Bad Request", "Invalid Parameter");
                }
            } else {
                return ResponseMessageUtils.makeResponse(false, 401, "401", "Invalid username or password");
            }
        } else {
            return ResponseMessageUtils.makeResponse(false, 400, "Bad Request", "Invalid Parameter");
        }
    }

    @PostMapping("/login-with-refresh-token")
    @ApiOperation(value = "Login with refresh token", notes = "statusCode: 400: Bad Request (Invalid Parameter); 401: Unauthorized (Token Expired or Invalid); 200: Success")
    public ResponseMessage<OauthToken> loginWithRefreshToken(@RequestParam("refreshToken") String refreshToken, @RequestParam("deviceId") String deviceId, HttpServletRequest httpServletRequest) throws UnknownHostException {
        if (!refreshToken.isEmpty() && !deviceId.isEmpty()) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("grant_type", "refresh_token");
            map.add("client_id", deviceId);
            map.add("client_secret", "#UTATT092312MT");
            map.add("refresh_token", refreshToken);
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
            String authUrl = environment.getProperty("api.authUrl");
            return authService.responseToken( 2L,authUrl, restTemplate, request, httpServletRequest);
        } else {
            return ResponseMessageUtils.makeResponse(false, 400, "Bad Request", "Invalid Parameter");
        }
    }

    @PostMapping("/logout")
    @ApiOperation(value = "Logout", notes = "statusCode: 400: Bad Request (Invalid Parameter); 401: Unauthorized (Token Expired or Invalid); 200: Success", authorizations = {@Authorization(value = "Bearer")})
    public ResponseMessage<String> loginWithRefreshToken(@RequestParam("deviceId") String deviceId) {
        if (UserAuthSession.getUserAuth() != null && deviceId != null && !deviceId.isEmpty()) {
            String tokenId = authMapper.checkUserLogout(UserAuthSession.getUserAuth().getUsername(), deviceId);
            if (tokenId != null && !tokenId.isEmpty()) {
                authMapper.clearUserToken(UserAuthSession.getUserAuth().getUsername(), deviceId, tokenId);
            }
            return ResponseMessageUtils.makeResponse(true, "Success");
        } else {
            return ResponseMessageUtils.makeResponse(false, 400, "Bad Request", "Invalid Parameter");
        }
    }

    @PostMapping("/checkToken")
    @ApiOperation(value = "Check Token", notes = "401: Unauthorized (Token Expired or Invalid); 200: Success", authorizations = {@Authorization(value = "Bearer")})
    public ResponseMessage<String> checkToken() {

        if (UserAuthSession.getUserAuth() != null) {
            return ResponseMessageUtils.makeResponse(true, "Token Valid");
        } else {
            return ResponseMessageUtils.makeResponse(false, 401, "unauthorized", "No Permission to access");
        }
    }
}