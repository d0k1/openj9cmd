# OpenJ9 Diagnostic tool
OpenJ9 doesn't have any command line diagnostic utilities like jstack / jmap / jstat / jcmd.
It is because OpenJ9 does not have Attach API extensions as OpenJDK have at the moment.
This project demonstrates abilities of Attach API in OpenJ9 that are added with https://github.com/eclipse/openj9/issues/2543

## Build
You need Eclipse OpenJ9 JDK and Apache Maven.

* Define environmental variable `JAVA_HOME`. It must point to OpenJ9 jdk directory.
* Run `mvn clean package`
That's it. `target` directory will contains `openj9cmd-1.0.jar`


## Prepare

You cant wrap this tool into shell script, for example openj9cmd.sh

`
${JAVA_HOME}/bin/java -classpath ${JAVA_HOME}/jre/lib/charsets.jar:${JAVA_HOME}/jre/lib/ext/cldrdata.jar:${JAVA_HOME}/jre/lib/ext/dnsns.jar:${JAVA_HOME}/jre/lib/ext/dtfj.jar:${JAVA_HOME}/jre/lib/ext/dtfjview.jar:${JAVA_HOME}/jre/lib/ext/jaccess.jar:${JAVA_HOME}/jre/lib/ext/localedata.jar:${JAVA_HOME}/jre/lib/ext/nashorn.jar:${JAVA_HOME}/jre/lib/ext/sunec.jar:${JAVA_HOME}/jre/lib/ext/sunjce_provider.jar:${JAVA_HOME}/jre/lib/ext/sunpkcs11.jar:${JAVA_HOME}/jre/lib/ext/traceformat.jar:${JAVA_HOME}/jre/lib/ext/zipfs.jar:${JAVA_HOME}/jre/lib/jce.jar:${JAVA_HOME}/jre/lib/jsse.jar:${JAVA_HOME}/jre/lib/management-agent.jar:${JAVA_HOME}/jre/lib/resources.jar:${JAVA_HOME}/jre/lib/rt.jar:${JAVA_HOME}/lib/tools.jar:./target/openj9cmd-1.0.jar com.focusit.openj9cmd "$@"
`

later you can call it
```
bash ./openj9cmd.sh 31605 threaddump /tmp/threaddump
bash ./openj9cmd.sh 31605 jstack true true jstack.txt
```

## Run

This tool provides just 3 basic functions. It can trigger OpenJ9 JavaDump and HeapDump, and it can get thread dump in jstack fashion.

### JavaDump
`bash ./openj9cmd.sh PID threaddump PATH/TO/FILE`

- PID processId
- PATH/TO/FILE file to hold all information

### HeapDump
`bash ./openj9cmd.sh PID heapdump PATH/TO/FILE`

- PID processId
- PATH/TO/FILE file to hold all information

### JStack
`bash ./openj9cmd.sh PID jstack LockeMonitors LockedSynchronizers PATH/TO/FILE`

- PID processId
- LockeMonitors whether or not information on all currently locked object monitors is to be returned (as for ThreadMXBean's JavaDoc)
- LockedSynchronizers of whether or not information on all currently locked ownable synchronizers is to be returned (as for ThreadMXBean's JavaDoc)
- PATH/TO/FILE file to hold all information
