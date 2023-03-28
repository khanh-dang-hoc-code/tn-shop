import { fetchBaseQuery } from '@reduxjs/toolkit/query/react';
import { baseUrl } from '../common/constant';
import { getItemInStorage } from '../helper/tokenUtils';

export const baseQuery = fetchBaseQuery({
  baseUrl: baseUrl,

  prepareHeaders: (headers, { getState }) => {
    // Mark requests as XMLHttpRequest
    headers.set('Content-Type', 'application/json');
    // Add authorization token to header if exists
    const token = getItemInStorage('accessToken');
    if (token) {
      headers.set('Authorization', `Bearer ${token}`);
    }
    console.log('token', token);

    return headers;
  }
});
