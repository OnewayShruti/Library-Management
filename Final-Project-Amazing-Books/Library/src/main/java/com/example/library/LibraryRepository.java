package com.example.library;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends CrudRepository<Library,Integer> {
    Library findByBookIdAndCustomerId(Integer bookId, Integer customerId);
}
