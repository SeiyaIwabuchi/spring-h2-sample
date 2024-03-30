package com.example.jdbc_template_with_h2db.repositories.theme

import com.example.jdbc_template_with_h2db.entities.ThemeEntity
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.util.*
import kotlin.collections.List

@Component
class ThemeDao(
    private val _jdbc: NamedParameterJdbcTemplate
) {
    /**
     *
     */
    fun save(entity: ThemeEntity): ThemeEntity {

        val params = MapSqlParameterSource().apply {
            addValue(Columns.theme_id.name, entity.themeId)
            addValue(Columns.title.name, entity.title)
            addValue(Columns.body.name, entity.body)
        }

        val sql = """
            insert into ${Tables.theme_entity.name}(${Columns.theme_id.name}, ${Columns.title.name}, ${Columns.body.name})
            values (:${Columns.theme_id.name}, :${Columns.title.name}, :${Columns.body.name})
        """.trimIndent()

        _jdbc.update(sql, params)

        return entity
    }

    /**
     *
     */
    fun findById(id: UUID): List<ThemeEntity> {
        val params = MapSqlParameterSource().apply {
            addValue(Columns.theme_id.name, id.toString())
        }

        val sql = """ /* 自力で実装してみましょう */ """.trimIndent()

        return _jdbc.query(sql, params, _rowMapper)
    }

    /**
     *
     */
    fun findAll(): List<ThemeEntity> {
        val params = MapSqlParameterSource()

        val sql = """ /* 自力で実装してみましょう */ """.trimIndent()

        return _jdbc.query(sql, params, _rowMapper)
    }

    /**
     *
     */
    fun delete(entity: ThemeEntity) {
        // 自力で実装してみましょう
    }

    /**
     *
     */
    // 更新用のメソッドを定義しましょう

    // ----

    companion object {
        /**
         *
         */
        enum class Tables {
            theme_entity
        }

        /**
         *
         */
        enum class Columns {
            theme_id,
            title,
            body
        }

        /**
         *
         */
        object _rowMapper: RowMapper<ThemeEntity> {
            override fun mapRow(rs: ResultSet, rowNum: Int): ThemeEntity =
                ThemeEntity.emptyObject()
                    .copy(
                        themeId = rs.getString(Columns.theme_id.name)
                            .let { UUID.fromString(it) },
                        title = rs.getString(Columns.title.name),
                        body = rs.getString(Columns.body.name)
                    )
        }
    }
}