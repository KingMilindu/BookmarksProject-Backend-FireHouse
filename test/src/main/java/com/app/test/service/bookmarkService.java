package com.app.test.service;
//import org.modelmapper.ModelMapper;

import com.app.test.entity.Bookmark;
import com.app.test.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class bookmarkService {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    public void fetchBookmarkAndSave(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://demo.dreamsquadgroup.com/test/index.json";
        Bookmark[] bookmarksList = restTemplate.getForObject(url,Bookmark[].class);

        bookmarkRepository.saveAll(Arrays.asList(bookmarksList));
    }



    public List<Bookmark> getAllBookmarks() {
        return bookmarkRepository.findAll();
    }

    public Bookmark saveBookmark(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }

    public void deleteBookmark(Long id) {
        bookmarkRepository.deleteById(id);
    }

}
