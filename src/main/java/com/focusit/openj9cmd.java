package com.focusit;

import com.ibm.tools.attach.attacher.OpenJ9VirtualMachine;
import com.ibm.tools.attach.target.diagnostics.data.ThreadInfoResponse;
import com.sun.tools.attach.AttachNotSupportedException;

import java.io.IOException;

public class openj9cmd {

    public static void main(String[] args) throws IOException, AttachNotSupportedException, ClassNotFoundException {
        System.out.println("OpenJ9 diagnostic utility");
        OpenJ9VirtualMachine vm = (OpenJ9VirtualMachine) OpenJ9VirtualMachine.attach(args[0]);

        switch (args[1]) {
            case "threaddump": {
                String result = vm.triggerJavaDump(args[2]);
                System.out.println("JavaDump save to " + result);
                break;
            }

            case "heapdump": {
                String result = vm.triggerHeapDump(args[2]);
                System.out.println("HeapDump save to " + result);
                break;
            }

            case "jstack": {
                String filename = args[4];
                ThreadInfoResponse infos[] = vm.getThreadDump(Boolean.parseBoolean(args[2]), Boolean.parseBoolean(args[3]));
//                PrintWriter writer = new PrintWriter(System.out);
//
//                for(ThreadInfoResponse info:infos){
//
//                }

                break;
            }
        }

        vm.detach();
    }


}
