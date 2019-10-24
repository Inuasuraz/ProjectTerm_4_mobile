package buu.informatics.s59160081.projectterm_4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import buu.informatics.s59160081.projectterm_4.databinding.FragmentGameBinding
import buu.informatics.s59160081.projectterm_4.databinding.FragmentShowScoreBinding

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
        return inflater.inflate(R.layout.fragment_show_score, container, false)
    }


}
