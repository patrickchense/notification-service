package com.chenzhe.templateservice.dao;

import com.chenzhe.templateservice.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {

    Template findByKey(String key);
}
