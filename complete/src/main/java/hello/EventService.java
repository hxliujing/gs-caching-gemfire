package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("unused")
@Service
public class EventService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(){
        LightEvent event = new LightEvent("", LightEvent.LightColorEnum.GREEN);
        LightEvent2 event2 = new LightEvent2("", LightEvent2.LightColorEnum.AAA);
        applicationEventPublisher.publishEvent(event);
        applicationEventPublisher.publishEvent(event2);
    }

    @EventListener
    public void handler(LightEvent event){
        try {
            Thread.sleep(2000); //模拟一个比较耗时的操作
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("LightEvent->>traffic light：" + event.getLightColor().getMessage());
    }

    @EventListener
    @Async
    public void handler(LightEvent2 event){
        try {
            Thread.sleep(2000); //模拟一个比较耗时的操作
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("LightEvent2->>traffic light：" + event.getLightColor().getMessage());
    }
}
