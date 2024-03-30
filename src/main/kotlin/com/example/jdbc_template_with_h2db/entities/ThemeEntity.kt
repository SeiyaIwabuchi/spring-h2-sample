package com.example.jdbc_template_with_h2db.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID


@Entity
data class ThemeEntity(
    @Id // 主キーフィールドを示す
    @Column(columnDefinition = "text primary key")
    val themeId: UUID? = null,
    val title: String,
    val body: String
) {
    companion object {
        fun emptyObject() =
            ThemeEntity(
                title = "",
                body = ""
            )
    }
}