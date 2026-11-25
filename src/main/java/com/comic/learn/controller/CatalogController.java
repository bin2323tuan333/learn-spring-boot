package com.comic.learn.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comic.learn.dto.request.ComicRequest;
import com.comic.learn.dto.response.ApiResponse;
import com.comic.learn.dto.response.ComicResponse;
import com.comic.learn.service.CatalogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/comics")
@RequiredArgsConstructor
public class CatalogController {
  private final CatalogService catalogService;

  @GetMapping("/{id}")
  public ApiResponse<ComicResponse> getComic(@PathVariable Long id) {
    return ApiResponse.<ComicResponse>builder()
        .data(catalogService.getComic(id))
        .build();
  }

  @GetMapping
  public ApiResponse<List<ComicResponse>> getComics() {
    return ApiResponse.<List<ComicResponse>>builder()
        .data(catalogService.getComics())
        .build();
  }

  @PostMapping
  public ApiResponse<ComicResponse> postComic(@RequestBody @Validated ComicRequest request) {
    return ApiResponse.<ComicResponse>builder()
        .data(catalogService.createComic(request))
        .build();
  }

  @PutMapping("/{id}")
  public ApiResponse<ComicResponse> putComic(@PathVariable Long id, @RequestBody ComicRequest request) {
    return ApiResponse.<ComicResponse>builder()
        .data(catalogService.updateComic(id, request))
        .build();
  }

  @DeleteMapping("/{id}")
  public ApiResponse<Void> deleteComic(@PathVariable Long id) {
    catalogService.deleteComic(id);
    return ApiResponse.<Void>builder()
        .build();
  }
}
