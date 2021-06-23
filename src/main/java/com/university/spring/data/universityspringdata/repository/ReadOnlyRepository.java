package com.university.spring.data.universityspringdata.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * created with love by mundiaem
 * created on 23/06/2021
 * Time: 14:38
 * ⚡ '' - University-Spring Data
 */
@NoRepositoryBean
public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {
    T findOne(ID id);

    boolean exists(ID id);

    Iterable<T> findALl();

    Iterable<T> findAll(Sort sort);

    Iterable<T> findAll(Iterable<ID> iterable);

    Page<T> findAll(Pageable pageable);

    long count();
}
