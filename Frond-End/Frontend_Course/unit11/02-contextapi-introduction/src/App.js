import './App.css';
import React from 'react';
import { OnlyDisplayComponent,  OnlyEditComponent } from './InnerComponent';

const DemoContext = React.createContext();

function App() {
  const [state, setState] = React.useState({
    count: 0,
    text: 'Hello, World!'
  });

  return (
    <div className="App">
      <DemoContext.Provider value={{state,setState}}>
        <OnlyDisplayComponent />
        <OnlyEditComponent/>
      </DemoContext.Provider>
    </div>
  );
}

export default App;
export { DemoContext };
