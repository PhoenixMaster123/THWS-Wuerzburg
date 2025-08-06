import React from 'react';
import { useParams } from 'react-router-dom';

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

const LecturerDetail = () => {
    const { id } = useParams();
    const lecturer = lecturers.find(l => l.id === parseInt(id, 10));

    if (!lecturer) {
        return <div>Lecturer not found.</div>;
    }

    return (
        <div>
            <h2>{lecturer.name}</h2>
            <img
                src={defaultProfileImg}
                alt="Profile"
                width={100}
                height={100}
                style={{ borderRadius: '50%', margin: '1rem 0' }}
            />
            <p>This lecturer is responsible for delivering high-quality education in their respective field.</p>
        </div>
    );
};

export default LecturerDetail;
