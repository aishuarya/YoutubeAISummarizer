package org.com.ai.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OllamaService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String summarize(String text) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String prompt = """
                Summarize the following YouTube transcript.
                Give concise bullet points.
                Focus on important concepts.
Transcript:
                %s
                """.formatted(text);

        String requestBody = """
                {
                    "model":"llama3",
                    "prompt":%s,
                    "stream":false
                }
                """.formatted(toJsonString(prompt));

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:11434/api/generate",
                entity,
                String.class
        );

        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(response.getBody());

        return jsonNode.get("response").asText();
    }

    private String toJsonString(String input) {
        return "\"" + input
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n") + "\"";
    }
}