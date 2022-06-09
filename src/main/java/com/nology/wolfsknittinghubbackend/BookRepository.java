package com.nology.wolfsknittinghubbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    int deleteBookByBookId(int bookId);
}
