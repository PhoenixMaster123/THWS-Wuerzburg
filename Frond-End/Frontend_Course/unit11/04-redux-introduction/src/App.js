import './App.css';
import React from 'react';
import { Provider } from 'react-redux';
import store from './store';
import { OnlyDisplayComponent, OnlyEditComponent } from './InnerComponents';

function App() {
  return (
    <div className="App">
      <Provider store={store}>
        <OnlyDisplayComponent />
        <OnlyEditComponent />
      </Provider>
    </div>
  );
}

export default App;