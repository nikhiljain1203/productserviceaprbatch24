package com.example.productserviceaprbatch24.controllers;

import com.example.productserviceaprbatch24.dtos.SearchRequestDto;
import com.example.productserviceaprbatch24.models.Product;
import com.example.productserviceaprbatch24.services.SearchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public List<Product> search(@RequestBody SearchRequestDto requestDto) {
        return searchService.search(requestDto.getKeyword(), requestDto.getPageNumber(), requestDto.getSizeOfPage());
    }
}
