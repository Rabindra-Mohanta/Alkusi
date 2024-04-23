package com.example.alkusi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.alkusi.data.local.character.CharacterDao
import com.example.alkusi.data.local.character.CharacterRemoteKeyDao
import com.example.alkusi.domain.model.chats.CharacterRemoteKey
import com.example.alkusi.domain.model.chats.CharacterResultData

@Database(entities = [CharacterResultData::class, CharacterRemoteKey::class], version = 1)
abstract class AlkusiDb : RoomDatabase() {
    abstract val characterDao: CharacterDao
    abstract val characterRemoteKeyDao: CharacterRemoteKeyDao
}