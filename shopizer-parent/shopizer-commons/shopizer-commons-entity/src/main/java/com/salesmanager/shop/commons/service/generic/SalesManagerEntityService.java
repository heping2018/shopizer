package com.salesmanager.shop.commons.service.generic;


import com.salesmanager.shop.commons.entity.generic.SalesManagerEntity;
import com.salesmanager.shop.commons.exception.ServiceException;

import java.io.Serializable;
import java.util.List;


/**
 * <p>Service racine pour la gestion des entités.</p>
 *
 * @param <K> the key type
 * @param <E> the entity type
 */
public interface SalesManagerEntityService<K extends Serializable & Comparable<K>, E extends SalesManagerEntity<K, ?>> extends TransactionalAspectAwareService {

    /**
     * Crée l'entité dans la base de données. Mis à part dans les tests pour faire des sauvegardes simples, utiliser
     * create() car il est possible qu'il y ait des listeners sur la création d'une entité.
     *
     * @param entity entité
     */
    void save(E entity) throws ServiceException;

    /**
     * Save all
     */
    void saveAll(Iterable<E> entities) throws ServiceException;

    /**
     * Met à jour l'entité dans la base de données.
     *
     * @param entity entité
     */
    void update(E entity) throws ServiceException;

    /**
     * Crée l'entité dans la base de données.
     *
     * @param entity entité
     */
    void create(E entity) throws ServiceException;


    /**
     * Supprime l'entité de la base de données
     *
     * @param entity entité
     */
    void delete(E entity) throws ServiceException;


    /**
     * Retourne une entité à partir de son id.
     *
     * @param id identifiant
     * @return entité
     */
    E getById(K id);

    /**
     * Renvoie la liste de l'ensemble des entités de ce type.
     *
     * @return liste d'entités
     */
    List<E> list();


    /**
     * Compte le nombre d'entités de ce type présentes dans la base.
     *
     * @return nombre d'entités
     */
    Long count();

    /**
     * Flushe la session.
     */
    void flush();


}
