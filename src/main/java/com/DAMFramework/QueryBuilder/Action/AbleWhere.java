package com.DAMFramework.QueryBuilder.Action;

public interface AbleWhere<T> extends AbleRun<T> {

    AbleRunOrGroupBy<T> where(String strCondition);
    AbleRunOrGroupBy<T> allRows();
    AbleHaving<T> groupBy(String ...columnNames);

}
