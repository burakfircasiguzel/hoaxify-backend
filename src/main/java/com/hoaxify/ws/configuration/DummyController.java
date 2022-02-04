/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoaxify.ws.configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ELOCK2
 */
@RestController
public class DummyController {

    @GetMapping("/secured")
    String securedPath() {
        return "Secured place";
    }
}
