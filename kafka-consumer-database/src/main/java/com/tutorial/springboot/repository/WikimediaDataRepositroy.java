package com.tutorial.springboot.repository;

import com.tutorial.springboot.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepositroy extends JpaRepository<WikimediaData, Long> {


}
