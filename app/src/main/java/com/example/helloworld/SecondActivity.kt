package com.example.helloworld

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_second.*
import java.io.IOException

class SecondActivity : AppCompatActivity() {

    private val LOG_TAG = SecondActivity::class.java.simpleName

    private val CHOOSE_IMAGE_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        chooseImageButton.setOnClickListener {
            chooseImageToUpload()
        }

        saveNewPhotoButton.setOnClickListener {
            savePhoto(
                photo = Photo(
                    title = titleEditText.text.toString(),
                    description = descriptionEdittext.text.toString(),
                    imageResourceId = 0
                )
            )
        }
    }

    private fun savePhoto(photo: Photo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun chooseImageToUpload() {
        val chooseImageIntent = Intent()
        chooseImageIntent.type = "image/*"
        chooseImageIntent.action = Intent.ACTION_GET_CONTENT

        val intentChooser = Intent.createChooser(chooseImageIntent, "Choose image")
        startActivityForResult(intentChooser, CHOOSE_IMAGE_REQUEST_CODE)
        Log.d(LOG_TAG, "Choose image intent started")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CHOOSE_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val bitmap = readBitMap(data?.data)
            bitmap?.let {
                uploadedImageView.setImageBitmap(bitmap)
                Log.d(LOG_TAG, "Bitmap uploded successfully")
            }
        }

        Log.d(LOG_TAG, "OnActivityResults called")
    }

    private fun readBitMap(data: Uri?): Bitmap? {
        return try {
            MediaStore.Images.Media.getBitmap(contentResolver, data)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            null
        }
    }

}

private fun EditText.isBlank() = this.text.toString().isBlank()
