package io.developerinator.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.Validate;
import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import io.developerinator.app.domain.Event;
import io.developerinator.app.dto.IteneraryDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventRepositoryImpl implements EventRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Event> findAll(IteneraryDto itenerary) {
        Validate.notNull(itenerary);

        Session session = entityManager.unwrap(Session.class);
        FullTextSession fullTextSession = Search.getFullTextSession(session);

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Event.class).get();
        Query query = queryBuilder.all().createQuery();
        
        return fullTextSession.createFullTextQuery(query, Event.class).list();
    }
}
