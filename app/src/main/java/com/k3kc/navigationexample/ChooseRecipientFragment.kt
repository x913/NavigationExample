package com.k3kc.navigationexample

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 */
class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null
    var input_recipient: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
        input_recipient = view.findViewById<TextView>(R.id.input_recipient)

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.next_btn -> {
                val recipient =  input_recipient!!.text.toString()
                if(!TextUtils.isEmpty(recipient)) {
                    val bundle = bundleOf("recipient" to recipient)
                    navController!!.navigate(R.id.action_chooseRecipientFragment2_to_specifyAmountFragment, bundle)
                }
            }
            R.id.cancel_btn -> requireActivity().onBackPressed()
        }
    }
}
