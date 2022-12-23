package com.Repository;

public interface Repository {
    Object SelectAll();
    Object SelectWhere(String where);
    Object SelectWhereAndGroupBy(String where, String groupBy);
    Object SelectGroupByAndHaving(String groupBy, String having);
    void Insert(Object newObject);
    void Update(Object newObject);
    void Delete(Object deletedObject);
}
