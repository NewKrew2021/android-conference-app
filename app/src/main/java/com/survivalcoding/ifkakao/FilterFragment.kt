package com.survivalcoding.ifkakao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.survivalcoding.ifkakao.databinding.FragmentFilterBinding
import com.survivalcoding.ifkakao.viewModel.ConferenceViewModel


class FilterFragment : Fragment() {

    private var _binding: FragmentFilterBinding? = null
    val binding get() = _binding!!
    val conferenceViewModel: ConferenceViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFilterBinding.inflate(layoutInflater)
        val view = binding.root

        setToggleButton()
        setApplyButton()

        return view
    }

    fun setApplyButton() {
        binding.applyButton.setOnClickListener {
            if (conferenceViewModel.selectInterests.size == 0) {
                conferenceViewModel.selectInterests.addAll(
                    mutableSetOf("서비스", "비즈니스", "기술")
                )
            }
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MainFragment>(R.id.fragment_container_view)
            }
        }
    }

    fun setInterestsButton(button: android.widget.ToggleButton, str: String) {
        button.apply {
            setOnClickListener {
                var isOn = isChecked()
                if (isOn) {
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                    conferenceViewModel.selectInterests.add(str)

                } else {
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                    conferenceViewModel.selectInterests.remove(str)
                }
            }
        }
        if (conferenceViewModel.selectInterests.contains(str)) {
            button.isChecked = true
            button.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        }
    }


    fun setToggleButton() {

        setInterestsButton(binding.serviceToggleButton, "서비스")
        setInterestsButton(binding.bzToggleButton, "비즈니스")
        setInterestsButton(binding.tecToggleButton, "기술")
        setInterestsButton(binding.dataToggleButton, "데이터")
        setInterestsButton(binding.backendToggleButton, "백엔드")
        setInterestsButton(binding.hardwareToggleButton, "하드웨어")
        setInterestsButton(binding.mobilToggleButton, "모빌리티")
        setInterestsButton(binding.contentsToggleButton, "콘텐츠")
        setInterestsButton(binding.infraToggleButton, "인프라")


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}