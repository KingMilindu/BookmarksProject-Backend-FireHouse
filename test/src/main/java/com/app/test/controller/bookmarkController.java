package com.app.test.controller;

import com.app.test.entity.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class bookmarkController {

    @Autowired
    private com.app.test.service.bookmarkService bookmarkService;

    @PostMapping("/fetch-bookmarks")
    public ResponseEntity <String> fetchData(){
        bookmarkService.fetchBookmarkAndSave();
        return ResponseEntity.ok("Bookmarks Fetched and Saved Successfully");
    }


    @GetMapping("/getallbookmarks")
    public List<Bookmark> getAllBookmarks() {
        return bookmarkService.getAllBookmarks();
    }

    @PostMapping("/createbookmark")
    public Bookmark createBookmark(@RequestBody Bookmark bookmark) {
        return bookmarkService.saveBookmark(bookmark);
    }

    @PutMapping("/updatebookmark/{id}")
    public Bookmark updateBookmark(@PathVariable Long id, @RequestBody Bookmark bookmark) {
        bookmark.setId(id);
        return bookmarkService.saveBookmark(bookmark);
    }

    @DeleteMapping("/deletebookmark/{id}")
    public void deleteBookmark(@PathVariable Long id) {
        bookmarkService.deleteBookmark(id);
    }
}
