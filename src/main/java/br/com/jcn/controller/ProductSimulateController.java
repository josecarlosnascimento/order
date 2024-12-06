package br.com.jcn.controller;

import br.com.jcn.service.ProductASimulateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("populate")
public class ProductSimulateController {

    @Autowired
    private ProductASimulateService productASimulateService;

    @PostMapping
    public ResponseEntity<Void> findById() throws JsonProcessingException {
        productASimulateService.send();
        return ResponseEntity.ok().build();
    }
}
