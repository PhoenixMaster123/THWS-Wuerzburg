export const auth = {
  isAuthenticated: false,
  login(username, password, cb) {
    this.isAuthenticated = true;
    setTimeout(cb, 100); 
  },
  logout(cb) {
    this.isAuthenticated = false;
    setTimeout(cb, 100);
  }
};