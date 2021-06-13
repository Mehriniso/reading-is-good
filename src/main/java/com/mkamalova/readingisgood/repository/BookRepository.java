package com.mkamalova.readingisgood.repository;

import com.mkamalova.readingisgood.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String>
{
}
