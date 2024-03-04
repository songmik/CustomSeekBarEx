package com.example.customseekbarex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.SeekBar
import com.example.customseekbarex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingSeekBar()
    }

    private fun settingSeekBar() {
        // 맥스 값
        binding.seekBar.max = 30
        // 증가할 값의 단위
        binding.seekBar.progress = 1
        binding.timeTV.text = "1분"

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                // progress 바뀜에 따라 text도 같이 바뀌게 함
                binding.timeTV.text = "${progress}분"

                // seekbar의 위치와 textview의 위치를 맞춰 줌
                val newMargin = (progress.toFloat() / binding.seekBar.max) * (binding.seekBar.width - binding.timeTV.width)
                val params = binding.timeTV.layoutParams as ViewGroup.MarginLayoutParams
                params.leftMargin = newMargin.toInt()
                binding.timeTV.layoutParams = params
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }
}