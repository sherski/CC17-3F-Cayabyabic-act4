package com.example.cc17_3f_cayabyabic_act4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cc17_3f_cayabyabic_act4.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.CalculateButton.setOnClickListener{
            calculateTip()}

    }
    private fun calculateTip() {

        val cost :Double =  binding.ServiceCost.text.toString().toDouble()
        val selectedId:Int = binding.TipOptions.checkedRadioButtonId
        val tipPercentage: Double = when (selectedId){
            R.id.Tip_15_Percent -> 0.15
            R.id.Tip_20_Percent -> 0.2
            else  -> 3.0
        }
        var tip:Double = cost*tipPercentage
        val roundup:Boolean = binding.RoundTip.isChecked
        if(roundup){
            tip = ceil(tip)
        }
        val currencyTip:String =NumberFormat.getInstance().format(tip)
        binding.TipResult.text = getString(R.string.Tip_Amount,currencyTip )
    }
}