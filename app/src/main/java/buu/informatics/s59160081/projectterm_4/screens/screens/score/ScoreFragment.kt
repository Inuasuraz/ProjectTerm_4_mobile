package buu.informatics.s59160081.projectterm_4.screens.screens.score


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160081.projectterm_4.R
import buu.informatics.s59160081.projectterm_4.databinding.FragmentScoreBinding
import buu.informatics.s59160081.projectterm_4.screens.database.GameScoreDatabase
import buu.informatics.s59160081.projectterm_4.screens.screens.main.MainFragmentDirections
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val application = requireNotNull(this.activity).application

        val dataSource = GameScoreDatabase.getInstance(application).gameScoreDatabaseDao

        val viewModelFactory = ScoreViewModelFactory(dataSource, application)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ScoreViewModel::class.java)

        val args =
            ScoreFragmentArgs.fromBundle(
                arguments!!
            )

        val adapter = ScoreAdapter()

        val binding = DataBindingUtil.inflate<FragmentScoreBinding>(inflater,
            R.layout.fragment_score,container,false)

        binding.highscoreList.adapter = adapter
        binding.setLifecycleOwner(this)

        viewModel.score.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

//        viewModel.eventInputFinish.observe(this, Observer<Boolean> { hasFinished ->
//            if (hasFinished) {
//                Log.i("SSSS","WWWW")
//                findNavController()
//                    .navigate(
//                        ScoreFragmentDirections.actionScoreFragmentToMenuFragment(
//                            args.username,
//                            args.userscore
//                        )
//                    )
//            }
//        })

        binding.apply{
//            backButton.setOnClickListener { findNavController()
//                .navigate(R.id.action_scoreFragment_to_menuFragment) }
            backButton.setOnClickListener { findNavController()
                .navigate(
                    ScoreFragmentDirections.actionScoreFragmentToMenuFragment(
                        args.username,
                        args.userscore
                    )
                ) }

        }

        return binding.root
    }

}

