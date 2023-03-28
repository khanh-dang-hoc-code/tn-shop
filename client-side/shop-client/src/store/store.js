import { configureStore } from '@reduxjs/toolkit';
import { authApi } from '../services/authService';
import authSlice from './authSlice';

export const store = configureStore({
  reducer: {
    auth: authSlice,
    [authApi.reducerPath]: authApi.reducer
  },
  middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(authApi.middleware)
});
