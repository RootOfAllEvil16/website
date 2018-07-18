package com.project.eva.service.impl;

import com.project.eva.model.Model;
import com.project.eva.repository.MainRepository;
import com.project.eva.service.interfaces.MainService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static com.project.eva.util.validator.ObjectValidator.*;

public abstract class MainServiceImpl<T extends Model>
        implements MainService<T> {

    private final MainRepository<T> repository;


    public MainServiceImpl(final MainRepository<T> repository) {
        super();
        this.repository = repository;
    }

    @Override
    @Transactional
    public void add(final T model) {
        if (isNotNull(model)) {
            this.repository.save(model);
        }
    }


    @Override
    @Transactional
    public void add(final Collection<T> models) {
        if (isNotEmpty(models)) {
            this.repository.save(models);
        }
    }

    @Override
    @Transactional
    public void update(final T model) {
        add(model);
    }

    @Override
    @Transactional(readOnly = true)
    public T get(final long id) throws NullPointerException {
        final T model = this.repository.findOne(id);
        if (isNull(model)) {
            throw new NullPointerException("Can't find model by id " + id + "!");
        }
        return model;
    }


    @Override
    @Transactional(readOnly = true)
    public Collection<T> getAll() {
        return this.repository.findAll();
    }


    @Override
    @Transactional
    public void remove(final T model) {
        if (isNotNull(model)) {
            this.repository.delete(model);
        }
    }


    @Override
    @Transactional
    public void remove(final long id) {
        this.repository.delete(id);
    }


    @Override
    @Transactional
    public void remove(final Collection<T> models) {
        if (isNotEmpty(models)) {
            this.repository.delete(models);
        }
    }


    @Override
    @Transactional
    public void removeAll() {
        this.repository.deleteAll();
    }
}

