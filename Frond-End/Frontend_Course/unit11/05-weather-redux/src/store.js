import { configureStore, createSlice } from '@reduxjs/toolkit';

const weatherSlice = createSlice({
  name: 'weather',
  initialState: {
    city: "Würzburg",
    weather: null,
    error: null,
    favorites: ["Berlin", "München"]
  },
  reducers: {
    setCity(state, action) {
      state.city = action.payload;
    },
    addFavorite(state, action) {
      const city = action.payload;
      if (!state.favorites.includes(city)) {
        state.favorites.push(city);
      }
    },
    setWeather(state, action) {
      state.weather = action.payload;
      state.error = null;
    },
    setError(state, action) {
      state.error = action.payload;
      state.weather = null;
    }
  }
});

export const { setCity, addFavorite, setWeather, setError } = weatherSlice.actions;

const store = configureStore({
  reducer: {
    weather: weatherSlice.reducer
  }
});

export default store;