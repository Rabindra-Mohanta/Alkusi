package com.example.alkusi.data.remote

import com.example.alkusi.domain.model.chats.CharacterData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlkusiApi {
    @GET("api/character")
    suspend fun getCharacter(@Query("page") page: Int): Response<CharacterData>
}

