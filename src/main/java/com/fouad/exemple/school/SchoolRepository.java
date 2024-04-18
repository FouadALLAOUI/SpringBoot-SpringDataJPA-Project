package com.fouad.exemple.school;

import com.fouad.exemple.school.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {

}
