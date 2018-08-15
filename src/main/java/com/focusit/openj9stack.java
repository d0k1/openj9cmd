package com.focusit;

import com.ibm.tools.attach.attacher.OpenJ9VirtualMachine;
import com.ibm.tools.attach.target.diagnostics.data.ClassInfoResponse;
import com.ibm.tools.attach.target.diagnostics.data.CompilationInfoResponse;
import com.ibm.tools.attach.target.diagnostics.data.GCInfoResponse;
import com.ibm.tools.attach.target.diagnostics.data.ThreadInfoResponse;
import com.sun.tools.attach.AttachNotSupportedException;

import java.io.IOException;

public class openj9stack {

    public static void main(String[] args) throws IOException, AttachNotSupportedException, ClassNotFoundException {
        System.out.println("OpenJ9 diagnostic utility");
        OpenJ9VirtualMachine vm = (OpenJ9VirtualMachine) OpenJ9VirtualMachine.attach("18437");
        ThreadInfoResponse info[] = vm.getThreadDump(true, true);
        CompilationInfoResponse compilationInfo = vm.getCompilationInfo();
        ClassInfoResponse classInfo = vm.getClassInfo();
        GCInfoResponse gcInfo = vm.getGCInfo();
        vm.detach();
        System.out.println(info.length);
    }
}
