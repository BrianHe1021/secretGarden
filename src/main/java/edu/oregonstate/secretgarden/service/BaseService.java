package edu.oregonstate.secretgarden.service;

public interface BaseService<Object, ObjectKey> {

    int insert(Object record);

    Object selectByPrimaryKey(ObjectKey objectKey);

    int updateByPrimaryKey(Object object);

    int deleteByPrimaryKey(ObjectKey objectKey);
}
