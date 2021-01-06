package com.rujirakongsomran.paletteapi

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.rujirakongsomran.paletteapi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        setContentView(binding.root)

        //val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.blueberries)

        createPaletteAsync((ContextCompat.getDrawable(this, R.drawable.blueberries) as BitmapDrawable).bitmap)

    }

    fun createPaletteAsync(bitmap: Bitmap) {
        Palette.from(bitmap).generate { palette ->
            // Use generated instance

            binding.tvDarkMuted.apply {
                setTextColor(palette?.darkMutedSwatch!!.titleTextColor)
                setBackgroundColor(palette.darkMutedSwatch!!.rgb)
            }
            binding.tvDarkVibrant.apply {
                setTextColor(palette?.darkVibrantSwatch!!.titleTextColor)
                setBackgroundColor(palette.darkVibrantSwatch!!.rgb)
            }
            binding.tvLightMuted.apply {
                setTextColor(palette?.lightMutedSwatch!!.titleTextColor)
                setBackgroundColor(palette.lightMutedSwatch!!.rgb)
            }
            binding.tvLightVibrant.apply {
                setTextColor(palette?.lightVibrantSwatch!!.titleTextColor)
                setBackgroundColor(palette.lightVibrantSwatch!!.rgb)
            }
            binding.tvMuted.apply {
                setTextColor(palette?.mutedSwatch!!.titleTextColor)
                setBackgroundColor(palette.mutedSwatch!!.rgb)
            }
            binding.tvVibrant.apply {
                setTextColor(palette?.vibrantSwatch!!.titleTextColor)
                setBackgroundColor(palette.vibrantSwatch!!.rgb)
            }

        }
    }

}