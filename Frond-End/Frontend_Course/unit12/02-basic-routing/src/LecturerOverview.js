import React from 'react';
import LecturerDetail from './LecturerDetail';

const lecturers = [
    { id: 1, name: 'Prof. Dr. Anna Schmidt' },
    { id: 2, name: 'Prof. Dr. Markus Weber' },
    { id: 3, name: 'Prof. Dr. Julia Müller' },
    { id: 4, name: 'Prof. Dr. Thomas Becker' },
    { id: 5, name: 'Prof. Dr. Sabine Hoffmann' },
    { id: 6, name: 'Prof. Dr. Michael Braun' },
    { id: 7, name: 'Prof. Dr. Petra Klein' },
    { id: 8, name: 'Prof. Dr. Stefan Richter' },
];

const defaultProfileImg = 'https://i.pravatar.cc/300';

function LecturerOverview() {
    return (
        <div>
            <h2>Lecturer Overview</h2>
            <div style={{ display: 'flex', flexWrap: 'wrap', gap: '1rem' }}>
                {lecturers.map(lecturer => (
                    <div
                        key={lecturer.id}
                        style={{
                            background: '#fff',
                            border: '1px solid #ddd',
                            borderRadius: '8px',
                            boxShadow: '0 2px 8px rgba(0,0,0,0.05)',
                            padding: '1rem',
                            width: '200px',
                            display: 'flex',
                            flexDirection: 'column',
                            alignItems: 'center'
                        }}
                    >
                        <img
                            src={defaultProfileImg}
                            alt="Profile"
                            width={64}
                            height={64}
                            style={{ borderRadius: '50%', marginBottom: '0.75rem' }}
                        />
                        <span style={{ fontWeight: 'bold', textAlign: 'center' }}>{lecturer.name}</span>
                    </div>
                ))}
            </div>
        </div>
    );

}


export default LecturerOverview;