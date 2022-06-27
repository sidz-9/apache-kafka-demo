package com.tutorial.springboot;

import com.tutorial.springboot.entity.WikimediaData;
import com.tutorial.springboot.repository.WikimediaDataRepositroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerDatabase.class);

    private WikimediaDataRepositroy wikimediaDataRepositroy;

    public KafkaConsumerDatabase(WikimediaDataRepositroy wikimediaDataRepositroy) {
        this.wikimediaDataRepositroy = wikimediaDataRepositroy;
    }

    @KafkaListener(topics = "wikimedia_recent_change", groupId = "myGroup")
    public void consume(String eventMessage) {

        LOGGER.info(String.format("Event Message Received -> %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        wikimediaDataRepositroy.save(wikimediaData);
    }
}
