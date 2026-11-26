package com.luisedev.cuentadia.controllers;

import com.luisedev.cuentadia.dto.requets.TagsRequest;
import com.luisedev.cuentadia.dto.response.TagsResponse;
import com.luisedev.cuentadia.services.tags.ITagsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    private final ITagsService tagsService;


    public TagController(ITagsService tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping
    public ResponseEntity<List<TagsResponse>> listResponseEntity () {
        return ResponseEntity.ok(tagsService.tagsResponseList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TagsResponse> getTagsResponseById (@PathVariable Long id) {
        return ResponseEntity.ok(tagsService.tagsById(id));
    }

    @PostMapping
    public ResponseEntity<TagsResponse> saveTags (@RequestBody TagsRequest tagsRequest) {
        return ResponseEntity.ok(tagsService.tagsSave(tagsRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletedTags (@PathVariable Long id) {
        return ResponseEntity.ok(tagsService.deletedById(id));
    }
}
