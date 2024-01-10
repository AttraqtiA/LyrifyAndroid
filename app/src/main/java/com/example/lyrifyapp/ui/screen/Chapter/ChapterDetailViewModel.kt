package com.example.lyrifyapp.ui.screen.Chapter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.model.APIListResponse
import com.example.lyrifyapp.model.Chapter
import com.example.lyrifyapp.model.Music
import kotlinx.coroutines.launch
import retrofit2.Response

sealed interface ChapterDetailUIState {
    data class Success(
        val musics: Response<APIListResponse<List<Music>>>
    ) : ChapterDetailUIState

    object Error : ChapterDetailUIState

    object Loading : ChapterDetailUIState
}

class ChapterDetailViewModel : ViewModel() {
    var chapterDetailUIState: ChapterDetailUIState by mutableStateOf(ChapterDetailUIState.Loading)
        private set

    lateinit var musics: Response<APIListResponse<List<Music>>>

    init {
        startChapterDetailUIState()
    }

    fun startChapterDetailUIState() {
        viewModelScope.launch {
            musics = MyDBContainer().myDBRepositories.getMusicBasedOnChapter(MyDBContainer.ACCESS_TOKEN, MyDBContainer.CHAPTER_ID)
            chapterDetailUIState = ChapterDetailUIState.Success(musics)
        }
    }
}