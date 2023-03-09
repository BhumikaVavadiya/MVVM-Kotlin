package com.example.testdemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testdemo.Model.*
import com.example.testdemo.R
import kotlinx.android.synthetic.main.parent_item.view.*
import kotlinx.android.synthetic.main.sub_item.view.*

class MainAdapter(private val context: Context) :
    RecyclerView.Adapter<MainAdapter.QuestionViewHolder>() {
    private val mProblems = ArrayList<ProblemsItem>()
    fun setItems(item: List<ProblemsItem>?) {
        if (item == null) return
        mProblems.clear()
        mProblems.addAll(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.onBind(mProblems[position])
    }

    override fun getItemCount(): Int {
        return mProblems.size
    }

    inner class QuestionViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        private val title = containerView.tv_Title
        private val img_plus = containerView.img_plus
        private val rv_child = containerView.rv_child
        private var mAdapter: DiabetesAdapter? = null

        init {
            mAdapter = DiabetesAdapter(context)
            rv_child?.layoutManager = LinearLayoutManager(containerView.context)
            rv_child?.adapter = mAdapter
        }

        fun onBind(problemsItem: ProblemsItem?) {
            title?.text = "Problems"
            img_plus.setOnClickListener(View.OnClickListener {
                setVisibilityRecycleview(context, rv_child, img_plus)
            })
            mAdapter?.setItems(problemsItem?.diabetes)
        }
    }
}
private fun setVisibilityRecycleview(context: Context, rvChild: RecyclerView, imgPlus: ImageView) {
    imgPlus.setOnClickListener(View.OnClickListener {
        if (rvChild.visibility == View.VISIBLE) {
            imgPlus.setImageResource(R.drawable.ic_add)
            rvChild!!.visibility = View.GONE
        } else {
            imgPlus.setImageResource(R.drawable.ic_remove)
            rvChild!!.visibility = View.VISIBLE
        }
    })
}

class DiabetesAdapter(private val context: Context) :
    RecyclerView.Adapter<DiabetesAdapter.QuestionViewHolder>() {
    private val mDiabetes = ArrayList<DiabetesItem>()

    fun setItems(item: List<DiabetesItem>?) {
        if (item == null) return
        mDiabetes.clear()
        mDiabetes.addAll(item)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.onBind(mDiabetes[position])
    }

    override fun getItemCount(): Int {
        return mDiabetes.size
    }

    inner class QuestionViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        private val title = containerView.tv_Title
        private val img_plus = containerView.img_plus
        private val rv_child = containerView.rv_child
        private var mAdapter: MedicationsAdapter? = null

        init {
            mAdapter = MedicationsAdapter(context)
            rv_child?.layoutManager = LinearLayoutManager(containerView.context)
            rv_child?.adapter = mAdapter
        }

        fun onBind(problemsItem: DiabetesItem?) {
            title?.text = "Diabetes"
            img_plus.setOnClickListener(View.OnClickListener {
                setVisibilityRecycleview(context, rv_child, img_plus)
            })
            mAdapter?.setItems(problemsItem?.medications)
        }
    }
}

class MedicationsAdapter(private val context: Context) :
    RecyclerView.Adapter<MedicationsAdapter.QuestionViewHolder>() {
    private val mMedications = ArrayList<MedicationsItem>()

    fun setItems(item: List<MedicationsItem>?) {
        if (item == null) return
        mMedications.clear()
        mMedications.addAll(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.onBind(mMedications[position])
    }

    override fun getItemCount(): Int {
        return mMedications.size
    }

    inner class QuestionViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        private val title = containerView.tv_Title
        private val img_plus = containerView.img_plus
        private val rv_child = containerView.rv_child
        private var mAdapter: MedicationsClassesAdapter? = null

        init {
            mAdapter = MedicationsClassesAdapter(context)
            rv_child?.layoutManager = LinearLayoutManager(containerView.context)
            rv_child?.adapter = mAdapter
        }

        fun onBind(problemsItem: MedicationsItem?) {
            title?.text = "Medications"
            img_plus.setOnClickListener(View.OnClickListener {
                setVisibilityRecycleview(context, rv_child, img_plus)
            })
            mAdapter?.setItems(problemsItem?.medicationsClasses)
        }
    }
}

