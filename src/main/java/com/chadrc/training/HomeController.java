package com.chadrc.training;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class HomeController {

    @GetMapping("status")
    public ResponseEntity<StatusResponse> root() {
        return ResponseEntity.ok(new StatusResponse("OK"));
    }

    @GetMapping("param")
    public ResponseEntity<StatusResponse> param(@RequestParam("data") String data) {
        return ResponseEntity.ok(new StatusResponse(data));
    }
}
