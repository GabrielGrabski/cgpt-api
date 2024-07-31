package dev.grabski.cgpt_api.controller;

import dev.grabski.cgpt_api.dto.PromptRequest;
import dev.grabski.cgpt_api.dto.RecommendationResponse;
import dev.grabski.cgpt_api.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<RecommendationResponse> generate(@RequestParam String category, @RequestParam String gender) {
        return ResponseEntity.ok(service.generateResponse(new PromptRequest(category, gender)));
    }
}
