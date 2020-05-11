package com.sangaha.sangahacamera.common.config.database;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
//        log.info("### current transaction name : {} ", TransactionSynchronizationManager.getCurrentTransactionName());
        String dataSourceType = TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? "read" : "write";
//        log.debug("### current dataSourceType : {}", dataSourceType);
        return dataSourceType;
    }


}
