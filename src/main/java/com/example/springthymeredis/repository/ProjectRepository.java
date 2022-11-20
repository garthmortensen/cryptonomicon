package com.example.springthymeredis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.springthymeredis.model.Project;

// TODO: what is a repository?
@Repository
public interface ProjectRepository extends CrudRepository<Project, String>{

}
