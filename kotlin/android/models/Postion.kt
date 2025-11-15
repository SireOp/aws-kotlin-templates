package kotlin.android.models

import android.os.Parcelable
import kotlin.parcelize.parcelize


@Parcelize
data class Postion(
    val symbol: String,
    val shares: Int,
    val avaeragePrice: Double
) : Parcelable