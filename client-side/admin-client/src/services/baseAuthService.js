import { fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const baseQuery = fetchBaseQuery({
  baseUrl: 'http://localhost:8080/',

  prepareHeaders: (headers, { getState }) => {
    // Mark requests as XMLHttpRequest
    headers.set('Content-Type', 'application/json');
    // Add authorization token to header if exists
    // const token = getItemInStorage('crm-tnshop-token');
    // if (token) {
    //   headers.set('Authorization', `Bearer ${token}`);
    // }

    return headers;
  }
});
