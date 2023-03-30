import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  registerData: {
    firstName: '',
    lastName: '',
    userName: '',
    password: ''
  }
};

export const registerSlice = createSlice({
  name: 'register',
  initialState,
  reducers: {
    setRegisterData: (state, action) => {
      state.registerData = action.payload;
    }
  }
});

export const { setRegisterData } = registerSlice.actions;
export const selectRegisterData = (state) => state.register.registerData;
export default registerSlice.reducer;
