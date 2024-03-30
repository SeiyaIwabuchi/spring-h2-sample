package com.example.jdbc_template_with_h2db.repositories.theme

import com.example.jdbc_template_with_h2db.entities.ThemeEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

interface ThemeRepository : CrudRepository<ThemeEntity, UUID>

@Repository
class ThemeRepositoryImpl(
    private val _themeDao: ThemeDao
) : ThemeRepository {
    override fun <S : ThemeEntity> save(entity: S): S {
        return entity.themeId?.let {
            _themeDao.update(entity) as S
        } ?: let {
            _themeDao.save(entity.copy(themeId = UUID.randomUUID())) as S
        }
    }

    override fun <S : ThemeEntity?> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Optional<ThemeEntity> {
        return Optional.ofNullable(_themeDao.findById(id).firstOrNull())
    }

    override fun existsById(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<ThemeEntity> {
        return _themeDao.findAll()
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<ThemeEntity>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<UUID>) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: ThemeEntity) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        _themeDao.deleteById(id)
    }

    override fun findAllById(ids: MutableIterable<UUID>): MutableIterable<ThemeEntity> {
        TODO("Not yet implemented")
    }
}