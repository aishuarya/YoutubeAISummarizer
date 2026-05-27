package org.com.ai.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SummaryService {

    private final TranscriptService transcriptService;
    private final ChunkingService chunkingService;
    private final OllamaService ollamaService;

    public String generateSummary(String youtubeUrl) throws Exception {

        String transcript = transcriptService.getTranscript(youtubeUrl);

        List<String> chunks = chunkingService.chunkText(transcript, 3000);
        List<String> chunkSummaries = new ArrayList<>();

        for (String chunk : chunks) {

            String summary = ollamaService.summarize(chunk);

            chunkSummaries.add(summary);
        }

        String combined = String.join("\n", chunkSummaries);

        return ollamaService.summarize(combined);
    }
}