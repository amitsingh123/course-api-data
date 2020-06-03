package com.amit.springboot.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourseList(String topicId) {
        return courseRepository.findByTopicId(topicId);
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).get();
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addCourse(Course course) {
       courseRepository.save(course);
    }

    public void updateCourse(Course course) {
                courseRepository.save(course);
    }

    public void deleteCourse(String id) {
//        for(Topic t: topics) {
//            if(t.getId().equals(id)) {
//                topics.remove(t);
//            }
//        }
        // Using lambda
        //topics.removeIf(t -> t.getId().equals(id));

        courseRepository.deleteById(id);
    }
}
