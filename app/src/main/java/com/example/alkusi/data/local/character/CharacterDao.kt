package com.example.alkusi.data.local.character

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.alkusi.domain.model.chats.CharacterResultData


@Dao
interface  CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character:List<CharacterResultData>)
    @Query("DELETE FROM CharacterResultData")
    suspend fun deleteCharacter()
    @Query("SELECT * FROM CharacterResultData")
    fun getCharacterData():PagingSource<Int,CharacterResultData>
}

