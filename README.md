# AI YouTube Summarizer

An AI-powered YouTube video summarizer built using Java Spring Boot, Python transcript extraction, and Ollama LLMs.

This application:

* extracts YouTube transcripts,
* chunks large transcripts,
* sends chunks to a local LLM,
* and generates concise AI summaries.

---

# Tech Stack

## Backend

* Java 21
* Spring Boot

## AI

* Ollama
* Llama 3

## Frontend

* React
* Vite

## Transcript Extraction

* Python
* Flask
* youtube-transcript-api

---

# System Architecture

```text id="m0w5zg"
React Frontend
       ↓
Spring Boot Backend
       ↓
Python Transcript Service
       ↓
Ollama LLM
       ↓
AI Summary Response
```

---


# How It Works

```text id="0wk9lc"
YouTube URL
    ↓
Extract Transcript
    ↓
Chunk Large Text
    ↓
Send Chunks To LLM
    ↓
Generate Chunk Summaries
    ↓
Merge Summaries
    ↓
Generate Final Summary
```

---


# Prerequisites

Install:

* Java 21
* Python 3
* Node.js
* Ollama

---

# Step 1 — Install Ollama

Install Ollama:

https://ollama.com

Pull Llama 3 model:

```bash id="v6lvx0"
ollama pull llama3
```

Run model:

```bash id="8b25o5"
ollama run llama3
```

Ollama runs on:

```text id="q7uk1f"
http://localhost:11434
```

---

# Step 2 — Setup Python Transcript Service

clone and run - https://github.com/aishuarya/YouTubeTranscriptApi

# Step 3 — Setup Spring Boot Backend

Navigate:

```bash id="lm5mwx"
cd springboot-backend
```

Run:

```bash id="4f72y9"
mvn spring-boot:run
```

Runs on:

```text id="2t34pn"
http://localhost:8080
```

---

# Step 4 — Setup React Frontend

Navigate:

```bash id="1wttm8"
cd frontend-react
```

Install dependencies:

```bash id="97hgjm"
npm install
```

Run:

```bash id="2c2r6w"
npm run dev
```

Runs on:

```text id="8fj1xv"
http://localhost:5173
```

---
