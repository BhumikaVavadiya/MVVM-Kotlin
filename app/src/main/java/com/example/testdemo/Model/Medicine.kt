package com.example.testdemo.Model

import com.google.gson.annotations.SerializedName

data class Medicine(

    @field:SerializedName("problems")
    val problems: List<ProblemsItem>
)

data class ProblemsItem(

    @field:SerializedName("Diabetes")
    val diabetes: List<DiabetesItem>,

    @field:SerializedName("Asthma")
    val asthma: List<AsthmaItem>
)

data class DiabetesItem(

    @field:SerializedName("labs")
    val labs: List<LabsItem>,

    @field:SerializedName("medications")
    val medications: List<MedicationsItem>
)

data class AsthmaItem(
    val any: Any? = null
)

data class LabsItem(

    @field:SerializedName("missing_field")
    val missingField: String
)

data class MedicationsItem(

    @field:SerializedName("medicationsClasses")
    val medicationsClasses: List<MedicationsClassesItem>
)

data class MedicationsClassesItem(

    @field:SerializedName("className2")
    val className2: List<ClassName2Item>,

    @field:SerializedName("className")
    val className: List<ClassNameItem>
)

data class ClassName2Item(

    @field:SerializedName("associatedDrug")
    val associatedDrug: List<AssociatedDrugItem>,

    @field:SerializedName("associatedDrug#2")
    val associatedDrug2: List<AssociatedDrugItem>
)

data class ClassNameItem(

    @field:SerializedName("associatedDrug")
    val associatedDrug: List<AssociatedDrugItem>,

    @field:SerializedName("associatedDrug#2")
    val associatedDrug2: List<AssociatedDrugItem>
)

data class AssociatedDrugItem(

    @field:SerializedName("dose")
    val dose: String,

    @field:SerializedName("strength")
    val strength: String,

    @field:SerializedName("name")
    val name: String
)

