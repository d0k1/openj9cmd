package com.focusit;

import com.ibm.tools.attach.attacher.OpenJ9VirtualMachine;
import com.ibm.tools.attach.target.diagnostics.ThreadDumpItem;
import com.ibm.tools.attach.target.diagnostics.ThreadInfoSerializable;
import com.sun.tools.attach.AttachNotSupportedException;

import java.io.IOException;
import java.lang.management.ThreadInfo;

public class openj9stack {

    public static void main(String[] args) throws IOException, AttachNotSupportedException, ClassNotFoundException {
        System.out.println("OpenJ9 diagnostic utility");
        OpenJ9VirtualMachine vm = (OpenJ9VirtualMachine) OpenJ9VirtualMachine.attach("25330");

        String pathToDump = vm.triggerJavaDump("");
        System.out.println("Dumpled to "+pathToDump);
        ThreadInfoSerializable items[] = vm.getThreadDump(true, true);
        System.out.println("Threads: "+items.length);
    }
}
