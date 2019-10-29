package buu.informatics.s59160081.projectterm_4.screens.show_score


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160081.projectterm_4.R
import buu.informatics.s59160081.projectterm_4.databinding.FragmentShowScoreBinding
import kotlinx.android.synthetic.main.fragment_show_score.*

/**
 * A simple [Fragment] subclass.
 */
class ShowScoreFragment : Fragment() {

    private lateinit var binding: FragmentShowScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val args = ShowScoreFragmentArgs.fromBundle(arguments!!)

        val binding = DataBindingUtil.inflate<FragmentShowScoreBinding>(inflater,
            R.layout.fragment_show_score,container,false)


        Log.i("FinalScore", "${args.userscore}")

        var finalscore = args.userscore

        val drawableResource = when (finalscore) {
            1 -> R.drawable.num_1
            2 -> R.drawable.num_2
            3 -> R.drawable.num_3
            4 -> R.drawable.num_4
            5 -> R.drawable.num_5
            6 -> R.drawable.num_6
            7 -> R.drawable.num_7
            8 -> R.drawable.num_8
            9 -> R.drawable.num_9
            10 -> R.drawable.num_10
            else -> R.drawable.num_0
        }

        binding.apply{

            finalScoreImage.setImageResource(drawableResource)

            okButton.setOnClickListener { findNavController()
                .navigate(R.id.action_showScoreFragment_to_mainFragment) }
        }


//        finalScoreImage.setImageResource(drawableResource)

        return binding.root
    }


}
