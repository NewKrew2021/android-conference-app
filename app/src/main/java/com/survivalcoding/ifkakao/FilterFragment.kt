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

        if (conferenceViewModel.nonChoice) conferenceViewModel.selectInterests.clear()

        setToggleButton(1)
        setApplyButton()

        binding.resetToggleButton.setOnClickListener {
            conferenceViewModel.selectInterests.clear()
            setResetButton()
            setToggleButton(2)
        }

        return view
    }

    fun setApplyButton() {
        binding.applyButton.setOnClickListener {
            if (conferenceViewModel.selectInterests.size == 0) {
                conferenceViewModel.selectInterests.addAll(
                    mutableSetOf("서비스", "비즈니스", "기술")
                )
                conferenceViewModel.nonChoice = true
            } else conferenceViewModel.nonChoice = false
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MainFragment>(R.id.fragment_container_view)
            }
        }
    }

    fun setInterestsButton(button: android.widget.ToggleButton, str: String, count: Int) {
        if (count == 1) {
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
                    setResetButton()
                }
            }
        }

        if (conferenceViewModel.selectInterests.contains(str)) {
            button.isChecked = true
            button.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        } else if (count == 2) { //1일때는 필요없어서
            button.isChecked = false
            button.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
        }
    }

    fun setResetButton() {
        if (conferenceViewModel.selectInterests.size > 0) {
            binding.resetToggleButton.textOn = "초기화(${conferenceViewModel.selectInterests.size})"
            binding.resetToggleButton.isChecked = true
        } else {
            binding.resetToggleButton.textOn = "초기화"
            binding.resetToggleButton.isChecked = false
        }
    }

    fun setToggleButton(count: Int) {

        setInterestsButton(binding.serviceToggleButton, "서비스", count)
        setInterestsButton(binding.bzToggleButton, "비즈니스", count)
        setInterestsButton(binding.tecToggleButton, "기술", count)
        setInterestsButton(binding.dataToggleButton, "데이터", count)
        setInterestsButton(binding.backendToggleButton, "백엔드", count)
        setInterestsButton(binding.hardwareToggleButton, "하드웨어", count)
        setInterestsButton(binding.mobilToggleButton, "모빌리티", count)
        setInterestsButton(binding.contentsToggleButton, "콘텐츠", count)
        setInterestsButton(binding.infraToggleButton, "인프라", count)
        setResetButton()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}