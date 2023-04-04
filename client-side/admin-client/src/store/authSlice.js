import { createSlice } from '@reduxjs/toolkit';
import { getItemInStorage } from '../helper/tokenUtils';

const initialState = {
  token: getItemInStorage('accessToken') || ''
};

export const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    setToken: (state, action) => {
      state.token = action.payload;
    }
  }
});

export const { setToken } = authSlice.actions;
export const selectToken = (state) => state.auth.token;
export default authSlice.reducer;
