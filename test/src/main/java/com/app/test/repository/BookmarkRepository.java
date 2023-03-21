package com.app.test.repository;

import com.app.test.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query(value = "SELECT * FROM Bookmark WHERE ID = ?1", nativeQuery = true)
    Bookmark getBookmarkByID(int id);

    @Query(value = "DELETE  FROM BOOKMARK WHERE ID =?1", nativeQuery = true)
    Bookmark deleteBookmarkByID (int id);

}
