import React from 'react';

const LoginPage = () => {
  return (
    <div style={{ textAlign: 'center', marginTop: '3em' }}>
      <h2>Login</h2>
      <form>
        <input type="text" placeholder="Username" /><br /><br />
        <input type="password" placeholder="Password" /><br /><br />
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default LoginPage;
