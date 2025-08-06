import React from 'react';
import { Link, Outlet } from 'react-router-dom';

function Layout() {
    return (
        <div>
            <nav style={{ padding: '1rem', borderBottom: '1px solid #ccc' }}>
                <Link to="/" style={{ marginRight: '1rem' }}>Home</Link>
                <Link to="/modules" style={{ marginRight: '1rem' }}>Modules</Link>
                <Link to="/lecturers">Lecturers</Link>
            </nav>
            <main style={{ padding: '1rem' }}>
                <Outlet />
            </main>
        </div>
    );
}

export default Layout;