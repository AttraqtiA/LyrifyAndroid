package com.example.lyrifyapp.ui.screen.Chapter

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.model.APIListResponse
import com.example.lyrifyapp.model.Chapter
import kotlinx.coroutines.launch
import retrofit2.Response
import java.math.BigInteger

sealed interface ChapterListUIState {
    data class Success(
        val chapterList: Response<APIListResponse<List<Chapter>>>
    ) : ChapterListUIState

    object Error : ChapterListUIState

    object Loading : ChapterListUIState
}

class ChapterListViewModel : ViewModel() {
    var chapterListUIState: ChapterListUIState by mutableStateOf(ChapterListUIState.Loading)
        private set

    lateinit var chapters: Response<APIListResponse<List<Chapter>>>

    var totalpoints = 0

    init {
        startChapterListUIState()
    }

    fun startChapterListUIState() {
        viewModelScope.launch {
            chapters = MyDBContainer().myDBRepositories.getAllChapters(MyDBContainer.ACCESS_TOKEN)
            chapterListUIState = ChapterListUIState.Success(chapters)
        }
    }

    fun insertChapterID(chapterID: Int) {
        viewModelScope.launch {
            totalpoints = MyDBContainer().myDBRepositories.getTotalPoint(
                MyDBContainer.ACCESS_TOKEN,
                chapterID,
                MyDBContainer.USER_ID
            ).data
        }
    }
}