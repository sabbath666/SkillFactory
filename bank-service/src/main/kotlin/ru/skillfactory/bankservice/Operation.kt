package ru.skillfactory.bankservice

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.elasticsearch.annotations.DateFormat
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.util.*

data class Operation(
        @field: Field(type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        @field: JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val date: Date,
        val operationType: OperationType,
        val sum: Int
)