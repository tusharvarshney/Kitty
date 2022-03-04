package com.tushar.kitty.api

import com.tushar.kitty.helper.Constants
import com.tushar.kitty.models.KittyApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface KittyService {

  @GET(Constants.END_POINT)
  suspend fun getCatList(): Response<KittyApiResponse>
}