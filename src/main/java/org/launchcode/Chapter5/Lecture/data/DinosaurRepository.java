package org.launchcode.Chapter5.Lecture.data;

import org.launchcode.Chapter5.Lecture.models.Dinosaur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinosaurRepository extends CrudRepository<Dinosaur, Integer> {
}
