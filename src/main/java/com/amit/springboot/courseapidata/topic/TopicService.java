package com.amit.springboot.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicsRepository topicsRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring","Spring Framework","Spring Framework Description"),
            new Topic("java","core java","core java 8 description"),
            new Topic("yoga","My Yoga","Yoga is Good for mind and soul")));

    public List<Topic> getTopicList() {
        List<Topic> topics = new ArrayList<>();
        topicsRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
        return topicsRepository.findById(id).get();
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
       topicsRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
                topicsRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        for(Topic t: topics) {
//            if(t.getId().equals(id)) {
//                topics.remove(t);
//            }
//        }
        // Using lambda
        //topics.removeIf(t -> t.getId().equals(id));

        topicsRepository.deleteById(id);
    }
}
