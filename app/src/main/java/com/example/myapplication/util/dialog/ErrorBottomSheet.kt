package com.example.myapplication.util.dialog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import android.viewbinding.library.bottomsheetdialogfragment.viewBinding
import com.example.myapplication.databinding.ErrorBottomsheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class ErrorBottomSheet : BottomSheetDialogFragment() {

    // ViewBinding Delegate
    private val binding: ErrorBottomsheetDialogBinding by viewBinding()

    private var codes: String? = ""

    // loved
//    lateinit var db: MovieDatabase

    companion object {

        const val TAG = "ERROR_BOTTOMSHEET"
        const val EXTRA_CODE = "extra_code"
        const val EXTRA_MESSAGE = "extra_message"
//        lateinit var selectDataParse : LovedEntity

        fun instance(code: String, message: String): ErrorBottomSheet {
            // setup data code and message from activity
            val mBundle = Bundle()
            mBundle.putString(EXTRA_CODE, code)
            mBundle.putString(EXTRA_MESSAGE, message)
//            selectDataParse = selectedData


            //bind data to this bottomsheetFragment
            val fragment = ErrorBottomSheet()
            fragment.arguments = mBundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root //return root from binding delegation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        db = Room.databaseBuilder(requireContext(), MovieDatabase::class.java, "loved-db").build()

        // init
        codes = arguments?.getString(EXTRA_CODE)

        // check error code
        if (codes == "Filter only work when button search on keyboard is pressed") {
            binding.lottieAnimationView.setAnimation("attention.json")

        }

        setupView()
        setupClick()
    }

    private fun setupClick() {
        binding.btnPositive.setOnClickListener {

//            GlobalScope.launch {
//                db.lovedDao().delete(selectDataParse)
//            }
            dismiss()

        }
    }

    private fun setupView() {
        binding.tvTitle.text = arguments?.getString(EXTRA_CODE) ?: ""
        binding.tvSubTitle.text = arguments?.getString(EXTRA_MESSAGE) ?: ""
    }
}