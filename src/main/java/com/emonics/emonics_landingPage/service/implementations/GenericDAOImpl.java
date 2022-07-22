package com.emonics.emonics_landingPage.service.implementations;

import com.emonics.emonics_landingPage.service.contracts.GenericDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericDAOImpl <E, R extends PagingAndSortingRepository<E, Integer>> implements GenericDAO<E> {

    protected final R repository;

    public GenericDAOImpl(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }



    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}