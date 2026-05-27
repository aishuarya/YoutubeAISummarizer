package org.com.ai.backend.controller;

import org.com.ai.backend.model.SummaryRequest;
import org.com.ai.backend.model.SummaryResponse;
import org.com.ai.backend.service.SummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SummaryController {

    private final SummaryService summaryService;

    @PostMapping("/summarize")
    public SummaryResponse summarize(
            @RequestBody SummaryRequest request
    ) throws Exception {

        String summary = summaryService.generateSummary(
                request.getYoutubeUrl()
        );

        return new SummaryResponse(summary);
    }
}
