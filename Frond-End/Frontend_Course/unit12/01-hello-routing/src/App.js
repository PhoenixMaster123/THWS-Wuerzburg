import { Routes, Route } from 'react-router-dom';
import LoginPage from './LoginPage';
import ContentPage from './ContentPage';

const App = () => {
  return (
    <Routes>
      <Route path="/login" element={<LoginPage />} />
      <Route path="/content" element={<ContentPage />} />
    </Routes>
  );
};

export default App;