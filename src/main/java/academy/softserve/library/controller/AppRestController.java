package academy.softserve.library.controller;

import academy.softserve.library.dto.AuthorDto;
import academy.softserve.library.model.Author;
import academy.softserve.library.service.AuthorService;
import academy.softserve.library.util.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class AppRestController {
    private AuthorService authorService;

    @Autowired
    public AppRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/allAuthors", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        List<AuthorDto> authors = DtoUtil.toAuthorDtoList(authorService.getAll());
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PostMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDto> createAuthor(AuthorDto authorDto) {
        Author author = authorService.saveOrUpdate(DtoUtil.toAuthor(authorDto, new Author()));
        return new ResponseEntity<>(DtoUtil.toAuthorDto(author), HttpStatus.OK);
    }
}
