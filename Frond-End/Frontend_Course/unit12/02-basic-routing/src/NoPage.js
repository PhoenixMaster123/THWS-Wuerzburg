import React from 'react';

function NoPage() {
    return (
        <div style={{
            minHeight: '100vh',
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center',
            background: '#f8fafc',
            color: '#1e293b',
            fontFamily: 'sans-serif'
        }}>
            <h1 style={{ fontSize: '6rem', margin: 0 }}>404</h1>
            <h2 style={{ margin: '1rem 0' }}>Page Not Found</h2>
            <p style={{ marginBottom: '2rem', color: '#64748b' }}>
                Sorry, the page you are looking for does not exist.
            </p>
            <a
                href="/"
                style={{
                    padding: '0.75rem 1.5rem',
                    background: '#2563eb',
                    color: '#fff',
                    borderRadius: '0.5rem',
                    textDecoration: 'none',
                    fontWeight: 'bold',
                    transition: 'background 0.2s'
                }}
            >
                Go Home
            </a>
        </div>
    );
}

export default NoPage;