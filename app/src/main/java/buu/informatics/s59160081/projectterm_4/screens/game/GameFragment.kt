package buu.informatics.s59160081.projectterm_4.screens.game


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160081.projectterm_4.R
import buu.informatics.s59160081.projectterm_4.databinding.FragmentGameBinding
import buu.informatics.s59160081.projectterm_4.screens.menu.MenuFragmentArgs
import buu.informatics.s59160081.projectterm_4.screens.menu.MenuFragmentDirections
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private var question = 0
    private var round = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)

        binding.apply{
            NumberImage.setImageResource(R.drawable.questionmark)
            okButton.setOnClickListener { checkAnswer(binding) }
        }
        return binding.root
    }


    private fun checkAnswer(fragment: FragmentGameBinding) {

        val args = GameFragmentArgs.fromBundle(arguments!!)

        fragment.apply {
            var randomInt = Random().nextInt(9) + 1

//            Toast.makeText(activity, Player.getName(),Toast.LENGTH_LONG).show()

//            var randomInt = 5

            val drawableResource = when (randomInt) {
                1 -> R.drawable.num_1
                2 -> R.drawable.num_2
                3 -> R.drawable.num_3
                4 -> R.drawable.num_4
                5 -> R.drawable.num_5
                6 -> R.drawable.num_6
                7 -> R.drawable.num_7
                8 -> R.drawable.num_8
                else -> R.drawable.num_9
//                else -> R.drawable.num_10
            }


            NumberImage.setImageResource(drawableResource)

            if (InputField.text.toString().equals(randomInt.toString())) {
                ScoreNumber.text = (question + 1).toString()
                question = question + 1
//                Toast.makeText(activity, "True", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(activity, "False", Toast.LENGTH_LONG).show()
            }

            okButton.isEnabled = false
            val handler = Handler()
            handler.postDelayed({
                // do something after 1000ms
                NumberImage.setImageResource(R.drawable.questionmark)
                okButton.isEnabled = true

                round = round + 1

                if (round == 10){
//                findNavController()
//                    .navigate(R.id.action_gameFragment_to_mainFragment)

                    var userscore = ScoreNumber.text.toString().toInt()

                    findNavController()
                        .navigate(GameFragmentDirections.actionGameFragmentToShowScoreFragment( args.username , userscore))
            }
            }, 1000)




        }
    }


}
