import React from 'react';
import { Link, useParams } from 'react-router-dom';

const modules = [
    { index: 1, title: 'Algorithms and Data Structures', workload: 6, lecturerId: 1 },
    { index: 2, title: 'Operating Systems', workload: 5, lecturerId: 2 },
    { index: 3, title: 'Database Systems', workload: 5, lecturerId: 3 },
    { index: 4, title: 'Computer Networks', workload: 4, lecturerId: 4 },
    { index: 5, title: 'Software Engineering', workload: 6, lecturerId: 5 },
    { index: 6, title: 'Artificial Intelligence', workload: 5, lecturerId: 6 },
    { index: 7, title: 'Web Development', workload: 4, lecturerId: 7 },
    { index: 8, title: 'Computer Architecture', workload: 5, lecturerId: 8 },
    { index: 9, title: 'Theory of Computation', workload: 4, lecturerId: 1 },
    { index: 10, title: 'Human-Computer Interaction', workload: 3, lecturerId: 2 },
    { index: 11, title: 'Distributed Systems', workload: 5, lecturerId: 3 },
    { index: 12, title: 'Cybersecurity', workload: 4, lecturerId: 4 },
    { index: 13, title: 'Machine Learning', workload: 5, lecturerId: 5 },
    { index: 14, title: 'Parallel Computing', workload: 4, lecturerId: 6 },
    { index: 15, title: 'Compiler Construction', workload: 4, lecturerId: 7 },
];

function ModuleOverview() {
    return (
        <div>
            <h2>Module Overview</h2>
            <div style={{
                display: 'flex',
                flexWrap: 'wrap',
                gap: '16px',
                justifyContent: 'flex-start'
            }}>
                {modules.map((module, idx) => (
                    <div
                        key={idx}
                        style={{
                            border: '1px solid #ccc',
                            borderRadius: '8px',
                            padding: '16px',
                            width: '220px',
                            boxShadow: '0 2px 8px rgba(0,0,0,0.11)',
                            background: '#fafbfc'
                        }}
                    >
                        <h3 style={{ margin: '0 0 8px 0', fontSize: '1.1em' }}>{module.title}</h3>
                        <div><strong>{module.workload} CP</strong></div>
                        <div style={{ marginTop: '8px' }}>
                            <Link to={`/moduledetails/${module.index}`}>More Information</Link>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

function ModuleDetails() {
    const { m } = useParams();
    const module = modules.find(mod => mod.index === parseInt(m, 10));

    if (!module) {
        return <div>Module not found.</div>;
    }

    return (
        <div>
            <h2>{module.title}</h2>
            <p>Workload: {module.workload} CP</p>
            <p>
                This module covers essential concepts and practical skills. 
                You will gain a deep understanding of the subject and apply your knowledge in real-world scenarios.
            </p>
            <p>
                <Link to={`/lecturer/${module.lecturerId}`}>View Lecturer</Link>
            </p>
        </div>
    );
}

export { ModuleOverview, ModuleDetails };