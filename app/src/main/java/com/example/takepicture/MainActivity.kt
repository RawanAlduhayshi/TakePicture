package com.example.takepicture
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity





class MainActivity : AppCompatActivity() {


    private val cameraRequest = 1888
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val photoButton: Button = findViewById(R.id.button)
        photoButton.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (cameraIntent.resolveActivity(this.packageManager) != null) {
                startActivityForResult(cameraIntent, cameraRequest)
            } else {
                Toast.makeText(this, "unable", Toast.LENGTH_SHORT).show()

            }

        }
    }
    private fun captureImage(){
        var takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takePictureIntent,cameraRequest)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var imageView: ImageView? = findViewById(R.id.imageView)
        var saveButton: Button? = findViewById(R.id.btnGallery)
        saveButton?.setOnClickListener {
            var galleryIntent = Intent()
        }
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == cameraRequest && data != null) {
            var bundle: Bundle? = data?.extras
            val photo: Bitmap = data?.extras?.get("data") as Bitmap
            imageView?.setImageBitmap(photo)
        }
    }
}



