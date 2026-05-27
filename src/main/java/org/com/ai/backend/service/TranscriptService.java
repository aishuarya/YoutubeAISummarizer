package org.com.ai.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranscriptService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getTranscript(String youtubeUrl) throws Exception {

        String videoId = extractVideoId(youtubeUrl);

        String url = "http://localhost:5000/transcript?videoId=" + videoId;

        String response = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(response);

        return jsonNode.get("transcript").asText();
    }

    private String extractVideoId(String url) {

        if (url.contains("v=")) {
            return url.split("v=")[1].split("&")[0];
        }

        throw new RuntimeException("Invalid YouTube URL");
    }
}