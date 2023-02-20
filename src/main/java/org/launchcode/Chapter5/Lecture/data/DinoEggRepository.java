package org.launchcode.Chapter5.Lecture.data;

import org.launchcode.Chapter5.Lecture.models.DinoEgg;
import org.launchcode.Chapter5.Lecture.models.Dinosaur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinoEggRepository extends CrudRepository<DinoEgg, Integer> {

    //ANY data you want to store and use, you MUST create a repository for that model!




}
