package com.makeathon.uj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makeathon.uj.entity.ContentFiles;

@Repository
public interface ContentFilesRepository extends JpaRepository<ContentFiles, Integer> {

}
