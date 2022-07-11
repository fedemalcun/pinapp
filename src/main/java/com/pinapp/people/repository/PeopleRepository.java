package com.pinapp.people.repository;

import com.pinapp.people.repository.dao.PeopleDao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepository extends CrudRepository<PeopleDao, Long> {

    PeopleDao save(PeopleDao peopleDao);

    List<PeopleDao> findAll();

}
