package com.example.alkusi.domain.model.chats

import androidx.room.Entity
import androidx.room.PrimaryKey

data class CharacterData(val info: InfoData, val results: List<CharacterResultData> = emptyList())
data class InfoData(val count: Int, val pages: Int, val next: String?, val prev: String?)
@Entity
data class CharacterResultData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?
)