class MedicationsClassesAdapter(private val context: Context) :
    RecyclerView.Adapter<MedicationsClassesAdapter.QuestionViewHolder>() {
    private val mMedicationsClasses = ArrayList<MedicationsClassesItem>()

    fun setItems(item: List<MedicationsClassesItem>?) {
        if (item == null) return
        mMedicationsClasses.clear()
        mMedicationsClasses.addAll(item)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.onBind(mMedicationsClasses[position])
    }

    override fun getItemCount(): Int {
        return mMedicationsClasses.size
    }

    inner class QuestionViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        private val title = containerView.tv_Title
        private val img_plus = containerView.img_plus
        private val rv_child = containerView.rv_child
        private var mAdapter: ClassNameAdapter? = null

        init {
            mAdapter = ClassNameAdapter(context)
            rv_child?.layoutManager = LinearLayoutManager(containerView.context)
            rv_child?.adapter = mAdapter
        }

        fun onBind(problemsItem: MedicationsClassesItem?) {
            title?.text = "Medications Classes"
            img_plus.setOnClickListener(View.OnClickListener {
                setVisibilityRecycleview(context, rv_child, img_plus)
            })
            mAdapter?.setItems(problemsItem?.className)
        }
    }
}

class ClassNameAdapter(private val context: Context) :
    RecyclerView.Adapter<ClassNameAdapter.QuestionViewHolder>() {
    private val mClassName = ArrayList<ClassNameItem>()

    fun setItems(item: List<ClassNameItem>?) {
        if (item == null) return
        mClassName.clear()
        mClassName.addAll(item)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.onBind(mClassName[position])
    }

    override fun getItemCount(): Int {
        return mClassName.size
    }

    inner class QuestionViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        private val title = containerView.tv_Title
        private val img_plus = containerView.img_plus
        private val rv_child = containerView.rv_child
        private var mAdapter: MedicineAdapter? = null

        init {
            mAdapter = MedicineAdapter()
            rv_child?.layoutManager = LinearLayoutManager(containerView.context)
            rv_child?.adapter = mAdapter
        }

        fun onBind(problemsItem: ClassNameItem?) {
            title?.text = "Class Name"
            img_plus.setOnClickListener(View.OnClickListener {
                setVisibilityRecycleview(context, rv_child, img_plus)
            })
            mAdapter?.setItems(problemsItem?.associatedDrug)
            mAdapter?.addItems(problemsItem?.associatedDrug2)
        }
    }
}

class MedicineAdapter() :
    RecyclerView.Adapter<MedicineAdapter.QuestionViewHolder>() {

    private val mDrugItemArrayList = ArrayList<AssociatedDrugItem>()

    fun setItems(item: List<AssociatedDrugItem>?) {
        if (item == null) return
        mDrugItemArrayList.clear()
        mDrugItemArrayList.addAll(item)
        notifyDataSetChanged()
    }

    fun addItems(item: List<AssociatedDrugItem>?) {
        if (item == null) return
        mDrugItemArrayList.addAll(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.sub_item, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.onBind(mDrugItemArrayList[position])
    }

    override fun getItemCount(): Int {
        return mDrugItemArrayList.size
    }

    inner class QuestionViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        val tv_name = containerView.tv_name
        val tv_dose = containerView.tv_dose
        val tv_strength = containerView.tv_strength

        fun onBind(associatedDrug: AssociatedDrugItem?) {
            tv_name?.text = associatedDrug?.name
            tv_dose?.text = associatedDrug?.dose
            tv_strength?.text = associatedDrug?.strength
        }
    }
}
