package com.comic.learn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.comic.learn.dto.request.ComicRequest;
import com.comic.learn.dto.response.ComicResponse;
import com.comic.learn.entity.Comic;
import com.comic.learn.exception.AppException;
import com.comic.learn.exception.ErrorCode;
import com.comic.learn.repository.ComicRepository;
import com.comic.learn.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatalogService {
  private final ComicRepository comicRepository;
  private final OrderRepository orderRepository;

  public ComicResponse getComic(Long id) {
    Comic comic = comicRepository.findById(id).orElseThrow(
        () -> new AppException(ErrorCode.COMIC_NOT_FOUND));
    return ComicResponse.builder()
        .id(comic.getId())
        .title(comic.getTitle())
        .author(comic.getAuthor())
        .price(comic.getPrice())
        .stock(comic.getStock())
        .build();
  }

  public List<ComicResponse> getComics() {
    List<Comic> comics = comicRepository.findAll();
    return comics.stream()
        .map((comic) -> {
          return ComicResponse.builder()
              .id(comic.getId())
              .title(comic.getTitle())
              .author(comic.getAuthor())
              .price(comic.getPrice())
              .stock(comic.getStock())
              .build();
        }).toList();
  }

  public ComicResponse createComic(ComicRequest request) {
    Comic comic = Comic.builder()
        .title(request.getTitle())
        .author(request.getAuthor())
        .price(request.getPrice())
        .stock(request.getStock())
        .build();
    comic = comicRepository.save(comic);
    return ComicResponse.builder()
        .id(comic.getId())
        .title(comic.getTitle())
        .author(comic.getAuthor())
        .price(comic.getPrice())
        .stock(comic.getStock())
        .build();
  }

  public ComicResponse updateComic(Long id, ComicRequest request) {
    Comic comic = comicRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.COMIC_NOT_FOUND));

    comic.setPrice(request.getPrice());
    comic.setAuthor(request.getAuthor());
    comic.setStock(request.getStock());
    comic.setTitle(request.getTitle());

    comic = comicRepository.save(comic);

    return ComicResponse.builder()
        .id(comic.getId())
        .title(comic.getTitle())
        .author(comic.getAuthor())
        .price(comic.getPrice())
        .stock(comic.getStock())
        .build();
  }

  public void deleteComic(Long id) {
    Comic comic = comicRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.COMIC_NOT_FOUND));
    if (orderRepository.existsByComicId(id)) {
      throw new AppException(ErrorCode.COMIC_IN_USE);
    }
    comicRepository.delete(comic);
  }
}