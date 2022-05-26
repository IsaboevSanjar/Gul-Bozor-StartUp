package gulbozor.uz.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.fragment.app.Fragment
import gulbozor.uz.R
import gulbozor.uz.databinding.FragmentAddBinding
import gulbozor.uz.ui.MoreInformation

class AddFragment : Fragment() {
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private var yesPotClicked: Boolean = false
    private var noPotClicked: Boolean = false
    private var yesDungClicked: Boolean = false
    private var noDungClicked: Boolean = false
    private var smW: Int = 0
    private var smH: Int = 0
    private var pic1: Int = 0
    private var pic2: Int = 0
    private var pic3: Int = 0
    private var pic4: Int = 0
    private var pic5: Int = 0
    private var pic6: Int = 0
    private var pic7: Int = 0
    private var pic8: Int = 0

    //take picture from gallery

    private var filePath: String = ""

    private var mTakePhoto: ActivityResultLauncher<String>? = null
    var takePhoto2: ActivityResultLauncher<String>? = null
    var takePhoto3: ActivityResultLauncher<String>? = null
    var takePhoto4: ActivityResultLauncher<String>? = null
    var takePhoto5: ActivityResultLauncher<String>? = null
    var takePhoto6: ActivityResultLauncher<String>? = null
    var takePhoto7: ActivityResultLauncher<String>? = null
    var takePhoto8: ActivityResultLauncher<String>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sizeOfFlower()
        stateChecked()
        spinnerCurrencyName()
        loadFlowerImages()
        binding.weightFlowerInput.text = smW.toString() + "sm"
        binding.heightFlowerInput.text = smH.toString() + "sm"

