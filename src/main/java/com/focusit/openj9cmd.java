package com.focusit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ibm.tools.attach.attacher.OpenJ9VirtualMachine;
import com.ibm.tools.attach.target.diagnostics.data.ThreadInfoResponse;
import com.sun.tools.attach.AttachNotSupportedException;

public class openj9cmd {

    public static void main(String[] args) throws IOException, AttachNotSupportedException, ClassNotFoundException {
        System.out.println("Eclipse OpenJ9 diagnostic utility");
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
            String filename = "";
            if (args.length > 4)
            {
                filename = args[4];
            }
                ThreadInfoResponse infos[] = vm.getThreadDump(Boolean.parseBoolean(args[2]), Boolean.parseBoolean(args[3]));
            PrintWriter writer = new PrintWriter(System.out);
            if (!filename.isEmpty())
            {
                writer = new PrintWriter(new FileOutputStream(new File(filename)));
                writer.println("Eclipse OpenJ9 diagnostic utility");
            }
            writer.println("Full thread dump");
            writer.println(new SimpleDateFormat().format(new Date()));

            writer.println();

            for (ThreadInfoResponse info : infos)
            {
                writer.printf("\"%s\" #%d %s prio=? os_prio=? tid=? nid=%d %s %s\n", info.getThreadName(),
                        info.getThreadId(), "daemon?", info.getNativeTId(),
                        Integer.toHexString((int)info.getNativeTId()),
                        info.getLockName() == null ? "" : "waiting " + info.getLockName());
                writer.printf("   java.lang.ThreadState: %s\n", info.getThreadState());

                for (StackTraceElement item : info.getStackTraces())
                {
                    writer.printf("\tat %s.%s(%s:%d)\n", item.getClassName(), item.getMethodName(), item.getFileName(),
                            item.getLineNumber());
                }

                writer.println("   Locked monitors:");

                for (ThreadInfoResponse.LockInfoResponse lock : info.getLockedMonitors())
                {
                    writer.printf("      - %s@%s\n", lock.getClassName(),
                            Integer.toHexString(lock.getIdentityHashCode()));

                }

                writer.println();
                writer.println("   Locked synchronizers:");

                for (ThreadInfoResponse.LockInfoResponse lock : info.getLockedSynchronizers())
                {
                    writer.printf("      - %s@%s\n", lock.getClassName(),
                            Integer.toHexString(lock.getIdentityHashCode()));

                }
                writer.println();
                writer.println();
            }
            writer.flush();
                break;
            }
        }

        vm.detach();
    }


}
