package com.baeldung.keycloak;

import java.security.Principal;
import java.util.Map;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;

@Controller
public class CustomUserAttrController {

    @GetMapping(path = "/userinfo")
    public String getUserInfo(Model model) {
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        String dob = readAttrFromPrincipal(principal, "DOB");
        model.addAttribute("username", principal.getName());
        model.addAttribute("dob", dob);
        return "userInfo";
    }

    private String readAttrFromPrincipal(Principal principal, String attr) {
        String value = "";
        if (principal instanceof KeycloakPrincipal) {
            KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
            IDToken token = kPrincipal.getKeycloakSecurityContext().getIdToken();
            Map<String, Object> customClaims = token.getOtherClaims();
            if (customClaims.containsKey(attr)) {
                value = String.valueOf(customClaims.get(attr));
            }
        }
        return value;
    }

    @GetMapping(path = "/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping(path = "/staff")
    @RolesAllowed("staff")
    public String getStaffPage(Model model) {
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        String position = readAttrFromPrincipal(principal, "POSITION");
        model.addAttribute("username", principal.getName());
        model.addAttribute("position", position);
        return "staff";
    }


}
