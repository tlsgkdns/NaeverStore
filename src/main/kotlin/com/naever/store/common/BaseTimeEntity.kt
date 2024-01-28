package com.naever.store.common

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime


@MappedSuperclass // 엔티티에 공통 매정핑보를 공유하기 위해 사용하는 어노테이션. 부모클래스에 선언함. 엔티티가 이를 상속해서 필드 사용할 수 있게 함.
@EntityListeners(AuditingEntityListener::class) // 엔티티의 상태 변화 이벤트를 처리하는 리스너를 지정하는 어노테이션.
abstract class BaseTimeEntity {

    @CreationTimestamp // Spring Data JPA에서 제공하는 Auditing 어노테이션. 각 엔티티의 생성일자를 추적함.
    @Column(nullable = false)
    var createdAt: ZonedDateTime = ZonedDateTime.now()

    @Column(name = "is_deleted")
    var isDeleted: Boolean = false
}