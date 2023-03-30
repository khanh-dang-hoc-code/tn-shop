import { createApi } from '@reduxjs/toolkit/query/react';
import { baseQuery } from './baseService';

export const authApi = createApi({
  reducerPath: 'authApi',
  baseQuery: baseQuery,
  endpoints: (builder) => ({
    login: builder.mutation({
      query: (data) => ({
        url: `/api/auth/authenticate`,
        method: 'POST',
        body: data
      })
    })
  })
});

export const { useLoginMutation } = authApi;