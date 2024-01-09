package com.example.lyrifyapp.ui.screen.Register

import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.data.DataStoreManager
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.ui.Lyrify_Screen
import kotlinx.coroutines.launch
import java.io.File
import java.io.InputStream


class RegisterViewModel : ViewModel() {

    private suspend fun createTempFileFromUri(context: Context, uri: Uri): File {
        val tempDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val tempFile = File.createTempFile("temp_image", null, tempDir)

        context.contentResolver.openInputStream(uri)?.use { input ->
            tempFile.outputStream().use { output ->
                input.copyTo(output)
            }
        }
        return tempFile
    }

    fun registerbutton(
        name: String,
        email: String,
        pass: String,
        birthdate: String,
        gender: String,
        image: Uri?,
        bio: String,
        context: Context,
        dataStore: DataStoreManager,
        navController: NavController
    ) {
        viewModelScope.launch {
            // Cek apakah URI gambar tidak null
            if (image != null) {
                val imageFile = createTempFileFromUri(context, image)

                // Dapatkan path yang dapat dibaca oleh aplikasi menggunakan FileProvider
                val imageUri = Uri.fromFile(imageFile)

                // Buat objek User dengan path file gambar
                val user = User(
                    name = name,
                    email = email,
                    password = pass,
                    birthdate = birthdate,
                    gender = gender,
                    achievement = 0,
                    description = bio,
                    image = imageUri.toString() // Menggunakan path file gambar
                )

                // Panggil fungsi register pada repository
                val token = MyDBContainer().myDBRepositories.register(user)

                if (token.toString() == "0") {
                    Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
                } else if (token.toString() != "0") {
                    navController.navigate(Lyrify_Screen.LoginView.name) {
                        popUpTo(Lyrify_Screen.RegisterView.name) { inclusive = true }
                    }
                }
            } else {
                // Buat objek User dengan path file gambar
                val user = User(
                    name = name,
                    email = email,
                    password = pass,
                    birthdate = birthdate,
                    gender = gender,
                    achievement = 0,
                    description = bio,
                    image = ""
                )

                // Panggil fungsi register pada repository
                val token = MyDBContainer().myDBRepositories.register(user)

                if (token.toString() == "0") {
                    Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
                } else if (token.toString() != "0") {
                    navController.navigate(Lyrify_Screen.LoginView.name) {
                        popUpTo(Lyrify_Screen.RegisterView.name) { inclusive = true }
                    }
                }
            }
        }
    }
}