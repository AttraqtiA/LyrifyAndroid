package com.example.lyrifyapp.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val DATA_STORE_NAME = "Lyrify"
class DataStoreManager(context: Context) {

    private val Context.dataStore by preferencesDataStore(name = DATA_STORE_NAME)
    private val dataStore = context.dataStore

    companion object {
        val TOKEN_KEY = stringPreferencesKey("token_key")
        val USER_ID = intPreferencesKey("user_id")
    }
    //function untuk tambah token
    suspend fun saveToken(token: String, user_id: Int) {
        dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = token
//            preferences[USER_ID] = user_id
        }
    }

    val getToken: Flow<String?> = dataStore.data.map { preferences ->
        preferences[TOKEN_KEY]
    }

    val getUser_id: Flow<Int?> = dataStore.data.map { preferences ->
        preferences[USER_ID]
    }
}