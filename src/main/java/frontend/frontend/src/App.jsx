import { useState } from "react";

function App() {

  const [youtubeUrl, setYoutubeUrl] = useState("");
  const [summary, setSummary] = useState("");
  const [loading, setLoading] = useState(false);

  const summarizeVideo = async () => {

    if (!youtubeUrl) {
      alert("Enter YouTube URL");
      return;
    }

    setLoading(true);
    setSummary("");

    try {

      const response = await fetch(
        "http://localhost:8080/api/summarize",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            youtubeUrl: youtubeUrl,
          }),
        }
      );

      const data = await response.json();

      setSummary(data.summary);

    } catch (error) {

      console.error(error);

      setSummary("Something went wrong");

    } finally {

      setLoading(false);
    }
  };

  return (

    <div style={{
      maxWidth: "800px",
      margin: "50px auto",
      padding: "20px",
      fontFamily: "Arial"
    }}>

      <h1>AI YouTube Summarizer</h1>

      <input
        type="text"
        placeholder="Paste YouTube URL"
        value={youtubeUrl}
        onChange={(e) => setYoutubeUrl(e.target.value)}
        style={{
          width: "100%",
          padding: "12px",
          marginTop: "20px"
        }}
      />

      <button
        onClick={summarizeVideo}
        style={{
          marginTop: "20px",
          padding: "12px 20px",
          cursor: "pointer"
        }}
      >
        {loading ? "Generating..." : "Generate Summary"}
      </button>

      {summary && (

        <div style={{
          marginTop: "30px",
          background: "#f4f4f4",
          padding: "20px",
          borderRadius: "10px",
          whiteSpace: "pre-wrap"
        }}>

          <h2>Summary</h2>

          <p>{summary}</p>

        </div>
      )}

    </div>
  );
}

export default App;