package com.example.springthymeredis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.springthymeredis.model.Project;

// FYI: @Repository indicates the decorated class is a repo
// Repo = encapsulates storage/retrieval/search behavior for a collection of objects
@Repository
public interface ProjectRepository extends CrudRepository<Project, String>{
}
