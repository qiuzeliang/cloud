package org.example.front.outbound;

import io.vertx.core.json.JsonObject;
import lombok.RequiredArgsConstructor;
import org.example.front.model.Channel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ChannelApiImpl implements ChannelApi {

    private final RestTemplate template;

    @Override
    public void addChannel(Channel channel) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> entity = new HttpEntity<>(new JsonObject().encode(), headers);
        template.postForObject("http://core/channel/addChannel", entity, String.class);
    }
}
