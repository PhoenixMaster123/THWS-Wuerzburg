import React, { useState } from "react";
import ChildComponent from "./ChildComponent";

const ParentComponent = () => {
  const [message, setMessage] = useState("");

  const handleMessageChange = (newMessage) => {
    setMessage(newMessage);
  };

  return (
    <div style={{ padding: "2em", fontFamily: "Arial" }}>
      <h2>Parent Component</h2>
      <p>
        Message from child: <strong>{message}</strong>
      </p>
      <ChildComponent onMessageChange={handleMessageChange} />
    </div>
  );
};

export default ParentComponent;
