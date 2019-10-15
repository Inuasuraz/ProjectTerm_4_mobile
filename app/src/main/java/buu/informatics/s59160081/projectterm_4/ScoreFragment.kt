package buu.informatics.s59160081.projectterm_4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160081.projectterm_4.databinding.FragmentMainBinding
import buu.informatics.s59160081.projectterm_4.databinding.FragmentScoreBinding
import kotlinx.android.synthetic.main.fragment_score.*

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentScoreBinding>(inflater,
            R.layout.fragment_score,container,false)

        binding.apply{
            backButton.setOnClickListener { findNavController()
                .navigate(R.id.action_scoreFragment_to_menuFragment) }
        }

        return binding.root
    }


}
