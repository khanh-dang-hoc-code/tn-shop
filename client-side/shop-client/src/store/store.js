import { configureStore } from '@reduxjs/toolkit';
import { authApi } from '../services/authService';
import authSlice from './authSlice';
import registerSlice from './registerSlice';

export const store = configureStore({
  reducer: {
    auth: authSlice,
    register: registerSlice,
    [authApi.reducerPath]: authApi.reducer
  },
  middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(authApi.middleware)
});
