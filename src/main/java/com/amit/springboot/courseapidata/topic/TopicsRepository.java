package com.amit.springboot.courseapidata.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicsRepository extends CrudRepository<Topic,String> {
}
