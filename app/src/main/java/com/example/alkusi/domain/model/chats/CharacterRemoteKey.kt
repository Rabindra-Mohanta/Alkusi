package com.example.alkusi.domain.model.chats

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterRemoteKey(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
