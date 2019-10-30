package buu.informatics.s59160081.projectterm_4.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160081.projectterm_4.R
import buu.informatics.s59160081.projectterm_4.databinding.ActivityMainBinding
import buu.informatics.s59160081.projectterm_4.screens.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_menu.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        val nameObserver = Observer<String> { newName ->
//            // Update the UI, in this case, a TextView.
////            playButton.text = newName
//            ResultText.text = newName
//        }
//        viewModel.name.observe(this, nameObserver)

//
//        viewModel.getUserName().observe(this, Observer {
//                user -> Toast.makeText(this, viewModel.name.value, Toast.LENGTH_LONG).show()
//        })

        this.findNavController(R.id.myNavHostFragment)
    }

    override fun onBackPressed() {
        return
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle","onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle","onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle","onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle","onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle","onDestroy Called")
    }
}
