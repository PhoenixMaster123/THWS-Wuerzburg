import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import NoPage from "./NoPage";
import { ModuleOverview, ModuleDetails } from "./Modules";
import LecturerOverview from "./LecturerOverview";
import Layout from "./Layout";
import Home from "./Home";
import LecturerDetail from "./LecturerDetail";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout/>} >
                <Route index element={<Home/>} />
                <Route path="modules" element={<ModuleOverview/>} />
                <Route path="lecturers" element={<LecturerOverview/>} />
                <Route path="lecturers:id" element={<LecturerDetail/>} />
                <Route path="moduledetails/:m" element={<ModuleDetails />} />
                <Route path="*" element={<NoPage />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
