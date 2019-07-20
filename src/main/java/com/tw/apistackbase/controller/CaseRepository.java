package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.LawCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

    public interface CaseRepository extends JpaRepository<LawCase, Long> {
        List<LawCase> findAll();
        LawCase findByName(String name);
        List<LawCase> findAllByName(String name);

        LawCase findById(long id);
        @Override
        void delete(LawCase entity);


    }

