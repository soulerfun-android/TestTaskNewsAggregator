package com.example.newsaggregator.data.network.model

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import nl.adaptivity.xmlutil.serialization.XmlValue

@Serializable
@XmlSerialName("credit", "http://search.yahoo.com/mrss/", "media")
data class CreditDto (
    val scheme: String?,

    @XmlValue
    val value: String
)