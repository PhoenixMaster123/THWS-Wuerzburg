import { configureStore, createSlice } from '@reduxjs/toolkit';

const demoSlice = createSlice({
  name: 'demo',
  initialState: {
    count: 0,
    text: 'Hello, World!'
  },
  reducers: {
    increment: (state, n) => {
      state.n = n.payload || 1
      state.count += state.n;
    }
  }
});

export const { increment } = demoSlice.actions;

const store = configureStore({
  reducer: {
    demo: demoSlice.reducer
  }
});

export default store;