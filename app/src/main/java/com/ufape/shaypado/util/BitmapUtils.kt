package com.ufape.shaypado.util

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

fun Bitmap.toTempFile(context: Context): File {
    val bos = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.PNG, 50, bos)
    val bitmapData: ByteArray = bos.toByteArray()
    val outputDir: File = context.cacheDir
    val outputFile = File.createTempFile("prefix", ".png", outputDir)
    var fos: FileOutputStream? = null
    try {
        fos = FileOutputStream(outputFile)
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    }
    try {
        fos?.write(bitmapData)
        fos?.flush()
        fos?.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return outputFile
}

fun Uri.buildBitmap(contentResolver: ContentResolver): Bitmap {
    return if (Build.VERSION.SDK_INT < 28) {
        MediaStore.Images.Media.getBitmap(
            contentResolver,
            this
        )
    } else {
        val source = ImageDecoder.createSource(contentResolver, this)
        ImageDecoder.decodeBitmap(source)
    }
}

fun File.toImageMultiPartBodyPart(name: String): MultipartBody.Part {
    val surveyBody: RequestBody = this.asRequestBody("image/*".toMediaTypeOrNull())
    return MultipartBody.Part.createFormData(
        name,
        this.name,
        surveyBody
    )
}

fun File.toPdfMultiPartBodyPart(name: String): MultipartBody.Part {
    val requestBody = this.asRequestBody("application/pdf".toMediaType())
    return MultipartBody.Part.createFormData(name, this.name, requestBody)
}

fun Bitmap.compressImage(context : Context): File? {
    val compressFormat = Bitmap.CompressFormat.WEBP
    val maxSize = 2000
    val baos = ByteArrayOutputStream()
    // Max possible quality = 100
    this.compress(compressFormat, 100, baos)
    var options = 100
    while (baos.toByteArray().size / 1024 > maxSize) {
        baos.reset()
        this.compress(compressFormat, options, baos)
        options -= if (options <= 10) {
            2
        } else {
            10
        }
    }

    val bitmapData: ByteArray = baos.toByteArray()
    val outputDir: File = context.cacheDir
    val outputFile = File.createTempFile("prefix", ".webp", outputDir)
    var fos: FileOutputStream? = null
    try {
        fos = FileOutputStream(outputFile)
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    }
    try {
        fos?.write(bitmapData)
        fos?.flush()
        fos?.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return outputFile
}

