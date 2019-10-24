package buu.informatics.s59160081.projectterm_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160081.projectterm_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val Player: Player = Player()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main)

        this.findNavController(R.id.myNavHostFragment)
    }

    override fun onBackPressed() {
        return
    }
}
