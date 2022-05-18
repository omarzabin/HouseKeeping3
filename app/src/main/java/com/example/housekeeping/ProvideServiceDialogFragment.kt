package com.example.housekeeping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment


class ProvideServiceDialogFragment: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v:View=inflater.inflate(R.layout.fragment_provide_service_dialog,container,true)
        var flag = "Choose the service "
        var flag2 = "Choose hours "

        val enrollBT: Button = v.findViewById(R.id.enrollBT)
        val cancelBT: Button = v.findViewById(R.id.canselBT)
        val spinnerVal1: Spinner = v.findViewById(R.id.categorySP2)
        val price: EditText =v.findViewById(R.id.editNumPrice)

        var i=0

        val opt = arrayOf("cooking", "washing", "dusting", "dog walking")
        var hou = arrayOf("1","7","9")
        val pricePerHour = arrayOf(100)

        spinnerVal1.adapter=
            activity?.let{
                ArrayAdapter<String>(it, android.R.layout.simple_expandable_list_item_1,opt)
            }
        // If you are working with Fragments it will not be resolved
        // You must call the activity context like this.
        //val adapter = activity?.let {
        //        ArrayAdapter<String>(
        //            it,
        //            android.R.layout.simple_spinner_item,
        //            campaignsType
        //        )
        //    }

        enrollBT.setOnClickListener{view ->
            var p:Int = price.text.toString().toInt()
            if (flag == "cooking") {
                when (flag2) {
                    "1" -> {
                        pricePerHour[i] = p
                        i++
                    }
                    "2" -> {
                        pricePerHour[i] = p
                        i++
                    }
                    "7" -> {
                        pricePerHour[i] = p
                        i++
                    }
                    "9" -> {
                        pricePerHour[i] = p
                        i++
                    }
                }

            }
            else if (flag == "washing") {
                when (flag2) {
                    "1" -> {
                        pricePerHour[i] = p
                        i++

                    }
                    "2" -> {
                        pricePerHour[i] = p
                        i++

                    }
                    "7" -> {
                        pricePerHour[i] = p
                        i++

                    }
                    "9" -> {
                        pricePerHour[i] = p
                        i++
                    }
                }
            }
            else if (flag == "dusting") {
                when (flag2) {
                    "1" -> {
                        pricePerHour[i] = p
                        i++
                    }
                    "2" -> {
                        pricePerHour[i] = p
                        i++
                    }
                    "7" -> {
                        pricePerHour[i] = p
                        i++
                    }
                    "9" -> {
                        pricePerHour[i] = p
                        i++
                    }
                }
            }
            else if (flag == "dog walking") {
                when (flag2) {
                    "1" -> {
                        pricePerHour[i] = p
                        i++
                    }
                    "2" -> {
                        pricePerHour[i] = p
                        i++
                    }
                    "7" -> {
                        pricePerHour[i] = p
                        i++
                    }
                    "9" -> {
                        pricePerHour[i] = p
                        i++
                    }
                }
            }
            Toast.makeText(context,"Done",Toast.LENGTH_SHORT).show()

        }
        spinnerVal1.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = opt[p2] // p2 is the index of selected ite

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        cancelBT.setOnClickListener {
            dismiss()
        }


        return v
    }
}
