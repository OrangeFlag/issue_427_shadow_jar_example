package org.example.issue_427

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent
import org.apache.logging.log4j.LogManager


class Handler : RequestHandler<DynamodbEvent, String> {
    private val logger = LogManager.getLogger(javaClass)

    override fun handleRequest(ddbEvent: DynamodbEvent, context: Context): String {

        for (record in ddbEvent.records) {
            logger.info("${record.eventID} - ${record.eventName} - ${record.dynamodb.toString()}")
        }
        return "Successfully processed " + ddbEvent.records.size + " records."
    }
}
