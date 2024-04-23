package com.example.alkusi.data.local.character

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.alkusi.domain.model.chats.CharacterRemoteKey

@Dao
interface CharacterRemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(characterRemoteKey:List<CharacterRemoteKey>)
    @Query("SELECT * FROM CharacterRemoteKey Where id=:id")
    suspend fun getRemoteKey(id:Int?):CharacterRemoteKey
    @Query("DELETE FROM CharacterRemoteKey")
    suspend fun deleteAll()
}



