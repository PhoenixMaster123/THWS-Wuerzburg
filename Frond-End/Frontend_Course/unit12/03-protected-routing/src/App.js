import "./App.css";
import { Routes, Route, Link, useNavigate } from "react-router-dom";
import Login from "./Login";
import ProtectedRoute from "./ProtectedRoute";
import { auth } from "./auth";

function ProtectedPage() {
  const navigate = useNavigate();

  const handleLogout = () => {
    auth.logout(() => {
      navigate("/login");
    });
  };

  return (
    <div>
      <h2>Protected Page</h2>
      <button
        onClick={handleLogout} >
        {" "}
        Logout{" "}
      </button>
    </div>
  );
}

function Home() {
  return <h2>Home</h2>;
}

function App() {
  return (
    <>
      <nav>
        <Link to="/">Home</Link>{" "}
        <Link to="/protected">Protected Page</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route
          path="/protected"
          element={
            <ProtectedRoute>
              <ProtectedPage />
            </ProtectedRoute>
          }
        />
      </Routes>
    </>
  );
}

export default App;
