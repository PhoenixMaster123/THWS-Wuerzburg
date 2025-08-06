import React from "react";
import { DemoContext } from "./App";

const OnlyDisplayComponent = () => {
  const context = React.useContext(DemoContext);

  return (
    <div>
      <h1>Inner Component</h1>
      <p>Count: {context.state.count}</p>
      <p>Text: {context.state.text}</p>
    </div>
  );
};

const OnlyEditComponent = () => {
  const context = React.useContext(DemoContext);

  const handleIncrease = () => {
    context.setState(prev => ({
    ...prev,
    count: prev.count + 1
  }));
  };

  return (
    <div>
      <h1>Edit Component</h1>
      <button onClick={handleIncrease}>Increase Count</button>
    </div>
  );
};

export { OnlyDisplayComponent, OnlyEditComponent };
