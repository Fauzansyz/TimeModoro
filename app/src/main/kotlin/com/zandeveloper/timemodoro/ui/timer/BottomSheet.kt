package com.zandeveloper.timemodoro.ui.timer

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.widget.Toast
import com.zandeveloper.timemodoro.R
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import com.zandeveloper.timemodoro.databinding.BottomSheetLayoutBinding

class BottomSheet : BottomSheetDialogFragment() {

private var _binding: BottomSheetLayoutBinding? = null
private val binding get() = _binding!!
    

    override fun getTheme(): Int = R.style.Theme_MyApp_BottomSheet

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = BottomSheetLayoutBinding.inflate(inflater, container, false)
       return binding.root
    }
    
    override fun onStart() {
        super.onStart()

        val dialog = dialog as BottomSheetDialog
        val bottomSheet =
            dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)

        bottomSheet?.let {
            val behavior = BottomSheetBehavior.from(it)

            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            behavior.peekHeight = 400 // tinggi awal
            behavior.isDraggable = true
            behavior.isHideable = true
            behavior.skipCollapsed = false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.restTime.setOnClickListener {
            Toast.makeText(context, "Timer Started!", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        
        binding.handle.setOnTouchListener { _, _ ->
            // biar user bisa drag, tapi BottomSheetDialogFragment udah support drag default
            false
        }
    }
}