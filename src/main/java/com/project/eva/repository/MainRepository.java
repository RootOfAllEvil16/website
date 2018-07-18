package com.project.eva.repository;

import com.project.eva.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MainRepository<T extends Model> extends JpaRepository<T, Long> {
}
