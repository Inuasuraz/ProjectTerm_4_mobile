package buu.informatics.s59160081.projectterm_4.screens.game


import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160081.projectterm_4.R
import buu.informatics.s59160081.projectterm_4.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)

        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        binding.gameViewModel = viewModel

        binding.lifecycleOwner = this

        val args = GameFragmentArgs.fromBundle(arguments!!)

        if (viewModel._ImageNumber.value == 0) binding.NumberImage.setImageResource(R.drawable.questionmark)
        else binding.NumberImage.setImageResource(viewModel._ImageNumber.value!!)

        viewModel.eventChooseFinish.observe(this, Observer<Boolean> { hasFinished ->
            if (hasFinished) {
                binding.NumberImage.setImageResource(viewModel._ImageNumber.value!!)
                setPicture(false)
                Log.i("ScoreNum", "name : ${args.username} + score : ${viewModel._score.value!!}")
                ScoreNumber.text = viewModel._score.value!!.toString()
                viewModel.timerCheck()
            }
        })

        viewModel.eventTimeFinish.observe(this, Observer<Boolean> { hasFinished ->
            if (hasFinished) {
                binding.NumberImage.setImageResource(R.drawable.questionmark)
                setPicture(true)
                viewModel._eventTimeFinish.value = false
            }
        })

        viewModel.eventGameFinish.observe(this, Observer<Boolean> { hasFinished ->

            if (hasFinished)
                findNavController()
                .navigate(GameFragmentDirections.actionGameFragmentToShowScoreFragment( args.username , viewModel._score.value!! ))

        })

        return binding.root
    }

    private fun setPicture(state : Boolean){
        if (state){
            imageButton.isEnabled = true
            imageButton2.isEnabled = true
            imageButton3.isEnabled = true
            imageButton4.isEnabled = true
            imageButton5.isEnabled = true
            imageButton6.isEnabled = true
            imageButton7.isEnabled = true
            imageButton8.isEnabled = true
            imageButton9.isEnabled = true

        }else{
            imageButton.isEnabled = false
            imageButton2.isEnabled = false
            imageButton3.isEnabled = false
            imageButton4.isEnabled = false
            imageButton5.isEnabled = false
            imageButton6.isEnabled = false
            imageButton7.isEnabled = false
            imageButton8.isEnabled = false
            imageButton9.isEnabled = false
        }
    }

//    private fun checkAnswer() {
////
////        val args = GameFragmentArgs.fromBundle(arguments!!)
////
////
////        var randomInt = Random().nextInt(9) + 1
////
////        val drawableResource = when (randomInt) {
////            1 -> R.drawable.num_1
////            2 -> R.drawable.num_2
////            3 -> R.drawable.num_3
////            4 -> R.drawable.num_4
////            5 -> R.drawable.num_5
////            6 -> R.drawable.num_6
////            7 -> R.drawable.num_7
////            8 -> R.drawable.num_8
////            else -> R.drawable.num_9
////        }
////
////
////        NumberImage.setImageResource(drawableResource)
////
////        if (ans == randomInt) {
////            ScoreNumber.text = (question + 1).toString()
////            question = question + 1
//////                Toast.makeText(activity, "True", Toast.LENGTH_LONG).show()
////        }else{
//////                Toast.makeText(activity, "False", Toast.LENGTH_LONG).show()
////        }
////
////        imageButton.isEnabled = false
////        imageButton2.isEnabled = false
////        imageButton3.isEnabled = false
////        imageButton4.isEnabled = false
////        imageButton5.isEnabled = false
////        imageButton6.isEnabled = false
////        imageButton7.isEnabled = false
////        imageButton8.isEnabled = false
////        imageButton9.isEnabled = false
////        val handler = Handler()
////        handler.postDelayed({
////            // do something after 1000ms
////            NumberImage.setImageResource(R.drawable.questionmark)
////            imageButton.isEnabled = true
////            imageButton2.isEnabled = true
////            imageButton3.isEnabled = true
////            imageButton4.isEnabled = true
////            imageButton5.isEnabled = true
////            imageButton6.isEnabled = true
////            imageButton7.isEnabled = true
////            imageButton8.isEnabled = true
////            imageButton9.isEnabled = true
////
////            round = round + 1
////
////            if (round == 10){
////                var userscore = ScoreNumber.text.toString().toInt()
////
////                findNavController()
////                    .navigate(GameFragmentDirections.actionGameFragmentToShowScoreFragment( args.username , userscore))
////            }
////        }, 1000)
////
////
////    }


}
