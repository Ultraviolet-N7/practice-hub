package org.launchcode.practicehub.data;

import org.launchcode.practicehub.models.Practice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeRepository extends CrudRepository<Practice, Integer> {
}
