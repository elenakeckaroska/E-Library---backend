package mk.ukim.finki.web.controller;

import mk.ukim.finki.models.enumerations.BookCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoriesController {

    @GetMapping
    public List<String> getAllCategories() {
        List<String> categories = Arrays.stream(BookCategory.values())
                .map(b -> b.toString())
                .collect(Collectors.toList());
        return categories;
    }
}