        // TODO: shu yerga keyinchalik bir qarab qoyish kere
        binding.noPotFlower.setOnClickListener(View.OnClickListener {
            val intent = Intent(requireContext(), MoreInformation::class.java)
            startActivity(intent)
        })
    }

    private fun spinnerCurrencyName() {
        val adapterSpinner: ArrayAdapter<CharSequence> = ArrayAdapter
            .createFromResource(
                requireContext(),
                R.array.numbers,
                android.R.layout.simple_spinner_item
            )
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapterSpinner
    }

    private fun sizeOfFlower() {
        binding.weightUpSort.setOnClickListener(View.OnClickListener {
            smW += 5
            binding.weightFlowerInput.text = smW.toString() + "sm"
        })
        binding.weightDownSort.setOnClickListener(View.OnClickListener {
            if (smW >= 5) {
                smW -= 5
            }
            binding.weightFlowerInput.text = smW.toString() + "sm"
        })
        binding.heightUpSort.setOnClickListener(View.OnClickListener {
            smH += 5
            binding.heightFlowerInput.text = smH.toString() + "sm"
        })
        binding.heightDownSort.setOnClickListener(View.OnClickListener {
            if (smH >= 5) {
                smH -= 5
            }
            binding.heightFlowerInput.text = smH.toString() + "sm"
        })
    }

    private fun stateChecked() {
        binding.yesPotFlower.setOnClickListener(View.OnClickListener {
            yesPotClicked = true
            noPotClicked = false

            if (yesPotClicked) {
                binding.yesPotFlower.setBackgroundResource(R.drawable.selected_yes_no)
                binding.yesPotFlower.setTextColor(Color.WHITE)
                binding.noPotFlower.setBackgroundResource(R.drawable.no_back_empty)
                binding.noPotFlower.setTextColor(Color.parseColor("#00DF4C"))
            } else {
                binding.yesPotFlower.setBackgroundResource(R.drawable.no_back_empty)
                binding.yesPotFlower.setTextColor(Color.parseColor("#00DF4C"))
            }
        })
        binding.noPotFlower.setOnClickListener(View.OnClickListener {
            noPotClicked = true
            yesPotClicked = false
            if (noPotClicked) {
                binding.noPotFlower.setBackgroundResource(R.drawable.selected_yes_no)
                binding.noPotFlower.setTextColor(Color.WHITE)
                binding.yesPotFlower.setBackgroundResource(R.drawable.no_back_empty)
                binding.yesPotFlower.setTextColor(Color.parseColor("#00DF4C"))
            } else {
                binding.noPotFlower.setBackgroundResource(R.drawable.no_back_empty)
                binding.noPotFlower.setTextColor(Color.parseColor("#00DF4C"))
            }
        })

        binding.yesDung.setOnClickListener(View.OnClickListener {
            yesDungClicked = true
            noDungClicked = false
            if (yesDungClicked) {
                binding.yesDung.setBackgroundResource(R.drawable.selected_yes_no)
                binding.yesDung.setTextColor(Color.WHITE)
                binding.noDung.setBackgroundResource(R.drawable.no_back_empty)
                binding.noDung.setTextColor(Color.parseColor("#00DF4C"))
            } else {
                binding.yesDung.setBackgroundResource(R.drawable.no_back_empty)
                binding.yesDung.setTextColor(Color.parseColor("#00DF4C"))
            }
        })
        binding.noDung.setOnClickListener(View.OnClickListener {
            noDungClicked = true
            yesDungClicked = false
            if (noDungClicked) {
                binding.noDung.setBackgroundResource(R.drawable.selected_yes_no)
                binding.noDung.setTextColor(Color.WHITE)
                binding.yesDung.setBackgroundResource(R.drawable.no_back_empty)
                binding.yesDung.setTextColor(Color.parseColor("#00DF4C"))
            } else {
                binding.noDung.setBackgroundResource(R.drawable.no_back_empty)
                binding.noDung.setTextColor(Color.parseColor("#00DF4C"))
            }
        })
    }

    private fun loadFlowerImages() {
        binding.addPic1.setOnClickListener(View.OnClickListener {
            mTakePhoto!!.launch("image/*")
        })

        // bular rasmni multpar qilish uchun ishlatilishi kere bolgan edi
        //   val file=File(filePath)
        //   val requestBody= file.asRequestBody("image/*".toMediaTypeOrNull())
        //   val part=MultipartBody.Part.createFormData("mainAttachId",file.name,requestBody)

        binding.addPic2.setOnClickListener(View.OnClickListener {
            takePhoto2!!.launch("image/*")
        })
        binding.addPic3.setOnClickListener(View.OnClickListener {
            takePhoto3!!.launch("image/*")
        })
        binding.addPic4.setOnClickListener(View.OnClickListener {
            takePhoto4!!.launch("image/*")
        })
        binding.addPic5.setOnClickListener(View.OnClickListener {
            takePhoto5!!.launch("image/*")
        })
        binding.addPic6.setOnClickListener(View.OnClickListener {
            takePhoto6!!.launch("image/*")
        })
        binding.addPic7.setOnClickListener(View.OnClickListener {
            takePhoto7!!.launch("image/*")
        })
        binding.addPic8.setOnClickListener(View.OnClickListener {
            takePhoto8!!.launch("image/*")
        })
        mTakePhoto = registerForActivityResult(
            GetContent()
        ) { result -> // TODO: 5/20/2022  image Viw qilib tugirla
            if (result != null) {
                when {
                    pic1 == 0 -> {
                        binding.addPic1.setImageURI(result)
                        binding.addPic1.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                        binding.addPic1.setPadding(0, 0, 0, 0)
                        pic1 = 1

                    }
                    pic2 == 0 -> {
                        binding.addPic2.setImageURI(result)
                        binding.addPic2.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                        binding.addPic2.setPadding(0, 0, 0, 0)
                        pic2 = 1
                    }
                    pic3 == 0 -> {
                        binding.addPic3.setImageURI(result)
                        binding.addPic3.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                        binding.addPic3.setPadding(0, 0, 0, 0)
                        pic3 = 1
                    }
                    pic4 == 0 -> {
                        binding.addPic4.setImageURI(result)
                        binding.addPic4.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                        binding.addPic4.setPadding(0, 0, 0, 0)
                        pic4 = 1
                    }
                    pic5 == 0 -> {
                        binding.addPic5.setImageURI(result)
                        binding.addPic5.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                        binding.addPic5.setPadding(0, 0, 0, 0)
                        pic5 = 1
                    }
                    pic6 == 0 -> {
                        binding.addPic6.setImageURI(result)
                        binding.addPic6.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                        binding.addPic6.setPadding(0, 0, 0, 0)
                        pic6 = 1
                    }
                    pic7 == 0 -> {
                        binding.addPic7.setImageURI(result)
                        binding.addPic7.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                        binding.addPic7.setPadding(0, 0, 0, 0)
                        pic7 = 1
                    }
                    pic8 == 0 -> {
                        binding.addPic8.setImageURI(result)
                        binding.addPic8.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                        binding.addPic8.setPadding(0, 0, 0, 0)
                        pic8 = 1
                    }
                    else -> {
                        Toast.makeText(requireContext(), "Rasmlar yetarli", Toast.LENGTH_SHORT)
                            .show()
                        binding.addPic1.setImageURI(result)
                        binding.addPic1.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                        binding.addPic1.setPadding(0, 0, 0, 0)
                        pic1 = 0
                    }
                }
            }

        }
        takePhoto2 = registerForActivityResult(
            GetContent()
        ) { result ->
            if (result != null) {
                binding.addPic2.setImageURI(result)
                binding.addPic2.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                binding.addPic2.setPadding(0, 0, 0, 0)
                pic2 = 1
            }
        }
        takePhoto3 = registerForActivityResult(
            GetContent()
        ) { result ->
            if (result != null) {
                binding.addPic3.setImageURI(result)
                binding.addPic3.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                binding.addPic3.setPadding(0, 0, 0, 0)
                pic3 = 1
            }
        }
        takePhoto4 = registerForActivityResult(
            GetContent()
        ) { result ->
            if (result != null) {
                binding.addPic4.setImageURI(result)
                binding.addPic4.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                binding.addPic4.setPadding(0, 0, 0, 0)
                pic4 = 1
            }
        }
        takePhoto5 = registerForActivityResult(
            GetContent()
        ) { result ->
            if (result != null) {
                binding.addPic5.setImageURI(result)
                binding.addPic5.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                binding.addPic5.setPadding(0, 0, 0, 0)
                pic5 = 1
            }
        }
        takePhoto6 = registerForActivityResult(
            GetContent()
        ) { result ->
            if (result != null) {
                binding.addPic6.setImageURI(result)
                binding.addPic6.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                binding.addPic6.setPadding(0, 0, 0, 0)
                pic6 = 1
            }
        }
        takePhoto7 = registerForActivityResult(
            GetContent()
        ) { result ->
            if (result != null) {
                binding.addPic7.setImageURI(result)
                binding.addPic7.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                binding.addPic7.setPadding(0, 0, 0, 0)
                pic7 = 1
            }
        }
        takePhoto8 = registerForActivityResult(
            GetContent()
        ) { result ->
            if (result != null) {
                binding.addPic8.setImageURI(result)
                binding.addPic8.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                binding.addPic8.setPadding(0, 0, 0, 0)
                pic8 = 1
            }
        }

    }
}