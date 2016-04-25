package com.redhat.xpaasqe.bpms.uberprocess;


import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.Date;

public class CustomHandler implements WorkItemHandler {


    public void executeWorkItem(final WorkItem workItem, final WorkItemManager manager) {

        // extract parameters
//
        //   "sendDate" : new ObjectDataType("java.util.Date") ,
        // "idForContext" : new StringDataType()
        final Date sendDate = (Date) workItem.getParameter("sendDate");
        final String idForContext = (String) workItem.getParameter("idForContext");

        System.out.println(String.format("CustomHandler received this id: %s at %s", idForContext, sendDate.toString()));

        // notify manager that work item has been completed

        manager.completeWorkItem(workItem.getId(), null);

    }


    public void abortWorkItem(final WorkItem workItem, final WorkItemManager manager) {

        // Do nothing, notifications cannot be aborted

    }


}
